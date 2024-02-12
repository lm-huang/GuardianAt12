package com.sky.test;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2024-01-13 14:03
 **/

//@SpringBootTest
//public class SpringDataRedisTest {
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void testRedisTemplate(){
//        System.out.println(redisTemplate);
//        HashOperations hashOperations = redisTemplate.opsForHash();
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        ListOperations listOperations = redisTemplate.opsForList();
//        SetOperations setOperations = redisTemplate.opsForSet();
//        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//    }
//
//    @Test
//    public void testString(){
//        redisTemplate.opsForValue().set("city","portland");
//        String city = (String) redisTemplate.opsForValue().get("city");
//        System.out.println(city);
//    }
//
//    @Test
//    public void testList(){
//        ListOperations listOperations = redisTemplate.opsForList();
//        listOperations.leftPushAll("mylist", "a","b","c");
//        listOperations.leftPush("mylist","d");
//        List mylist = listOperations.range("mylist", 0, 2);
//        System.out.println(mylist);
//    }
//}
