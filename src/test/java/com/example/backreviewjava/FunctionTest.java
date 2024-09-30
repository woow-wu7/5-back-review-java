package com.example.backreviewjava;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@DisplayName("JUnit5功能测试")
public class FunctionTest {

    @Test
    public void testObjectUtilsIsEmpty() {
        ArrayList arrayList = new ArrayList();
        List<String> arrayList2 = Arrays.asList("a", "b");
        int[] arrayInt = {1, 2, 3, 4, 5};

        ArrayList<Object> mixedList = new ArrayList<>();
        mixedList.add("a"); // 字符串
        mixedList.add(1);   // 整数
        mixedList.add(2);   // 整数

        System.out.printf("arrayList" + arrayList);
        System.out.printf("arrayList2" + arrayList2);
        System.out.printf("arrayInt" + arrayInt);


        System.out.println("testObjectUtilsIsEmpty");
    }

    @Test
    @DisplayName("测试方法1 @DisplayName 注解")
    public void testDisplayName1() {
        System.out.println("@DisplayName1");
    }


    @Test
    @Disabled // 禁用，This function don't execute.
    @DisplayName("测试方法 @Disabled 注解")
    public void testDisabled() {
        System.out.println("@Disabled");
    }

//    @Test
//    @RepeatedTest(2) // 重复测试2次
//    @DisplayName("测试方法 @RepeatedTest 注解")
//    public void testRepeatedTest() {
//        System.out.println("@RepeatedTest -----5");
//    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS) // 超出时间报错
    @DisplayName("测试方法 @Timeout 注解")
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1200);
        System.out.println("@Timeout");
    }

    @BeforeEach
    @DisplayName("测试方法 @BeforeEach 注解 => 在所有单元测试前执行")
    public void testBeforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    @DisplayName("测试方法 @AfterEach 注解 => 在所有单元测试后执行")
    public void testAfterEach() {
        System.out.println("@AfterEach");
    }

    @BeforeAll
    static public void testBeforeAll() {
        // 注意: @BeforeAll 和 @AfterAl 标注的方法必须是 ( 静态方法 )
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static public void testAfterAll() {
        System.out.println("@AfterAll");
    }

}
