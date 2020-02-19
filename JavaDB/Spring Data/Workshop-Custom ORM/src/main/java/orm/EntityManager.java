package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException {
        Field id=this.getId(entity.getClass());
        id.setAccessible(true);
        Object value=id.get(entity);

        if(value == null || (int)value <=0){
            return  this.doInsert(entity,id);
        }
        return this.doUpdate(entity,id);
    }

    private boolean doUpdate(E entity, Field id) throws IllegalAccessException, NoSuchFieldException, SQLException {

        String tableName=this.getTableName(entity.getClass());
        String query = "UPDATE " +tableName +" SET ";
        String whereClause =" Where id=";

        Field[] fields =entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field=fields[i];

            field.setAccessible(true);

            Object value=field.get(entity);

            if(!field.isAnnotationPresent(Id.class)){
                query+= this.getColumnName(field)+" = ";


                if(value instanceof Date){
                    query+="'"+ new SimpleDateFormat("yyyy-MM-dd").format(value)+"'";
                }else{
                    if (value instanceof  Integer){
                        query+=value;
                    }else{
                        query+="'"+value+"'";
                    }
                }
                if(i<fields.length-1){
                    query+=",";
                }
            }else{
                whereClause+=value;
            }

        }
        query+=whereClause;

        return connection.createStatement().execute(query);
    }

    private boolean doInsert(E entity, Field id) throws IllegalAccessException, SQLException {
        String tableName=this.getTableName(entity.getClass());
        String query="Insert INTO "+tableName+" ";
        String columns="(";
        String values="(";
        Field[]fields=entity.getClass().getDeclaredFields();


        for (int i = 1; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Id.class)) {
                columns += this.getColumnName(field) ;


                Object value = field.get(entity);

                if (value instanceof Date) {
                    values += "'" + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";

                } else {
                    if(value instanceof  Integer){
                        values +=  value ;
                    }else{
                        values += "'" + value + "'";
                    }

                }

            }
            if(i<fields.length-1){
                values+=",";
                columns+=",";
            }

        }
        columns+=")";
        values+=")";
        query+=columns+" VALUES "+values;
        return connection.prepareStatement(query).execute();
    }

    public Iterable<E> find(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return this.find(table,null);
    }

    public Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        where=where!=null?"AND "+where:"";
        String query=String.format("SELECT * FROM "+this.getTableName(table)+" WHERE 1  %s ",where);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        List<E> list=new ArrayList<>();



        ResultSet result=preparedStatement.executeQuery();

        while(result.next()){

            E entity=table.getDeclaredConstructor().newInstance();

            this.fillEntity(entity,result);
            list.add(entity);
        }


        return list;
    }

    public E findFirst(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return this.findFirst(table,null);
    }

    public E findFirst(Class <E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
                where=where!=null?"AND "+where:"";
            String query=String.format("SELECT * FROM "+this.getTableName(table)+" WHERE 1  %s LIMIT 1",where);
            PreparedStatement preparedStatement = connection.prepareStatement(query);



            ResultSet result=preparedStatement.executeQuery();
            result.next();
            E entity=table.getDeclaredConstructor().newInstance();

            this.fillEntity(entity,result);
            return entity;



    }

    private Field getId(Class entity) {

        return Arrays.stream(entity.getDeclaredFields())
                .filter(field->field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(()->new UnsupportedOperationException("Entity does not have primary key"));
    }

    private String getTableName(Class entity){
        String tableName= ((Entity)entity.getAnnotation(Entity.class)).name();

//        if( !tableName.equals("")){
//            tableName=entity.getSimpleName();
//        }

        return  tableName;
    }

    private String getColumnName(Field field){
        String columnName=field.getAnnotation(Column.class).name();
        if(columnName.isEmpty()){
            columnName=field.getName();
        }
        return columnName;
    }

    private void fillEntity(E entity,ResultSet result) throws SQLException, IllegalAccessException {

            Field[] fields=entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getAnnotation(Column.class).name();

            this.fillFields(field, entity, result, fieldName);
        }
    }

    private void fillFields(Field field,Object instance,ResultSet result,String fieldName) throws SQLException, IllegalAccessException {

        if(field.getType()==int.class || field.getType()==Integer.class){
            field.set(instance,result.getInt(fieldName));
        }else if (field.getType()==long.class || field.getType() == Long.class){
            field.set(instance,result.getLong(fieldName));
        }else if (field.getType()==String.class){
            field.set(instance,result.getString(fieldName));
        }else if (field.getType()== Date.class){

            field.set(instance,result.getDate(fieldName));
        }
    }
}
