<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Cập nhật Người dùng</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" method="post" 
									id="form">
									<%
										if (request.getAttribute("itermUser") != null) {
										User itermUser = (User) request.getAttribute("itermUser");
									%>
									<div class="form-group">
										<input type="hidden" id="id"
											value="<%=itermUser.getId()%>" name="id"
											class="form-control" />
									</div>
									<div class="form-group">
										<label for="name">Tên Đăng nhập</label> <input type="text"
											id="username" value="<%=itermUser.getUsername()%>"
											name="username" class="form-control" />
									</div>
									<div class="form-group">
										<label for="name">Mật khẩu</label> <input type="text"
											id="name" value="<%=itermUser.getPassword()%>"
											name="password" class="form-control" />
									</div>
									<div class="form-group">
										<label for="name">Tên người dùng</label> <input type="text"
											id="name" value="<%=itermUser.getFullname()%>"
											name="fullname" class="form-control" />
									</div>
									<%
										}
									%>
									<button type="submit" name="submit"
										class="btn btn-success btn-md">Cập nhật</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
	</div>
	<!-- /. PAGE INNER  -->
</div>
<script>
	document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>