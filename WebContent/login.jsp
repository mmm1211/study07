<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>登录界面</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				
					<div class="form-group">
						 <label for="exampleInputEmail1">账号</label><input type="text" class="form-control" id="account" />
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="pwd" />
					</div>
					<button type="submit" class="btn btn-default" onclick="login()")>Submit</button>
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function login(){
		var account=$.trim($("#account").val());
		var pwd=$.trim($("#pwd").val());
		
		$.post("login",{op:"login",account,pwd:pwd},function(data){
			console.info(data);
		},"text");
	}
	</script>
</body>
</html>