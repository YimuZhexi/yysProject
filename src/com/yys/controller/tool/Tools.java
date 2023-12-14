package com.yys.controller.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class Tools {
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

    /**
     * 将json字符串转换为图片
     *
     * @param jsonImageData json字符串
     * @param path          保存路径
     */
    public static void convertBase64ToImage(String jsonImageData, String path) {
        try {
            // 将base64字符串转换为图片
            byte[] imageBytes = Base64.getDecoder().decode(jsonImageData);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

            // 保存图片到指定路径
            File outputFile = new File(path);

            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
