package com.newslive.actions.cache.EChache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class EHCacheManger {

	private static Cache newsCache ;
	
	private static EHCacheManger manager = new EHCacheManger();

	private EHCacheManger() {
		URL url = getClass().getResource("/config/ehcache.xml");
		CacheManager manager = new CacheManager(url);
		EHCacheManger.newsCache = manager.getCache("newsCache");
	}

	public static Cache getCache() {
		return EHCacheManger.newsCache;
	}

}
