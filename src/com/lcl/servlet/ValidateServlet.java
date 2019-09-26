package com.lcl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.ImageIO;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
		//生成随机数,并保存
		Random r = new Random();
		int code = r.nextInt(9000) + 1000;
		request.getSession().setAttribute("code", String.valueOf(code));
		//创建要返回的图像
		int width = 60;
		int height = 20;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//绘制图像
		Graphics g = img.getGraphics();
		g.fillRect(0, 0, width, height);
		g.setColor(Color.red);
		g.setFont(new Font("Arail", Font.BOLD, 20));
		g.drawString(String.valueOf(code), 10, 20);
		//绘制干扰
		g.setColor(Color.gray);
		for (int i = 0; i < 10; i++) {
			int x1 = r.nextInt(width);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(width);
			int y2 = r.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		} 
		//输出图像至页面
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
