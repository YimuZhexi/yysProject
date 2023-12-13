package com.yys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.controller.tool.GetJson;
import com.yys.entity.ShiShen;
import com.yys.factory.ServiceFactory;
import com.yys.service.IShiShenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/ShiShen")
public class ShiShenServlet extends HttpServlet {
    IShiShenService shiShenService = ServiceFactory.getShiShenService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        JSONObject jsonObject = GetJson.Get(req);
        System.out.println("caozuo:" + jsonObject.getString("caozuo"));
        if (jsonObject.getString("caozuo").equals("getList")) {
            getList(req, resp, jsonObject);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void getList(HttpServletRequest req, HttpServletResponse resp, JSONObject json) throws IOException {
        ArrayList<ShiShen> list;
        System.out.println("json.getString(\"shishenname\")" + json.getString("shishenname"));
        if (json.getString("shishenname") == null) list = shiShenService.QueryShiShen();
        else list = shiShenService.QueryShiShenByName(json.getString("shishenname"));
        JSONArray jsonArray = new JSONArray();
        if (!list.isEmpty())
            jsonArray.addAll(list);
        JSONObject data = new JSONObject();
        data.put("shishen", jsonArray);
        System.out.println("shishen" + data);
        resp.reset();
        resp.getOutputStream().write(data.toString().getBytes(StandardCharsets.UTF_8));
    }
}
