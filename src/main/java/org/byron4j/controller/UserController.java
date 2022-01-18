package org.byron4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.byron4j.base.ResponseVO;
import org.byron4j.beans.UserBean;
import org.byron4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseVO addUser(@Valid @RequestBody UserBean userBean){
        boolean flag = userService.save(userBean);
        return ResponseVO.ofSuccess();
    }

    @PostMapping("/list")
    public ResponseVO<List<UserBean>> list(){
        List<UserBean> list = userService.list();
        ResponseVO responseVO =
                ResponseVO.builder().data(list)
                        .code(HttpStatus.OK.value())
                        .msg(HttpStatus.OK.name())
                        .build();
        return responseVO;
    }
}
