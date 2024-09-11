package com.example.backreviewjava.controller;

import com.example.backreviewjava.service.RedisService_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/redis")
public class RedisTestController_2 {

    private static final Logger logger = LoggerFactory.getLogger(RedisTestController_2.class);

    private final RedisService_2 redisService2;

    @Autowired
    public RedisTestController_2(RedisService_2 redisService2) {
        this.redisService2 = redisService2;
    }

    @PostMapping("/set")
    public ResponseEntity<?> setValue(@RequestParam String key, @RequestParam String value) {
        try {
            redisService2.setValue(key, value);
            logger.info("Set value for key: {}", key);
            return ResponseEntity.ok().body("Value set successfully");
        } catch (Exception e) {
            logger.error("Failed to set value for key: {}", key, e);
            return ResponseEntity.status(500).body("Failed to set value");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getValue(@RequestParam String key) {
        try {
            String value = redisService2.getValue(key);
            if (value != null) {
                logger.info("Get value for key: {}", key);
                return ResponseEntity.ok().body(value);
            } else {
                logger.warn("Key not found: {}", key);
                return ResponseEntity.status(404).body("Key not found");
            }
        } catch (Exception e) {
            logger.error("Failed to get value for key: {}", key, e);
            return ResponseEntity.status(500).body("Failed to get value");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteKey(@RequestParam String key) {
        try {
            redisService2.deleteKey(key);
            logger.info("Deleted key: {}", key);
            return ResponseEntity.ok().body("Key deleted successfully");
        } catch (Exception e) {
            logger.error("Failed to delete key: {}", key, e);
            return ResponseEntity.status(500).body("Failed to delete key");
        }
    }
}
