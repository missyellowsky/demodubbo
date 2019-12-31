package com.wyc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyc.mapper.TestMybatis;
import domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Component
public class UserServiceImpl implements UserService {
    @SuppressWarnings("serial")
    private List<UserDO> users = new ArrayList<UserDO>() {{
        add(new UserDO(1L, "熊1", "123"));
        add(new UserDO(2L, "熊二", "234"));
        add(new UserDO(3L, "熊三", "456"));
    }};

    @Autowired
    TestMybatis testMybatis;

    @Override
    public UserDO findById(@NotBlank Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    @Override
    public List<UserDO> listUser() {
        return users;
    }

    @Override
    public List<Map<String, Object>> countGnqmcTotal() {
        return testMybatis.countGnqmcTotal();
    }
}
