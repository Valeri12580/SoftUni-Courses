package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

    private boolean doUpdate(E entity, Field id) throws IllegalAccessException, NoSuchFieldException {

        String tableName=this.getTableName(entity.getClass());
        String query = "UPDATE " +tableName +" SET ";

        Field[] fields =entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field=fields[i];

            field.setAccessible(true);

            if(!field.isAnnotationPresent(Id.class)){
                query+= this.getColumnName(field)+" = ";

                Object value=field.get(entity);
                if(value instanceof Date){
                    query+="'"+ new SimpleDateFormat("yyyy-MM-dd").format(value)+"'";
                }else{
                    if (value instanceof  Integer){
                        query+=value;
                    }else{
                        query+="'"+value+"'";
                    }
                }
            }
            if(i<fields.length-1){
                query+=",";
            }
        }
        query+="\nWhere id="+ fields.getClass().getField("id");

        return true;
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

    public Iterable<E> find(Class<E> table) {
        return null;
    }

    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    public E findFirst(Class<E> table) {
        return null;
    }

    public E findFirst(Class<E> table, String where) {
        return null;
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
}
