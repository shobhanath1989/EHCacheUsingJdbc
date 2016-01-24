<%@page import="com.newslive.actions.db.entity.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
List<News> headLines = (List<News>)request.getAttribute("headLines");

for (News news : headLines) {
	out.print("<a href='DisplayNews?newsId=" + news.getId() + "'><h4>");
	out.print(news.getNewsHeading());
	out.print("</h4></a>");
	
}



%>
</body>
</html>