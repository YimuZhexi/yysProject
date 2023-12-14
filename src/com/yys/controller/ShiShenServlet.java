package com.yys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.controller.tool.Tools;
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
        JSONObject jsonObject = Tools.Get(req);
        if (jsonObject.getString("caozuo").equals("getList")) {
            getList(resp, jsonObject);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 获取列表
     * @param resp HTTP响应对象
     * @param json 传入的JSON对象
     */
    private void getList(HttpServletResponse resp, JSONObject json) throws IOException {
        ArrayList<ShiShen> list;
        System.out.println("json.getString(\"shishenname\")" + json.getString("shishenname"));
        
        // 根据传入的式神名称查询式神列表
        if (json.getString("shishenname") == null) {
            list = shiShenService.QueryShiShen();
        } else {
            list = shiShenService.QueryShiShenByName(json.getString("shishenname"));
        }
        
        // 创建一个JSON数组
        JSONArray jsonArray = new JSONArray();
        // 将式神列表添加到JSON数组中
        if (!list.isEmpty()) {
            jsonArray.addAll(list);
        }
        
        // 创建一个JSON对象，将JSON数组添加到其中
        JSONObject data = new JSONObject();
        data.put("shishen", jsonArray);
        
        // 重置HTTP响应对象
        resp.reset();
        // 将JSON数据以UTF-8编码写入HTTP响应输出流中
        resp.getOutputStream().write(data.toString().getBytes(StandardCharsets.UTF_8));
    }

}
