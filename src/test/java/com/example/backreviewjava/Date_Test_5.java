package com.example.backreviewjava;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
public class Date_Test_5 {


    @Test
    public void testDate() {
        // 0
        // -- LocalDate -------------- 仅包含年月日信息，没有时分秒等时间信息
        // -- LocalDateTime ---------- 同时包含年月日和时分秒等时间信息

        // 1
        // LocalDate.parse
        // -- 将一个符合特定格式的日期字符串解析为 LocalDate 对象
        // -- 1. LocalDate 是 Java 8 引入的日期时间 API 中的一个类，表示不带时区的日期
        // -- 2. LocalDate 只包含年、月、日信息，不包含时间（小时、分钟、秒）和时区信息
        // -- LocalDate.of(2023, 10, 5) 表示 2023 年 10 月 5 日

        // 2
        // 数据库中的 【 datetime 】 类型
        // -- 1. 通常表示日期和时间
        // -- 2. datetime 类型通常包含年、月、日、小时、分钟、秒，有时还包括毫秒

        // 3
        // DateTimeFormatter.ofPattern("yyyy-MM-dd")
        // -- DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") 是 Java 中用于格式化和解析日期时间字符串的工具


        String dateString = "2022-01-01";
        // String dateString2 = "2022/01/01";
        // -- the format must likes "yyyy-MM-dd"

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.of(2023, 10, 1);

        // 1
        // string
        String formattedDateTimeString = localDate.format(formatter); // ------------- localDate.format()

        // 2
        // LocalDateTime
        LocalDate parsedDateTime = LocalDate.parse(dateString, formatter); // -- LocalDate.parse()


        log.warn("formattedDateTimeString: {}", formattedDateTimeString);
        log.warn("parsedDateTime: {}", parsedDateTime);


        // 3
        // toOffsetDateTime()
        OffsetDateTime offsetDateTime = parsedDateTime.atStartOfDay(ZoneOffset.ofHours(8)).toOffsetDateTime();
        OffsetDateTime offsetDateTime2 = parsedDateTime.atStartOfDay(ZoneId.of("UTC")).toOffsetDateTime();
        log.warn("offsetDateTime: {}", offsetDateTime);
        log.warn("offsetDateTime2: {}", offsetDateTime2);
    }
}
