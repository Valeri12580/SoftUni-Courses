
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager, BufferedReader reader) {
        this.entityManager = entityManager;
        this.reader = reader;
    }


    public void run() {
        //ex 2:
//        secondExercise();

        //ex 3:
//        try {
//            thirdExercise();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //ex 4:
//        exerciseFour();

        //ex 5:

//        exerciseFive();

        //ex 6:
//        try {
//            exerciseSix();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //ex 7:
        //napulni bazata s nachalnite zapisi zashtoto ako go pusnesh sega,moje da ne raboti pravilno zaradi 6-ta zadacha
//        exerciseSeven();

        //ex 8:
        //izkarva rezultata no imenata sa po nagore-trqbva da komentirash  <property name="hibernate.show_sql" value="true"/>
        //                   i      <property name="hibernate.format_sql" value="true"/>

//        try {
//            exerciseEigth();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //ex 9:
        //moje da pokazva razlichen chas zaradi nastroikite na bazata !
//        exerciseNine();

        //ex 10:
//        exerciseTen();

        //ex 11:
//        try {
//            exerciseEleven();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //ex 12:
        //predi tazi zadacha trqbva da bude izpulnena 10-ta za da moje zaplatata na purviq slujitel otgovarqsht na Sa da se uvelichi
//        try {
//            exerciseTwelve();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        //ex 13:
        //otgovora zavisi ot modificiraneto na bazata ot predishnite resheniq
//        exerciseThirteen();

    }

    private void secondExercise() {
        this.entityManager.getTransaction().begin();

        List<Town> towns = this.entityManager.createQuery("Select t FROM  Town as t ", Town.class).getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                this.entityManager.detach(town);
            }
        }

        towns.stream().filter(entityManager::contains).forEach(town -> {
            town.setName(town.getName().toLowerCase());
            entityManager.persist(town);
        });

        entityManager.getTransaction().commit();

    }

    private void thirdExercise() throws IOException {
        System.out.println("Names separated by space");
        String[] names = reader.readLine().split(" ");

        try {
            Employee emp = this.entityManager.createQuery("SELECT e FROM Employee  as e WHERE e.firstName=:f AND e.lastName=:l", Employee.class).setParameter("f", names[0]).setParameter("l", names[1]).getSingleResult();
            System.out.println("Yes");

        } catch (NoResultException e) {
            System.out.println("No");
        }

    }

    private void exerciseFour() {

        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee as e " +
                "WHERE e.salary>50000", Employee.class).getResultList();

        employees.forEach(e -> System.out.println(e.getFirstName()));
    }

    private void exerciseFive() {
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee  as e WHERE e.department.name='Research and Development'", Employee.class).getResultList();
        System.out.println();
        //oburni vnimanie na tova po dolu
        employees.stream().sorted((p1, p2) -> {
            int comp = p1.getSalary().compareTo(p2.getSalary());
            if (comp == 0) {
                return Integer.compare(p1.getId(), p2.getId());
            }
            return comp;
        }).forEach(e -> System.out.println(String.format("%s %s from %s - $%.2f", e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary())));
    }

    private void exerciseSix() throws IOException {


        System.out.println("Enter last name:");
        String lastName = reader.readLine();

        Employee emp = this.entityManager.createQuery("SELECT e FROM Employee  as e WHERE e.lastName=:lastName", Employee.class).setParameter("lastName", lastName).getSingleResult();
        Address address = createAddress("Vitoshka 15");

        this.entityManager.getTransaction().begin();

        this.entityManager.detach(emp);

        emp.setAddress(address);

        this.entityManager.merge(emp);
        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

    }

    private Address createAddress(String s) {
        Address address = new Address();
        address.setText(s);
        this.entityManager.getTransaction().begin();
        System.out.println();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();
        System.out.println();

        return address;

    }

    //izchisti i napulni bazata s nachalnite zapisi tui kato ako go pusnesh sega,moje da ne raboti pravilno zaradi 6-ta zadacha
    private void exerciseSeven() {

        List<Address> addresses = this.entityManager.createQuery("SELECT a FROM Address as a ", Address.class).getResultList();

        addresses.stream().sorted((p1, p2) -> Integer.compare(p2.getEmployees().size(), p1.getEmployees().size())).limit(10).forEach(e -> System.out.println(String.format("%s %s - %d", e.getText(), e.getTown().getName(), e.getEmployees().size())));

    }


    //izkarva rezultata no imenata sa po nagore-trqbva da komentirash  <property name="hibernate.show_sql" value="true"/>
    //                   i      <property name="hibernate.format_sql" value="true"/>
    private synchronized void exerciseEigth() throws IOException {
        System.out.println("Enter  id of the employee:");
        int id = Integer.parseInt(reader.readLine());
        Employee emp = this.entityManager.createQuery("SELECT e FROM Employee  as e  WHERE e.id=:id", Employee.class).setParameter("id", id).getSingleResult();


        Set<Project> projects = emp.getProjects();

        System.out.println(String.format("%s %s - %s", emp.getFirstName(), emp.getLastName(), emp.getJobTitle()));

        projects.stream().map(e -> "\t" + e.getName()).forEach(System.out::println);
    }

    //moje da pokazva razlichen chas zaradi nastroikite na bazata !
    public void exerciseNine() {
        List<Project> projects = this.entityManager.createQuery("SELECT p from  Project as p ORDER BY  p.startDate DESC", Project.class).setMaxResults(10).getResultList();

        projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(e -> {

            System.out.println(String.format("Project name:%s\n\tProject Description:%s\n\tProject Start Date:%s\n\tProject End Date:%s", e.getName(), e.getDescription(), e.getStartDate(), e.getEndDate()));

        });
    }

    public void exerciseTen() {

        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee as e WHERE e.department.name IN('Engineering','Tool Design','Marketing','Information Services')", Employee.class).getResultList();

        this.entityManager.getTransaction().begin();
        employees.forEach(this.entityManager::detach);
        employees.forEach(e -> e.setSalary(e.getSalary().multiply(new BigDecimal("1.12"))));
        employees.forEach(this.entityManager::merge);
        this.entityManager.getTransaction().commit();

        employees.forEach(e -> System.out.println(String.format("%s %s ($%.2f)", e.getFirstName(), e.getLastName(), e.getSalary().doubleValue())));

    }

    public void exerciseEleven() throws IOException {
        System.out.println("Town name:");
        String town_name=reader.readLine();
        List<Address> addresses=this.entityManager.createQuery("SELECT a FROM Address as a WHERE a.town.name=:name",Address.class).setParameter("name",town_name).getResultList();
        int removedAddresses = addresses.size();
        this.entityManager.getTransaction().begin();
        for (Address address : addresses) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
                entityManager.flush();
            }
            entityManager.remove(address);
        }
        try{
            Town town=this.entityManager.createQuery("SELECT t FROm Town  as t where t.name=:name",Town.class).setParameter("name",town_name).getSingleResult();
            this.entityManager.remove(town);
            this.entityManager.getTransaction().commit();
            System.out.println(String.format("%d  %s in %s deleted",removedAddresses,removedAddresses==1?"address":"addressess",town_name));
        }catch (Exception ex){
            System.out.println("This town doesn't exist in the database");
        }

    }

    //trqbva da truncate-nesh bazata za da moje rezultata da ne se povliqva ot predishnite zadachi
    public void exerciseTwelve() throws IOException {
        System.out.println("Enter the pattern:");
        String pattern = reader.readLine();
        List<Employee> employees = this.entityManager.createQuery("SELECT e FROM Employee as e WHERE e.firstName LIKE :name", Employee.class).setParameter("name", pattern + "%").getResultList();
        for (Employee employee : employees) {
            System.out.println(String.format("%s %s - %s - ($%.2f)", employee.getFirstName(), employee.getLastName(),
                    employee.getJobTitle(), employee.getSalary().doubleValue()));
        }

    }

    public void exerciseThirteen() {
        List<Object[]> departments=this.entityManager.createQuery("SELECT e.department.name,MAX (e.salary) as max FROM Employee as e GROUP BY  e.department.name HAVING MAX(e.salary) <30000 OR MAX(e.salary)>50000").getResultList();
        departments.forEach(e->{
            System.out.println(String.format("%s %s",e[0],e[1]));
        });
    }


}
