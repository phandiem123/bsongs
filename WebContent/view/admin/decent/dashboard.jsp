<%@page import="model.Role"%>
<%@page import="model.Decentralazition"%>
<%@page import="model.Categories"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>
					Danh sách
					<%
					Role itermRoleForHead = (Role) request.getAttribute("itermRoleForHead");
				out.print(itermRoleForHead.getNameRole());
				%>
				</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<%
								if (request.getParameter("msg") != null) {
								String msg = request.getParameter("msg");
								if ("ok".equals(msg)) {
							%>
							<div class="alert alert-primary" role="alert">Đã thêm thành
								công</div>
							<%
								}
							}
							%>
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<td>ID</td>
											<td>Username</td>
											<td>Password</td>
											<td>Fullname</td>
											<td>Vai trò</td>
										</tr>
									</thead>
									<%
										if (request.getAttribute("listUser") != null) {
										List<User> listUser = (List<User>) request.getAttribute("listUser");
										if (listUser.size() > 0) {
											for (User objUser : listUser) {
									%>
									<tbody>
										<tr>
											<td name="idUser"><%=objUser.getId()%></td>
											<td name="username"><%=objUser.getUsername()%></td>
											<td name="password"><%=objUser.getPassword()%></td>
											<td name="fullname"><%=objUser.getFullname()%></td>
											<td><select name="idRole">
													<option value="<%=itermRoleForHead.getIdRole()%>"
														selected="selected"><%=itermRoleForHead.getNameRole()%></option>
													<%
														if (request.getAttribute("listRole") != null) {
														List<Role> listRole = (List<Role>) request.getAttribute("listRole");
														if (listRole.size() > 0) {
															for (Role objRole : listRole) {
													%>
													<option value="<%=itermRoleForHead.getIdRole()%>"><%=objRole.getNameRole()%></option>
													<%
														}
													}
													}
													%>
											</select></td>
										</tr>
									</tbody>
									<%
										}
									}
									}
									%>
								</table>
								<div class="col-sm-6">
									<a href="<%=request.getContextPath()%>/admin/decent/edit"
										class="btn btn-success btn-md">Cập nhật</a>
								</div>
							<div class="row">

								<div class="col-sm-6" style="text-align: right;">
									<form method="post"
										action="<%=request.getContextPath()%>/admin/cat/search">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập tên người dùng"
											style="float: right; width: 300px;" />
										<div style="clear: both"></div>
									</form>
									<br />
								</div>
							</div>
						</div>

					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>
	</div>
</div>
<script>
		$("img").click(function(){
		    var image = $(this)
		    $.ajax({
				url: '<%=request.getContextPath()%>
	/admin/decent/index',
			type : 'POST',
			cache : false,
			data : {
				asrc : image.attr("src")
			},
			success : function(data) {
				image.attr("src", data)
			},
			error : function() {
				alert("Có lỗi xảy ra");
			}
		});
	});
</script>
<script>
	document.getElementById("dencent").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>