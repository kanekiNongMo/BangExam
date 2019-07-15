package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.base.result.PageTableRequest;
import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.User;
import com.bangexam.bangexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    @ResponseBody
    public Result<User> list(PageTableRequest request) {
        request.countOffset();
        return userService.getAllRoleByPage(request.getOffset(), request.getLimit());
    }
}
