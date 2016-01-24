package com.newslive.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newslive.actions.db.entity.News;
import com.newslive.actions.db.services.NewsServicesEhCache;


/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		News news = new News();
		news.setNewsHeading(request.getParameter("newsHeading"));
		news.setNewsBody(request.getParameter("newsBody"));
		
		NewsServicesEhCache service = new NewsServicesEhCache();
		PrintWriter pw = response.getWriter();
		try {
			service.addNews(news);
			pw.print("News added sucessfully");
		} catch (Exception e) {
			pw.print("oops ! - " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			pw.flush();
			pw.close();
		}
		
	
	
	}

}
