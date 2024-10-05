package com.example.backreviewjava;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Enumerate_Test_1 {

    // 1. enumerate 枚举 列举 v
    // 2. enumeration 枚举 n

    // 1
    public enum Enum1 {
        A, B, C, d
    }

    // 2
    @Getter
    public enum Enum2 {
        SUNDAY("100"), MONDAY("200"), TUESDAY("300");

        final String dayNumber;
        // private String dayNumber;
        // Field 'dayNumber' may be 'final'  => 不可变，应为没有 setter

        Enum2(String dayNumber) { // --------- write
            this.dayNumber = dayNumber;
        }

        public String getDayNumber() { // ---- read
            return dayNumber;
        }
    }

    // 3
    // @Getter 时 Lombok 的注解，可以不用写getter函数了 - 即不用写 getDayNumber
    @Getter
    public enum Enum3 {
        SUNDAY("100"), MONDAY("200"), TUESDAY("300");

        final String dayNumber;

        Enum3(String dayNumber) { // --------- write
            this.dayNumber = dayNumber;
        }

        //  public String getDayNumber() { // ---- read
        //    return dayNumber;
        //  }
    }


    @Test
    public void testEnumerate() {
        // 1
        Enum1 a = Enum1.A;
        log.warn("a = {}", a);

        // 2
        Enum2 monday = Enum2.MONDAY;
        log.warn("monday = {}", monday);
        log.warn("number = {}", monday.getDayNumber());

        // 2.2
        for (Enum2 day : Enum2.values()) { // ---------------------- enum.values() => for traversing enumeration.
            log.warn("day2 = {}", day); // ------------------------- value
            log.warn("day2Number = {}", day.getDayNumber()); // ---- parameter
        }

        // 3
        for (Enum3 day : Enum3.values()) {
            log.warn("day3 = {}", day); // ------------------------- value
            log.warn("day3Number = {}", day.getDayNumber()); // ---- parameter
        }
    }
}
