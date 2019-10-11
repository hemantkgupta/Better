package com.hkg.test.stream;

import com.hkg.test.interfaces.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {

        // Create stream from a static sequence of events
        Stream<Integer> fib = Stream.of(1, 1, 2, 3);
        fib.forEach(System.out::println);

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

        Stream<Employee> employeeStream1 = Arrays.stream(emps);
        Stream<Employee> employeeStream2 = Stream.of(emps);

        //employeeStream1.forEach(System.out::println);
        employeeStream2.forEach(System.out::println);

        Collection<Employee> employeeCollection = Arrays.asList(emps);

        Stream<Employee> employeeStream3 =  employeeCollection.stream();

        Random random = new Random();
        Stream<Integer> randomIntegerStream =  Stream.generate(random::nextInt);

        Stream<String> stringStream = Stream.iterate("a", s -> s+ "a");
        stringStream.limit(5).forEach(System.out::println);

        Long[] array = new Long[]{1l, 2l, 4l, 20l, 13l};

        System.out.println(Arrays.stream(array).reduce(Long::max).get().longValue());

        IntStream.range(1,4).forEachOrdered(i -> System.out.println(array[i]));
        IntStream.range(1,4).forEachOrdered(j->array[j] = array[j]+ 4);
        IntStream.range(1,4).forEachOrdered(i -> System.out.println(array[i]));



    }
}
