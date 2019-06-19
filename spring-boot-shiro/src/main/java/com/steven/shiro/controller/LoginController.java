//package com.steven.shiro.controller;
//
//import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//
//    @ApiOperation(value = "登录")
//    @PostMapping("/doLogin")
//    public void doLogin(String username, String password) {
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(new UsernamePasswordToken(username, password));
//            System.out.println("登录成功!");
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            System.out.println("登录失败!");
//        }
//    }
//
//    @ApiOperation(value = "你好")
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @ApiOperation(value = "请登录")
//    @GetMapping("/login")
//    public String login() {
//        return "please login!";
//    }
//}
//
