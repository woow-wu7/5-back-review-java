package com.example.backreviewjava;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class Stream_Filter_Collect_Distinct_Test_2 {

    @Test
    public void streamTest() {
        Person person1 = new Person("wang", 20);
        Person person2 = new Person("wu", 30);
        Person person3 = new Person("zhang", 40);
        Person person4 = new Person("zhang", 40);
        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3); // 3 and 4 are repeated/duplicated. => distinct() // distinct 不同的 清楚的 adj
        list.add(person4);

        // 1
        // stream()
        List<Person> list2 = list.stream()
                .map(p -> {
                    p.setAge(p.age * 10); // ------------------------- = p.setAge(p.getAge() * 10);
                    return p;
                })
                .distinct() // --------------------------------------- remove duplicates. 删除重复项 // distinct 不同的 清楚的 adj
                .filter(p -> p.age > 250) // ------------------------- filter
                .collect(Collectors.toList()); // -------------------- collect result to List.
        log.warn(list2.toString());

        // 2
        Integer number3 = list2.stream()
                .map(Person::getAge) // ------------------------------ .map(p -> p.age) 等价
                .reduce(0, (age1, age2) -> age1 + age2); // -- 使用 Lambda
        log.warn(number3.toString());
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    // Inner class 'Person' may be 'static'
    static class Person {
        String name;
        Integer age;
    }
}

