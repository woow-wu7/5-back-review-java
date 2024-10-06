package com.example.backreviewjava;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
public class Stream_Filter_Collect_Distinct_Test_2 {

    @Test
    public void streamTest1() {
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


    @Test
    public void streamTest2() {

        String ids = "1,3";

        // 1
        // Arrays.stream()
        // - .map(Integer::parseInt) => 这里是将 每个 ( String ) 类型的数据 通过 ( parseInt ) 方法转成 ( Integer ) 类型
        // - .map(Boolean::parseBoolean) => String -> Boolean
        // - .map(String::toUpperCase) => 将字符串转换为大写
        // - .map(Person::fromString) => 假设你有一个 Person 类，并且有一个方法 fromString 可以将字符串转换为 Person 对象
        List<Integer> musicIds = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 2
        // Stream.of()
        // - 这样也是也可的
        List<Integer> musicIds2 = Stream.of(ids.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());

        log.warn("musicIds=============>: {}", musicIds);
        log.warn("musicIds2=============>: {}", musicIds2);
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

