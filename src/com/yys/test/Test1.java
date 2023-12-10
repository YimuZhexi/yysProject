package com.yys.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test1")
public class Test1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        /*//获取请求路径
        String url = req.getRequestURL().toString();
        System.out.println("url" + url);

        //获取部分请求路径
        String uri = req.getRequestURI();
        System.out.println("uri" + uri);

        //获取请求取字符串
        String queryString = req.getQueryString();
        System.out.println("queryString" + queryString);

        //获取指定名称参数，返回为字符串
        String username = req.getParameter("username");
        System.out.println("username=" + username);

        //获取指定名称的多个参数，返回为字符串数组
        String[] like = req.getParameterValues("like");
        for (String s : like) {
            System.out.println("like=" + s);
        }
        //请求跳转
        //request.getRequestDispatcher("url" ).forward(request,response);*/

        System.out.println("test1");
        /*
        //InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream("D:/program/JAVAProgram/YYSProject/web/img/QQ图片20220502182441.png");
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // BASE64Encoder encoder = new BASE64Encoder();
        var d = Base64.getEncoder().encodeToString(data);

        resp.getOutputStream().write(d.getBytes());
        */
        var c = req.getCookies();
        for (Cookie cookie :c) {
            System.out.println(cookie.getName() + cookie.getValue());
        }
    }
}
