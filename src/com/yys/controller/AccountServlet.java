package com.yys.controller;

import com.yys.controller.tool.Tools;
import com.yys.entity.UserAccount;
import com.yys.factory.ServiceFactory;
import com.yys.service.IUserAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSONObject;

/**
 * AccountServlet类是一个基于Web的类，继承自HttpServlet。
 * 用于处理与用户账户相关的请求。
 */
@WebServlet("/Account")
public class AccountServlet extends HttpServlet {
    IUserAccountService userAccountService = ServiceFactory.getUserAccountService();

    /**
     * 处理GET请求，从客户端接收一个JSON对象，根据其中的"caozuo"字段值进行相应的操作。
     *
     * @param req  请求对象
     * @param resp 响应对象
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = Tools.Get(req);
        // 从JSONObject对象中获取字段"caozuo"对应的值
        System.out.println(jsonObject.getString("caozuo"));
        switch (jsonObject.getString("caozuo")) {
            case "login":
                login(resp, jsonObject);
                break;
            case "register":
                register(resp, jsonObject);
                break;
        }
    }

    /**
     * 处理POST请求，转发给doGet方法进行处理。
     *
     * @param req  请求对象
     * @param resp 响应对象
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 处理注册请求，从客户端接收用户名、密码和邮箱，并将它们传给用户账户服务类进行注册操作。
     *
     * @param resp 响应对象
     * @param jsonObject 包含用户名、密码和邮箱的JSON对象
     */
    private void register(HttpServletResponse resp, JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String email = jsonObject.getString("email");
        System.out.println(username + "," + password + "," + email);
        JSONObject json = new JSONObject();
        String msg = userAccountService.InsertUserAccount(new UserAccount(username, password, email));
        json.put("msg", msg);
        try {
            var data = json.toString().getBytes(StandardCharsets.UTF_8);
            resp.getOutputStream().write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理登录请求，从客户端接收用户名和密码，并将它们传给用户账户服务类进行登录操作。
     *
     * @param resp       响应对象
     * @param jsonObject 包含用户名和密码的JSON对象
     */
    private void login(HttpServletResponse resp, JSONObject jsonObject) throws IOException {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject json = new JSONObject();
        if (userAccountService.LoginAccount(username, password)) {
            Cookie cookie = new Cookie("username", username);
            resp.addCookie(cookie);
            json.put("msg", "成功");
        } else {
            System.out.println("用户名或密码错误");
            json.put("msg", "用户名或密码错误");
        }
        var data = json.toString().getBytes(StandardCharsets.UTF_8);
        resp.getOutputStream().write(data);
    }
}

