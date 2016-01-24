package com.newslive.actions.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newslive.actions.db.entity.News;

public class NewsDAO extends BaseDao {

	public int addNews(News news) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		int insertCount = -1;
		con = super.getJDDBCConn();
		stmt = con
				.prepareStatement("insert into news (newsHeading,newsBody) values (?,?)");
		stmt.setString(1, news.getNewsHeading());
		stmt.setString(2, news.getNewsBody());
		stmt.executeUpdate();
		
		Statement select = con.createStatement();
		ResultSet result = select.executeQuery("SELECT max(id) FROM news");
		while (result.next()) {
			insertCount = result.getInt(1);
		}
		closrStmtConn(stmt, con);
		return insertCount;
	}
	
	public List<News> getHeadLineList() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		con = super.getJDDBCConn();
		Statement select = con.createStatement();
		ResultSet result = select.executeQuery("SELECT id, newsHeading FROM news");
		List<News> newsList = new ArrayList<News>();
		
		while (result.next()) {
			News news = new News();
			news.setId(result.getLong(1));
			news.setNewsHeading(result.getString(2));
			newsList.add(news);
		}
		closrStmtConn(stmt, con);
		return newsList;
	}
	
	public News getNews(int newsId) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		con = super.getJDDBCConn();
		stmt = con
				.prepareStatement("Select newsHeading, newsBody FROM news where id = ?");
		stmt.setInt(1,newsId);
		ResultSet result = stmt.executeQuery();
		News news = new News();
		if (result.next()) {
			news.setNewsHeading(result.getString(1));
			news.setNewsBody(result.getString(2));
		}
		closrStmtConn(stmt, con);
		return news;
	}
}
