package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        Map<String,Department>departments=new HashMap<>();


        for (int i = 0; i <n; i++) {
            String[] input=reader.readLine().split("\\s+");
            String department=input[3];


            Employee emp=new Employee(input[0],Double.parseDouble(input[1]),input[2]);
            if(input.length==5){
                if(Character.isDigit(input[4].charAt(0))){
                    emp.setAge(Integer.parseInt(input[4]));

                }else{
                    emp.setEmail(input[4]);
                }

            }else if(input.length==6){
                emp.setAge(Integer.parseInt(input[5]));
                emp.setEmail(input[4]);
            }
            if(!departments.containsKey(department)){
                departments.put(department,new Department());
                departments.get(department).addEmployee(emp);
            }else{
                departments.get(department).addEmployee(emp);
            }




        }
        Map.Entry<String, Department> highestAverageSalary = departments.entrySet().stream().sorted((f, s) -> {
            int result = 0;
            if (s.getValue().getAverageSalary() > f.getValue().getAverageSalary()) {
                result = 1;

            } else if (s.getValue().getAverageSalary() < f.getValue().getAverageSalary()) {
                result = -1;

            }
            return result;
        }).findFirst().get();
        System.out.println(String.format("Highest Average Salary: %s",highestAverageSalary.getKey()));
        highestAverageSalary.getValue().getEmployees().stream().sorted((f,s)->Double.compare(s.getSalary(),f.getSalary())).forEach(employee->{
            System.out.println(String.format("%s %.2f %s %d",employee.getName(),employee.getSalary(),employee.getEmail(),employee.getAge()));
        });

        }
    }


