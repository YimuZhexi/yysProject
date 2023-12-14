package com.yys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yys.controller.tool.Tools;
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
    // 处理GET请求
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求字符编码和响应字符编码为UTF-8
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        // 设置响应内容类型为json
        resp.setContentType("application/json");
        // 解析请求的参数，获取参数值
        JSONObject jsonObject = Tools.Get(req);
        // 获取参数中的data值，并转为JSONObject类型
        String s = jsonObject.getString("data");
        JSONObject data = JSON.parseObject(s);
        // 打印jsonObject中的caozuo值
        System.out.println(jsonObject.getString("caozuo"));
        // 根据caozuo的值进行不同的操作
        switch (jsonObject.getString("caozuo")) {
            case "get":
                GetAllData(resp, data.getString("shiShenName"));
                break;
            case "delete":
                DeleteData(resp, data.getString("shiShenName"));
                break;
            case "update":
                UpdateData(data);
                break;
            case "add":
                addData(resp, data);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 获取所有数据
     * 
     * @param resp HTTP响应对象
     * @param sName 式神名称
     */
    private void GetAllData(HttpServletResponse resp, String sName) throws IOException {
        // 查询式神属性列表
        ArrayList<ShiShenAttribute> shiShenAttributes = shiShenAttributeService.QueryByName(sName);
        // 查询式神技能
        ShiShenSkill shiShenSkills = shiShenSkillService.QueryShiShenSkill(sName);
        // 查询式神传记
        ShiShenZhuanJi shiShenZhuanJi = shiShenZhuanJiService.QueryShiShenZhuanJi(sName);
        // 查询式神信息
        ShiShen shiShen = shiShenService.QueryShiShenByName(sName).get(0);
        
        // 创建JSON对象
        JSONObject json = new JSONObject();
        json.put("shiShenAttribute", shiShenAttributes);
        json.put("shiShenSkill", shiShenSkills);
        json.put("shiShenZhuanJi", shiShenZhuanJi);
        json.put("shiShen", shiShen);
        
        // 重置响应对象，并将JSON对象写入响应输出流
        resp.reset();
        resp.getOutputStream().write(json.toString().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 删除数据
     *
     * @param resp HttpServletResponse对象
     * @param sName 要删除的数据的名称
     */
    private void DeleteData(HttpServletResponse resp, String sName) throws IOException {
        JSONObject j = new JSONObject();
        // 调用服务层删除对应数据
        if (shiShenAttributeService.DeleteShiShenAttributeByName(sName)
                && shiShenSkillService.DeleteShiShenSkillByName(sName)
                && shiShenZhuanJiService.DeleteShiShenZhuanJiByName(sName)
                && shiShenService.DeleteShiShen(sName)) {
            j.put("msg", "删除成功");
            resp.reset();
            resp.getOutputStream().write(j.toString().getBytes(StandardCharsets.UTF_8));
            return;
        }
        j.put("msg", "删除失败");
        resp.reset();
        resp.getOutputStream().write(j.toString().getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 更新数据
     * @param json JSON对象
     */
    private void UpdateData(JSONObject json) {
        // 获取新的式神信息
        JSONObject newShiShen = JSON.parseObject(json.getString("newShiShen"));
        // 获取新的式神传记信息
        JSONObject newShiShenZhuanJi = JSON.parseObject(json.getString("newShiShenZhuanJi"));
        // 获取新的觉醒前的技能属性信息
        JSONObject newJueXingQian = JSONObject.parseObject(json.getString("newJueXingQian"));
        // 获取新的觉醒后的技能属性信息
        JSONObject newJueXingHuo = JSONObject.parseObject(json.getString("newJueXingHuo"));

        // 查询式神信息
        ShiShen shiShen = shiShenService.QueryShiShenByName(newShiShen.getString("shiShenName")).get(0);
        // 查询技能属性信息
        ArrayList<ShiShenAttribute> shiShenAttribute = shiShenAttributeService.QueryByName(newShiShen.getString("shiShenName"));
        // 获取觉醒前属性信息
        ShiShenAttribute shiShenAttribute1 = shiShenAttribute.get(0);
        // 获取觉醒后属性信息
        ShiShenAttribute shiShenAttribute2 = shiShenAttribute.get(1);
        // 查询式神传记信息
        ShiShenZhuanJi shiShenZhuanJi = shiShenZhuanJiService.QueryShiShenZhuanJi(newShiShen.getString("shiShenName"));

        // 将觉醒前的图标转换为图片
        Tools.convertBase64ToImage(newJueXingQian.getString("jueXingQianIcon"), "/image/icon/" + shiShen.getShiShenName() + "觉醒前.png");
        // 将觉醒后的图标转换为图片
        Tools.convertBase64ToImage(newJueXingHuo.getString("jueXingHuoImage"), "/image/icon/" + shiShen.getShiShenName() + "觉醒后.png");
        // 将觉醒前的技能属性信息转换为图片
        Tools.convertBase64ToImage(newJueXingQian.getString("jueXingQianImage"), "/image/icon" + newJueXingQian.get("jueXingQianImage") + "觉醒前.png");
        // 将觉醒后的技能属性信息转换为图片
        Tools.convertBase64ToImage(newJueXingHuo.getString("jueXingHuoImage"), "/image/icon" + newJueXingHuo.get("jueXingHuoImage") + "觉醒后.png");

        // 更新式神传记信息
        shiShenZhuanJi.setZhuanJi1(newShiShenZhuanJi.getString("zhuanJi1"));
        shiShenZhuanJi.setZhuanJi2(newShiShenZhuanJi.getString("zhuanJi2"));
        shiShenZhuanJi.setZhuanJi3(newShiShenZhuanJi.getString("zhuanJi3"));
        shiShenZhuanJiService.UpdateShiShenZhuanJi(shiShenZhuanJi);

        // 设置觉醒前的技能属性信息
        setAttribute(newJueXingQian, shiShenAttribute1);
        // 设置觉醒后的技能属性信息
        setAttribute(newJueXingHuo, shiShenAttribute2);
    }


    /**
     * 添加数据
     * @param resp 响应对象
     * @param json JSON对象
     */
    private void addData(HttpServletResponse resp, JSONObject json) throws IOException {
        // 创建消息对象
        JSONObject msg = new JSONObject();
        // 解析新的式神信息
        JSONObject newShiShen = JSON.parseObject(json.getString("newShiShen"));
        // 获取式神名称
        String name = newShiShen.getString("shiShenName");
        // 判断该式神是否已存在
        if (!shiShenService.QueryShiShenByName(name).isEmpty()) {
            // 若已存在，则提示已有该式神
            msg.put("msg", "已有该式神");
            resp.reset();
            resp.getOutputStream().write(json.toString().getBytes(StandardCharsets.UTF_8));
        }
        // 构造觉醒前图标路径
        String icon1 = "/image/icon/" + name + "觉醒前.png";
        String icon2 = "/image/icon/" + name + "觉醒后.png";
        String img1 = "/image/image/" + name + "觉醒前.png";
        String img2 = "/image/image/" + name + "觉醒后.png";
        
        // 创建式神对象
        ShiShen shiShen = new ShiShen(name, icon1, icon2);
        shiShenService.AddShiShen(shiShen);
        // 将图标数据转换为图片
        Tools.convertBase64ToImage(newShiShen.getString("jueXingQianIcon"), icon1);
        Tools.convertBase64ToImage(newShiShen.getString("jueXingHouIcon"), icon2);
        // 解析觉醒前的属性信息
        JSONObject jueXingQian = JSON.parseObject(json.getString("jueXingQian"));
        // 解析觉醒后的属性信息
        JSONObject jueXingHou = JSON.parseObject(json.getString("jueXingHuo"));
        Tools.convertBase64ToImage(jueXingQian.getString("image"), img1);
        Tools.convertBase64ToImage(jueXingHou.getString("image"), img2);

        ShiShenAttribute a1 = new ShiShenAttribute();
        a1.setShiShenName(name);
        a1.setZhuangTai("觉醒前");
        setAttribute(img1, jueXingQian, a1);

        ShiShenAttribute a2 = new ShiShenAttribute();
        shiShenAttributeService.AddShiShenAttribute(a1);
        a2.setShiShenName(name);
        a2.setZhuangTai("觉醒后");
        setAttribute(img2, jueXingHou, a2);
        shiShenAttributeService.AddShiShenAttribute(a2);
        
        // 解析新的式神传记信息
        JSONObject newShiShenZhuanJi = JSON.parseObject(json.getString("newShiShenZhuanJi"));
        // 创建式神传记对象
        ShiShenZhuanJi shiShenZhuanJi = new ShiShenZhuanJi();
        // 设置式神传记的式神名称
        shiShenZhuanJi.setShiShenName(newShiShen.getString("shiShenName"));
        // 设置式神传记的
        shiShenZhuanJi.setZhuanJi1(newShiShenZhuanJi.getString("zhuanJi1"));
        shiShenZhuanJi.setZhuanJi2(newShiShenZhuanJi.getString("zhuanJi2"));
        shiShenZhuanJi.setZhuanJi3(newShiShenZhuanJi.getString("zhuanJi3"));
        // 添加式神传记到数据库
        shiShenZhuanJiService.AddShiShenZhuanJi(shiShenZhuanJi);
    }


    /**
     * 设置属性
     *
     * @param jueXingQian 式神觉醒前的数据对象
     * @param a1 式神属性对象
     */
    private void setAttribute(String img1, JSONObject jueXingQian, ShiShenAttribute a1) {
        a1.setImage(img1);
        set(jueXingQian, a1);
    }


    /**
     * 设置技能属性对象的属性值
     * @param jueXingQian 式神觉醒前的属性JSON对象
     * @param a1 式神属性对象
     */
    private void set(JSONObject jueXingQian, ShiShenAttribute a1) {
        a1.setGongJi(jueXingQian.getIntValue("gongJi")); 
        a1.setShengMing(jueXingQian.getIntValue("shengMing"));
        a1.setFangYu(jueXingQian.getIntValue("fangYu")); 
        a1.setSuDu(jueXingQian.getIntValue("suDu")); 
        a1.setBaoJi(jueXingQian.getFloatValue("baoJi")); 
        a1.setBaoJiShangHai(jueXingQian.getFloatValue("baoJiShangHai")); 
        a1.setXiaoGuoMingZhong(jueXingQian.getFloatValue("xiaoGuoMingZhong")); 
        a1.setXiaoGuoDiKang(jueXingQian.getFloatValue("xiaoGuoDiKang")); 
    }


    /**
     * 设置属性
     * @param newAttribute 新的属性对象
     * @param shiShenAttribute 式神属性对象
     */
    private void setAttribute(JSONObject newAttribute, ShiShenAttribute shiShenAttribute) {
        set(newAttribute, shiShenAttribute);
        shiShenAttributeService.UpdateShiShenAttribute(shiShenAttribute);
    }

}
