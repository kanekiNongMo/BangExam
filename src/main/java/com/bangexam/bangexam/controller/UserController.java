package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.base.result.PageTableRequest;
import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.base.result.ResultCode;
import com.bangexam.bangexam.model.User;
import com.bangexam.bangexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    // 用户列表
    @RequestMapping("/list")
    @ResponseBody
    public Result<User> list(PageTableRequest request) {
        request.countOffset();
        return userService.getAllRoleByPage(request.getOffset(), request.getLimit());
    }

    // 用户搜索查询
    @RequestMapping("/findUserByFuzzyUserName")
    @ResponseBody
    public Result<User> findUserByFuzzyUserName(PageTableRequest request, String username) {
//        System.out.println("username = " + username);
        request.countOffset();
        return userService.findUserByUserName(username, request.getOffset(), request.getLimit());
    }

    // 跳转到用户添加页面
    @GetMapping("/add")
    public String addUser(Model model) {
        // 初始化User
        model.addAttribute(new User());
        return "user/user-add";
    }

    // 添加页面
    @PostMapping("/add")
    @ResponseBody
    public Result<User> addUser(User user) {
        //判断用户名是否存在
        User userByUserName = null;
        userByUserName = userService.findByUserName(user.getUsername());
        if (userByUserName != null ) {
            return Result.failure(ResultCode.USERNAME_REPEAT.getCode(), ResultCode.USERNAME_REPEAT.getMessage());
        }
        return userService.seveUser(user);
    }

    // 用户删除
    @GetMapping("/delete")
    @ResponseBody
    public Result deleteUser(User user) {
        int count = userService.deleteUser(user.getId());
        if (count < 0 ) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    // 跳转到用户更新页面
    @GetMapping("/edit")
    public String editUser(Model model , User user, HttpSession session) {
        // 初始化User
       Integer id = (Integer)session.getAttribute("id");
        model.addAttribute(userService.findById(id));
        return "user/user-edit";
    }

    // 修改密码页面
    @PostMapping("/edit")
    @ResponseBody
    public Result<User> editUser(String username, String oldPassword, String newPassword) {
        return userService.newPassword(username, oldPassword, newPassword);
    }
}
