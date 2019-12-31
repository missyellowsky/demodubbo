package com.wyc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import domain.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Map;

@Api(value="测试api", tags="api")
@RequestMapping("/rest")
@RestController
public class TestContrller {

    @Reference
    private UserService userService;

    @ApiOperation(value="查询用户", notes="根据id来查询用户")
    @RequestMapping(value = "/getUserById/{id}",method = RequestMethod.GET)
    public UserDO getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @ApiOperation(value="查询测试数据", notes="查询测试数据")
    @RequestMapping(value = "/getTestData",method = RequestMethod.GET)
    public List<Map<String,Object>> getTestData(){
        return userService.countGnqmcTotal();
    }
}
