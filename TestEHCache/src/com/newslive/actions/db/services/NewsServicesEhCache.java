package com.newslive.actions.db.services;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

import com.newslive.actions.cache.EChache.EHCacheManger;
import com.newslive.actions.db.dao.NewsDAO;
import com.newslive.actions.db.entity.News;

public class NewsServicesEhCache {

	public void addNews(News news) throws Exception {
		NewsDAO newsDao = new NewsDAO();
		int insertCount = newsDao.addNews(news);
		Cache cache = EHCacheManger.getCache();
		cache.put(new Element(new Integer(insertCount), news));
	
	}
	
	public List<News> getHeadlineList() throws Exception
	{
		NewsDAO newsDao = new NewsDAO();
		return newsDao.getHeadLineList();
	}
	
	public News getNews(int newsId) throws Exception
	{
		News news = null;
		Cache cache = EHCacheManger.getCache();
		 Element element = cache.get(new Integer(newsId));
		 if(element == null)
		 {
			 System.out.println("cache miss");
			 NewsDAO newsDao = new NewsDAO();
			 news = newsDao.getNews(newsId);
			 cache.put(new Element(new Integer(newsId), news));
		 }
		 else
		 {
			 System.out.println("cache hit");
			 news = (News)element.getObjectValue();
		 }
		
		return news;
	}

}
