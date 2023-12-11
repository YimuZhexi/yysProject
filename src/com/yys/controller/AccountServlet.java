package com.yys.controller;

import com.yys.controller.tool.GetJson;
import com.yys.entity.UserAccount;
import com.yys.factory.ServiceFactory;
import com.yys.service.IUserAccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSONObject;

@WebServlet("/Account")
public class AccountServlet extends HttpServlet {
    IUserAccountService userAccountService = ServiceFactory.getUserAccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = GetJson.Get(req);
        // 从JSONObject对象中获取字段"caozuo"对应的值
        System.out.println(jsonObject.getString("caozuo"));
        switch (jsonObject.getString("caozuo")) {
            case "login":
                login(req, resp, jsonObject);
                break;
            case "register":
                register(req, resp, jsonObject);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp, JSONObject jsonObject) {
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

    private void login(HttpServletRequest req, HttpServletResponse resp, JSONObject jsonObject) throws IOException, ServletException {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject json = new JSONObject();
        if (userAccountService.LoginAccount(username, password)) {
            req.getSession().setAttribute("username", username);
            json.put("msg", "成功");
        } else {
            System.out.println("用户名或密码错误");
            json.put("msg", "用户名或密码错误");
        }
        var data = json.toString().getBytes(StandardCharsets.UTF_8);
        resp.getOutputStream().write(data);
    }
}
