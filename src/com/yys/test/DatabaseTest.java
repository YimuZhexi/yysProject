package com.yys.test;

import com.yys.dao.impl.*;
import com.yys.entity.*;

import java.io.*;
import java.util.Base64;
import java.util.Objects;

public class DatabaseTest {
    public static void main(String[] args) {
//        ShiShenDaoImpl shiShenDao = new ShiShenDaoImpl();
//        InputStream inputStream = null;
//        byte[] data1 = null;
//        byte[] data2 = null;
//        try {
//            // 创建文件输入流，读取图片
//            inputStream = new FileInputStream("D:/program/JAVAProgram/YYSProject/src/com/yys/test/img/觉醒前Icon.png");
//            data1 = new byte[inputStream.available()];
//            inputStream.read(data1);
//            inputStream = new FileInputStream("D:/program/JAVAProgram/YYSProject/src/com/yys/test/img/觉醒后Icon.png");
//            data2 = new byte[inputStream.available()];
//            inputStream.read(data2);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 将图片转换为base64编码
//        data1 = Base64.getEncoder().encodeToString(data1).getBytes();
//        data2 = Base64.getEncoder().encodeToString(data2).getBytes();
//
//        // 创建一个ShiShen对象
//        ShiShen s = new ShiShen("桃花妖", data1, data2);

//        // 调用ShiShenDaoImpl的AddShiShen方法，添加ShiShen对象
//        shiShenDao.AddShiShen(s);
//
//        //获取指定名称的桃花妖
//        var data = shiShenDao.QueryShiShenByName("桃花妖");
//        //获取指定名称的桃花妖的酒神houIcon
//        var data1 = data.getJueXingHouIcon();
//
//        //获取指定名称的桃花妖的酒神qianIcon
//        var data2 = data.getJueXingQianIcon();
//        try {
//            //将data2转换为字符串
//            var s = new String(data2);
//            //将字符串转换为base64编码
//            var d1 = Base64.getDecoder().decode(s);
//            //将base64编码写入文件
//            OutputStream os = new FileOutputStream(new File("D:/program/JAVAProgram/YYSProject/src/com/yys/test/img/1.png"));
//            os.write(d1, 0, d1.length);
//            os.flush();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
