package com.yys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yys.controller.tool.GetJson;
import com.yys.entity.ShiShen;
import com.yys.entity.ShiShenAttribute;
import com.yys.entity.ShiShenSkill;
import com.yys.entity.ShiShenZhuanJi;
import com.yys.factory.ServiceFactory;
import com.yys.service.IShiShenAttributeService;
import com.yys.service.IShiShenService;
import com.yys.service.IShiShenSkillService;
import com.yys.service.IShiShenZhuanJiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/ShiShenAttribute")
public class ShiShenAttributeServlet extends HttpServlet {
    IShiShenService shiShenService = ServiceFactory.getShiShenService();
    IShiShenAttributeService shiShenAttributeService = ServiceFactory.getShiShenAttributeService();
    IShiShenZhuanJiService shiShenZhuanJiService = ServiceFactory.getShiShenZhuanJiService();
    IShiShenSkillService shiShenSkillService = ServiceFactory.getShiShenSkillService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        JSONObject jsonObject = GetJson.Get(req);
        String s = jsonObject.getString("data");
        JSONObject data = JSON.parseObject(s);
        System.out.println(jsonObject.getString("caozuo"));
        switch (jsonObject.getString("caozuo")) {
            case "get":
                GetAllData(req, resp, data.getString("shiShenName"));
                break;
            case "delete":
                JSONObject j = new JSONObject();
                j.put("msg", "删除成功");
                resp.reset();
                resp.getOutputStream().write(j.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void GetAllData(HttpServletRequest req, HttpServletResponse resp, String sName) throws ServletException, IOException {
        ArrayList<ShiShenAttribute> shiShenAttributes = shiShenAttributeService.QueryByName(sName);
        ShiShenSkill shiShenSkills = shiShenSkillService.QueryShiShenSkill(sName);
        ShiShenZhuanJi shiShenZhuanJi = shiShenZhuanJiService.QueryShiShenZhuanJi(sName);
        ShiShen shiShen = shiShenService.QueryShiShenByName(sName).get(0);
        JSONObject json = new JSONObject();
        json.put("shiShenAttribute", shiShenAttributes);
        json.put("shiShenSkill", shiShenSkills);
        json.put("shiShenZhuanJi", shiShenZhuanJi);
        json.put("shiShen", shiShen);
        resp.reset();
        resp.getOutputStream().write(json.toString().getBytes(StandardCharsets.UTF_8));
    }
}
