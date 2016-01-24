package com.newslive.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newslive.actions.cache.EChache.EHCacheManger;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Statistics;

/**
 * Servlet implementation class Statastics
 */
public class Statastics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cache cache = EHCacheManger.getCache(); 
		Statistics statistics = cache.getStatistics();
		 statistics.getCacheHits();
		 PrintWriter pw = response.getWriter();
		 pw.print("<h2 style='color: maroon;'>NewsLive.com Statistics</h2><br>");
		 pw.println("Cache name : " + statistics.getAssociatedCacheName());
		 pw.println("<br>Cache count : " + statistics.getMemoryStoreObjectCount());
		 pw.println("<br>Aveerage Time : " + statistics.getAverageGetTime());
		 pw.println("<br>Hits : " + statistics.getCacheHits());
		 pw.println("<br>Miss : " + statistics.getCacheMisses());
		 
		 
		 pw.flush();
		 pw.close();
	}

}
