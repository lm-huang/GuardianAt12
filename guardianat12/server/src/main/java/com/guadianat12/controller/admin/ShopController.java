package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2024-01-13 16:00
 **/
@RestController("adminShopController")//prevent the conflict with the ShopController in user package
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY="SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * desc 获取营业状态
     *
     * @param status
     * @return null
     **/
    @PutMapping("/{status}")
    @ApiOperation("设置店铺营业状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺营业状态为:{}", status == 1 ? "营业中" : "已打烊");
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success();

    }

    /**
     * desc 获取营业状态
     *
     * @return null
     **/
    @GetMapping("/status")
    @ApiOperation("getting  business status as an admin")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取店铺营业状态为:{}", status == 1 ? "营业中" : "已打烊");
        return Result.success(status);
    }


}
