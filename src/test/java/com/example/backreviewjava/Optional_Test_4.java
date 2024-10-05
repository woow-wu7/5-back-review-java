package com.example.backreviewjava;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@SpringBootTest
public class Optional_Test_4 {

    @Test
    public void testOptional() {

        // 1
        // Optional.of ：包含非空值的 Optional 对象。
        // - 如果传入的值为 null，会抛出 NullPointerException。
        Optional<String> optional = Optional.of("Hello, World!");
        log.info("optional.get:{}", optional.get()); // Hello, World!

        // 1
        // Optional.of(null)
        // NullPointerException
//        Optional<String> optional2 = Optional.of(null);
//        log.info("optional2.get:{}", optional.get()); // java.lang.NullPointerException


        // 2
        // optional.get() ：获取包装在 Optional 中的值
        List<String> immutableList = List.of("Alice", "Bob", "Charlie");
        ArrayList<String> arrayList = new ArrayList<>(immutableList);

        Optional<List<String>> optional3 = Optional.of(immutableList);
        Optional<ArrayList<String>> optional4 = Optional.of(arrayList);

        log.info("optional3.get:{}", optional3.get()); // [Alice, Bob, Charlie]
        log.info("optional4.get:{}", optional4.get());  // [Alice, Bob, Charlie]

        log.warn("immutableList.getClass: {}", immutableList.getClass()); // class java.util.ImmutableCollections$ListN
        log.warn("arrayList.getClass: {}", arrayList.getClass()); // class java.util.ArrayList
        log.warn("optional3.getClass: {}", optional3.getClass()); // class java.util.Optional
        log.warn("optional4.getClass: {}", optional4.getClass()); // class java.util.Optional


        // 3
        // 3.1 Optional.empty(): 创建一个空的 Optional 对象。
        // 3.2 Optional.isPresent()：检查 Optional 是否包含值。
        // - 如果包含值，返回 true；
        // - 否则返回 false。
        Optional<String> optiona5 = Optional.of("Hello, World!");
        Optional<String> optiona6 = Optional.empty();
        log.warn("optiona5: {}", optiona5.isPresent());
        log.warn("optiona6: {}", optiona6.isPresent()); // class java.util.Optional
    }
}
