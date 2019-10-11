package com.hkg.test.stream;

import com.hkg.test.interfaces.Employee;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class ParallelStreamTest {

    public static void main(String[] args) {

        Arrays.asList(1, 2, 3 , 4).parallelStream().forEachOrdered(System.out::println);

        Employee[] employees = createEmployeeArray();

        int sum = Arrays.asList(employees).parallelStream().mapToInt(Employee::getSalary).sum();

        System.out.println(sum);

        SalaryAdder salaryAdder = new SalaryAdder();

        Arrays.asList(employees).stream().parallel().forEach(salaryAdder::accept);

        System.out.println(salaryAdder.total.longValue());


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

class SalaryAdder {

    public LongAdder total;

    public void accept (Employee employee){
        total.add(employee.getSalary());
    }

    public SalaryAdder(){
        total = new LongAdder();
    }


}
