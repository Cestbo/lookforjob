<%@page import="entity.Job"%>
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
<body bgcolor="">
<h1>工作详情</h1>
<hr>
   <center>
       <% 
            Job job=(Job)request.getAttribute("job");
            if(job!=null)
            {
       %>
             <table cellspacing="50"  
             class=" table table-striped  table-hover">
                <tr>
                   <td>公司</td><td><%=job.getCompany() %></td>
                </tr>
                <tr>
                   <td>职位</td><td><%=job.getName() %></td>
                </tr>
                <tr>
                   <td>薪水</td><td><%=job.getSalary() %>元/月</td>
                </tr>
                <tr>
                   <td>工作地点</td><td><%=job.getCity() %></td>
                </tr>
                <tr>
                   <td rowspan="2" >职能描述</td>
                   <td rowspan="2"><%=job.getDescription() %></td>
                </tr>
                
               <!-- <tr><td><td><td><td></tr> -->
             
             </table>
       <% }%>
       <br>
       <br>
       <p>有意请将简历发送到222@whut.com!!</p>
   </center>
</body>
</html>