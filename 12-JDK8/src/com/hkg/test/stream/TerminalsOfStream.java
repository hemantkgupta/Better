package com.hkg.test.stream;

import com.hkg.test.interfaces.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalsOfStream {

    public static void main(String[] args) {


        Stream<Employee> employeeStream1 = Arrays.stream(createEmployeeArray());

        Object[] lowSalaryEmps = employeeStream1.filter(employee -> employee.getSalary() < 2000)
                                                .toArray();

        //Employee[] lowSalaryEmps2 = employeeStream1.filter(employee -> employee.getSalary() < 2000)
        //                                            .toArray(Employee[]::new);

        String[] strings = new String[] {"abc", "abcd", "abcde"};

        Collection<String> stringCollection = Arrays.asList(strings);

        Optional<String> lognestString = stringCollection.stream()
                        .max(Comparator.comparingInt(String::length));

        System.out.println(lognestString.get());


        Collection<String> words = Arrays.asList(strings);

        String concatenated = words.stream()
                .reduce("", (a, b) -> a + " " + b);

        System.out.println(concatenated);

        StringBuilder summary = stringCollection.stream()
                                         .collect(StringBuilder::new,  // factory
                                                 StringBuilder::append, // accumulator
                                                 StringBuilder::append  // combiner
                                         );

        System.out.println(summary);


        String summary2 = stringCollection.stream()
                        .collect(Collectors.joining());

        System.out.println(summary2);

        Stream<Employee> employeeStream2 = Arrays.stream(createEmployeeArray());

        TreeSet<Employee> treeSet =  employeeStream2.collect(
                                                    Collectors.toCollection(
                                                            () -> new TreeSet<Employee>(Comparator.comparingInt(Employee::getSalary))
                                                    )
                                        );


        Stream<Employee> employeeStream3 = Arrays.stream(createEmployeeArray());
        Map<Integer, List<Employee>> brackets = employeeStream3.collect(
                                                                Collectors.groupingBy(e -> e.getSalary())
                                                                );

        System.out.println(brackets);






    }

    public static Employee[] createEmployeeArray(){

        Employee[] emps = {
                new Employee("Mike", 2500),
                new Employee("Frank", 3000),
                new Employee("Hannah", 2500),
                new Employee("Rajeev", 2000),
                new Employee("Jessica", 1500),
                new Employee("Doug", 2000),
                new Employee("Chen", 3500),
                new Employee("Krish", 2200),
                new Employee("Louie", 800)
        };

        return emps;

    }
}
