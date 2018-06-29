<%@page import="entity.Job"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="css/bg.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<h1>搜索结果</h1>
    <hr>
    <center>
      <table cellspacing="50" class=" table table-striped  table-hover">
      <tr>
           <th>职位名称</th>
           <th>所属公司</th>
           <th>参考薪水</th>
           <th>发布时间</th>
      </tr>
       <% 
           ArrayList<Job> list=(ArrayList<Job>)request.getAttribute("list");
           if(list!=null && list.size()>0)
           {
        	   for(Job j:list)
        	   {
       %>
         <tr>
            <td><a href="JobServlet?action=detail&id=<%=j.getId()%>"><%=j.getName() %></a></td>
            <td><%=j.getCompany() %></td>
            <td><%=j.getSalary() %>元/月</td>
            <td><%=j.getTime() %></td>
         </tr>
       <% }}%>
       </table>
    </center>
</body>
</html>