package com.newslive.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newslive.actions.db.entity.News;
import com.newslive.actions.db.services.NewsServicesEhCache;

/**
 * Servlet implementation class DisplayNews
 */
public class DisplayNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsId = request.getParameter("newsId");
		System.out.println(newsId);
		NewsServicesEhCache service = new NewsServicesEhCache();
		try {
			News news = service.getNews(Integer.parseInt(newsId));
			request.setAttribute("news", news);
			request.getRequestDispatcher("DisplayNews.jsp").forward(request, response);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
