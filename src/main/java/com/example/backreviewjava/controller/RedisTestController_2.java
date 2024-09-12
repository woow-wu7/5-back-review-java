package com.example.backreviewjava.controller;

import com.example.backreviewjava.service.RedisService_2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisTestController_2 {

    // 1
    // private static final Logger logger = LoggerFactory.getLogger(RedisTestController_2.class);
    // 上面这个使用 @Slf4j 代替

    private final RedisService_2 redisService2;

    @Autowired
    public RedisTestController_2(RedisService_2 redisService2) {
        this.redisService2 = redisService2;
    }

    @PostMapping("/set")
    public ResponseEntity<?> setValue(@RequestParam String key, @RequestParam String value) {
        try {
            redisService2.setValue(key, value);
            log.info("Set value for key: {}", key);
            return ResponseEntity.status(HttpStatus.OK).body("Value set successfully");
            // return ResponseEntity.OK().body("Value set successfully"); // 和上面的代码等价
        } catch (Exception e) {
            log.error("Failed to set value for key: {}", key, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to set value");
        }
    }


    // 2
    // ResponseEntity 的作用
    // - 1. 状态码控制/status：你可以指定HTTP状态码，例如200（OK）、201（Created）、404（Not Found）等
    // - 2. 头部信息控制/header：你可以添加自定义的HTTP头部信息
    // - 3. 响应体控制/body：你可以指定响应体的内容
    // - 4. entity: 实体 n
    // ResponseEntity.status(HttpStatus.OK).body(value); // 200
    // ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get value"); // 500
    // ResponseEntity.ok().headers(headers).body("Response with custom header"); // .ok = .status(HttpStatus.OK).
    @GetMapping("/get")
    public ResponseEntity<?> getValue(@RequestParam String key) {
        log.debug("Getting value for key: {}", key);
        try {
            String value = redisService2.getValue(key);
            if (value != null) {
                log.info("Get value for key: {}", key);
                return ResponseEntity.status(HttpStatus.OK).body(value);
            } else {
                log.warn("Key not found: {}", key);
                return ResponseEntity.status(404).body("Key not found");
            }
        } catch (Exception e) {
            log.error("Failed to get value for key: {}", key, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get value");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteKey(@RequestParam String key) {
        try {
            redisService2.deleteKey(key);
            log.info("Deleted key: {}", key);
            return ResponseEntity.ok().body("Key deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete key: {}", key, e);
            return ResponseEntity.status(500).body("Failed to delete key");
        }
    }
}
