<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="jquery.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="css/bg.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
//用ajax实现异步处理，实时提示输入信息


window.onload=function() {
	if("<%=(String) request.getAttribute("isSameName")%>"!="null")
		alert("<%=(String) request.getAttribute("isSameName")%>");
	}
	function check() {

		var name = document.getElementById("name").value;
		var pwd = document.getElementById("pwd").value;
		var surepwd = document.getElementById("surepwd").value;
		var email = document.getElementById("email").value;

		if (name == "" || pwd == "" || surepwd == "" || email == "") {
			alert("输入框不能为空");

			return false;
		}
		if (pwd != surepwd) {
			alert("两次输入的密码不同");

			return false;
		}
		var rege = /^[\u4E00-\u9FA5\w]+@\w+.\w+$/;
		if (!rege.test(email)) {
			alert("邮箱格式不对");

			return false;
		}

	}
</script>
</head>
<body>
	<h1 align="center">用户注册</h1>
	<hr>
	<center>
		<div
			style="border: 1px solid; width: 400px; height: 300px; padding: 10px; background-color: white;">
			<form name="regForm" onsubmit="" method="post"
				action="<%=request.getContextPath()%>/LoginServlet?action=register">
				<table cellspacing="0" cellpadding="0"
					style="border-spacing: 10px; border-collapse: separate;">
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th>
						<td><input class="form-control input-sm" type="text"
							name="username" id="name" /> <span id="n" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<th>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</th>
						<td><input class="form-control input-sm" type="password"
							name="password" id="pwd" /> <span id="p" style="color: red"></span>
						</td>
					</tr>

					<tr>
						<th>确认密码</th>
						<td><input class="form-control input-sm" type="password"
							name="surepwd" id="surepwd" /> <span id="s" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<th>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</th>
						<td><input class="form-control input-sm" type="text"
							name="email" id="email" /> <span id="e" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<td>求职者： <input type="radio" checked="checked" name="ishr"
							value="employee" />
						</td>
						<td>公司HR： <input type="radio" name="ishr" value="employer" /></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input
							class="btn btn-default btn-sm" type="submit" value="提交"
							onclick="return check()" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							class="btn btn-default btn-sm" type="reset" value="重置"></td>
					</tr>
				</table>

			</form>
		</div>
	</center>
</body>
</html>