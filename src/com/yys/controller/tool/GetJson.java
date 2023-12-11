package com.yys.controller.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetJson {
    public static JSONObject Get(HttpServletRequest request) throws IOException {
        // 创建一个StringBuilder对象用于存储读取到的内容
        StringBuilder sb = new StringBuilder();
        // 获取请求的输入流
        InputStream is = request.getInputStream();
        // 创建一个InputStreamReader对象，将输入流转换为字符流
        InputStreamReader isr = new InputStreamReader(is);
        // 创建一个BufferedReader对象，用于以缓冲方式读取字符流
        BufferedReader br = new BufferedReader(isr);
        // 用于存储每次读取到的行的内容
        String s;
        // 读取输入流中的每一行，直到读取到最后一行
        while ((s = br.readLine()) != null) {
            // 将每一行的内容添加到StringBuffer对象中
            sb.append(s);
        }
        return JSON.parseObject(sb.toString());
    }
}
