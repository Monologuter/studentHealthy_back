package com.cqjtu.studentdocument.controller;

import com.cqjtu.studentdocument.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengyangyan
 */
@Slf4j
@Controller
public class TestController {

    @GetMapping("/api/user/login")
    @ResponseBody
    public ResponseEntity login(){
        return ResponseEntity.status(301).body("登录过期或者未登录,请退出重新登录");
    }


    @GetMapping("/login")
    public String pageLogin(){
        return "login";
    }



    @GetMapping("/success")
    @ResponseBody
    public Object success(){
        Map<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "登陆成功");
        return map;
    }

    @RequestMapping("/loginUser")
    public String loginUser(String account,String password, HttpSession session, HttpServletRequest r){
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            log.info(token.toString());
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "redirect:/swagger-ui.html";
        } catch (Exception e) {
            return "登陆失败";
        }
    }

    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }


    @RequestMapping("/loginOut")
    public String loginOut(){
        Subject subject = SecurityUtils.getSubject();
        if (subject!=null){
            subject.logout();
        }
        return "login";

    }




}
