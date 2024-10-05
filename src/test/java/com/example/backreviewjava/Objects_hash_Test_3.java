package com.example.backreviewjava;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class Objects_hash_Test_3 {

    @Test
    public void testObjectsHas() {
        String groupId = "group123";
        String userUid = "user456";

        int combinedHashCode = Objects.hash(groupId, userUid); // int

        System.out.println("Combined HashCode: " + combinedHashCode);
    }
}
