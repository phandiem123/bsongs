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
					Decentralazition itermRoleForHead = (Decentralazition) request.getAttribute("itermRoleForHead");
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
							<form action="<%=request.getContextPath()%>/admin/decent/edit" method="post">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<td>ID</td>
											<td>Username</td>
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
											<td><%=objUser.getId()%>
											<input  name="idUser" value="<%=objUser.getId()%>" type="hidden">
											</td>
											<td id="username"><%=objUser.getUsername()%></td>
											<td id="fullname"><%=objUser.getFullname()%></td>
											<td><select name="idRole">
													<option value="<%=itermRoleForHead.getIdRole()%>"
														selected="selected"><%=itermRoleForHead.getNameRole()%></option>
													<%
														if (request.getAttribute("listDecentralazition") != null) {
														List<Decentralazition> listDecentralazition = (List<Decentralazition>) request.getAttribute("listDecentralazition");
														if (listDecentralazition.size() > 0) {
															for (Decentralazition objDecentralazition : listDecentralazition) {
													%>
													<option value="<%=objDecentralazition.getIdRole()%>"><%=objDecentralazition.getNameRole()%></option>
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
									<input href="<%=request.getContextPath()%>/admin/decent/edit"
										class="btn btn-success btn-md" value="Cập nhật" type="submit">
								</div>
								</form>
								
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
	document.getElementById("dencent").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>