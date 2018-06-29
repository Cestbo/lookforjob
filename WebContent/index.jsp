<%@page import="entity.Job"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/bg.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<%
	String prompt = (String) request.getAttribute("error");
    if(prompt==null)
    {
       prompt = (String) request.getAttribute("status");
    }
%>
<body onload="info('<%=prompt%>')">
	<h1 style="font-size: 40px;color: gray;">求职网</h1>
	<hr />
	<div id="job">
		<input type="text" id="keyword" /> <img src="img/search.png" alt=""
			id="search" />
			<h4 style="color: green;">最新动态(登录后才能查看)</h4>
			
        <ul id="list">
            
           
        </ul>
	</div>
	
	<%
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
	%>

	<div id="right">

		<center>
			<label id="lookfor">求职者</label> <label id="employ">公司HR</label>
			<form id="login-employer" action="LoginServlet?action=login"
				method="post">
				<table id="login" cellspacing="30">
					<tr>
						<td>用户名</td>
						<td><input type="text" id="name" name="name" /></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;码</td>
						<td><input type="password" id="password" name="password" /></td>
					</tr>
					<tr>
						<td>验证码</td>
						<td><input type="text" id="validate" name="validate" /></td>
					</tr>
					<tr>
						<td><img name="imgValidate" src="validate.jsp"
							style="cursor: pointer;" onclick="refresh()" /></td>
					</tr>
					<tr>
						<td colspan="2" id="submit"><button type="submit"
								id="login-button">
								<img src="img/login.png" alt="" />
							</button></td>
					</tr>
				</table>
			</form>
			<a href="register.jsp">还没账号?点击此处立即注册</a>
		</center>
	</div>
	<%
		} else {
	%>
	<div id="right1">


		<center>
			<h2 align="center" style="margin-top: 0px;color: maroon;">欢迎您!</h2>

			<table id="info" cellspacing="30">
				<tr>
					<td>用户名:<%=user.getName()%></td>
				</tr>
				<tr>
					<td>email:<%=user.getEmail()%></td>
				</tr>
				<tr>
					<td><a href="LoginServlet?action=logout">退出登录</a></td>
				</tr>
				<tr>
					<td>
						<%
							if (user.getIshr() == 1) {
						%> <a href="javascript:show()">发布工作信息</a> <%
 	}
 %>
					</td>
				</tr>

			</table>


		</center>
	</div>
	<%
		}
	%>

	<div id="fade"></div>
	<div id="workinfo">
	<h3>新增职位</h3>
	<hr />
	     <center>
	       <form action="JobServlet?action=add" method="post">
	          <label>公司名称</label>
	          <input type="text" name="company"/>
	          <br /><br />
	          <label>职位名称</label>
	          <input type="text" name="name"/>
	          <br /><br />
	          <label>工作地点</label>
	          <input type="text" name="city"/>
	          <br /><br />
	          <label>薪资水平</label>
	          <input type="text" name="salary" size="13"/>元/月
	          <br /><br />
	          <label>职能描述</label>
	          <br />
	          <textarea rows="10" cols="50" name="description"></textarea>
	          <br /><br />
	          <input type="submit" value="提交"/>
	          &nbsp;&nbsp;&nbsp;
	          <input type="button" value="退出" onclick="hide()"/>
	     </form>
	     </center>
	</div>
</body>

</html>