package com.hkg.test.stream;

import com.hkg.test.interfaces.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TransformAndRearrangeStream {

    public static void main(String[] args) {

        final Employee[] emps = {
                new Employee("Mike", 2500),
                new Employee("Frank", 3000),
                new Employee("Mike", 3500),
                new Employee("Josh", 4500)
        };

        //
        System.out.println("Transforming");
        Stream<Employee> employeeStream = Arrays.stream(emps);

        employeeStream.map(Employee::getName)
                    .peek(System.out::println)
                    .distinct()
                    .forEach(System.out::println);

        System.out.println("Rearranging");

        Stream<Employee> empsStream = Arrays.stream(emps);
        empsStream.sorted(
                Comparator.comparingInt(Employee::getSalary).reversed()
                )
                .map(Employee::getName)
                .forEachOrdered(System.out::println);

        System.out.println("Unordered ");

        Integer[] ints = new Integer[]{1, 2, 3, 56, 6, 8, 1};
        List<Integer> integerList = Arrays.asList(ints);

        long n = integerList.parallelStream()
                            .unordered()
                            .distinct()
                            .count();
        System.out.println(n);




    }
}
