package com.newslive.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newslive.actions.db.entity.News;
import com.newslive.actions.db.services.NewsServicesEhCache;

/**
 * Servlet implementation class DisplayHeadline
 */
public class DisplayHeadline extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NewsServicesEhCache services = new NewsServicesEhCache();
		try {
			List<News> headLines = services.getHeadlineList();
			
			
			request.setAttribute("headLines", headLines);
			request.getRequestDispatcher("DisplayHeadline.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
