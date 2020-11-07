<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<body>
	<div class="container-fluid px-4 px-md-4 py-5 mx-auto">
		<div class="row d-flex justify-content-between align">
			<div class="card p-0 border-0 rounded-0 mb-5">
				<div class="card border-0 rounded-0 card0">
					<%
						if (request.getParameter("msg") != null) {
						String msg = request.getParameter("msg");
						if (!"loginError".equals(msg))
					%>
					<div class="alert alert-danger" role="alert">
					Đăng nhập không đúng</div>
					<%
						}
					%>
					<h1 class="mb-0">Hello!</h1>
					<p style="color: red;">Bạn phải đăng nhập để sử dụng quyền của
						trang chủ</p>
					<form role="form" method="post" id="form"
						action="<%=request.getContextPath()%>/auth/login">
						<div class="form-group">
							<label class="font-weight-bold mb-0">Tên đăng nhập:</label> <input
								type="text" name="username" class="mb-4" placeholder="">
							<br>
							<div>
								<label class="font-weight-bold mb-0">Mật khẩu: </label> <input
									type="password" name="password" placeholder="" id="password">
								<img src="<%=request.getContextPath()%>/templates/images/open-eye.jpg"
									style="width: 35px; height: 35px;" onclick="MyFunction()">
								<script type="text/javascript">
									function MyFunction() {
										var x = true;
										if(x) {
											document.getElementById('password').type = "text";
											x = false; 
										} else {
											document.getElementById('password').type ="password";
											x = true; 
										}
									}
								</script>
							</div>
							<br> <a href="#" class="text-sm ml-auto text-dim">Quên
								mật khẩu?</a><br> <br>
							<div class="row justify-content-center mt-4"></div>
							<button type="submit" class="btn btn-yellow px-5">Login</button>
							<div class="row justify-content-center mt-3">
								<small class="text-dim">login with</small>
							</div>
					</form>
				</div>
				<div class="row justify-content-center mt-3 mb-2">
					<a href="#"> <img class="icon mr-2"
						src="https://i.imgur.com/j8ZGqG2.png">
					</a> <a> <img class="icon ml-2"
						src="https://i.imgur.com/AX2lVgH.png">
					</a>
				</div>
			</div>
			<img
				src="https://philconnect.edu.vn/wp-content/uploads/2018/02/MUSIC-300x200.jpg"
				class="mt-auto">
		</div>
	</div>
</body>
<style>
body {
	color: #000;
	overflow-x: hidden;
	height: 100%;
	background-color: white;
	background-repeat: no-repeat
}

.card {
	width: 32%;
	padding: 30px;
	margin-left: auto;
	margin-right: auto;
	box-shadow: 0px 8px 16px 0px #1976D2;
	max-width: 511px;
	box-shadow: 0px 8px 16px 0px #1976D2;
}

.card0 {
	width: 100%;
	padding-right: 30px;
	box-shadow: none
}

.card1 {
	background: linear-gradient(rgba(255, 255, 255, .2),
		rgba(255, 255, 255, .2)), url("https://i.imgur.com/AMBgumm.jpg");
	min-height: 600px
}

.btn-yellow {
	border: 2px solid green;
	background-color: green;;
	color: #fff;
	font-weight: bold;
	letter-spacing: 1px;
	border-radius: 15px;
	width: 100px;
	margin-left: 100px;
	margin-right: 100px;
}

.btn-yellow:hover {
	background-color: #F57F17;
	border: 2px solid #F57F17
}

.btn-inverse {
	border: 2px solid #F9A825;
	background-color: transparent;
	color: #F9A825;
	font-weight: bold;
	letter-spacing: 1px
}

.btn-inverse:hover {
	background-color: #F57F17;
	color: #fff;
	border: 2px solid #F57F17
}

::placeholder {
	color: #E0E0E0;
	opacity: 1
}

:-ms-input-placeholder {
	color: #E0E0E0
}

::-ms-input-placeholder {
	color: #E0E0E0
}

input {
	padding: 1px 0px 3px 0px;
	border: none;
	border-bottom: 1px solid lightgrey;
	margin-bottom: 3px;
	margin-top: 2px;
	box-sizing: border-box;
	color: #000;
	font-size: 16px;
	letter-spacing: 1px;
	font-weight: 500
}

input:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border-bottom: 1px solid #EF5350;
	outline-width: 0
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0
}

a:hover {
	color: inherit
}

.text-sm {
	float: right;
	margin-right: 90px;
	font-size: 14px
}

.text-dim {
	color: #BDBDBD
}

.icon {
	width: 20px;
	height: 20px;
	cursor: pointer
}

@media screen and (max-width: 1056px) {
	.card {
		width: 100%
	}
	.align {
		justify-content: center !important
	}
}

.mt-3 {
	margin-left: 110px;
	margin-right: 100px;;
}

.mt-auto {
	margin-left: 100spx;
	margin-right: 2px;;
}
</style>
