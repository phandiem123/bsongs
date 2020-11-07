<%@page import="model.Contacts"%>
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
				<h2>Quản lý Liên hệ</h2>
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
							%>
							<%
								if ("editok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Bạn đã cập nhật thành công.</strong>
							</div>
							<%
								}
							%>
							<%
								if ("repok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Bạn đã phản hồi thành công.</strong>
							</div>
							<%
								}
							%>
							<%
								if ("delok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Bạn đã xóa thành công.</strong>
							</div>
							<%
								}
							%>
							<%
								if ("addok".equals(msg)) {
							%>
							<div class="alert alert-danger">
								<strong>Bạn đã thêm liên hệ thành công</strong>
							</div>
							<%
								}
							%>
							<%
								}
							%>
							<div class="row">
								<div class="col-sm-6">
									<a href="<%=request.getContextPath()%>/admin/contact/add"
										class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post" action="">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập nội dung tìm kiếm"
											style="float: right; width: 300px;" />
										<div style="clear: both"></div>
									</form>
									<br />
								</div>
							</div>
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
										<th>ID</th>
										<th>Tên</th>
										<th>Email</th>
										<th>Website</th>
										<th>Tin nhắn</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<%
									if (request.getAttribute("contactList") != null) {
									List<Contacts> contactList = (List<Contacts>) request.getAttribute("contactList");
									if (contactList.size() > 0) {
										for (Contacts objContact : contactList) {
								%>
								<tbody>
									<tr>
										<td class="center"><%=objContact.getId()%></td>
										<td class="center"><%=objContact.getName()%></td>
										<td class="center"><%=objContact.getEmail()%></td>
										<td class="center"><%=objContact.getWebsite()%></td>
										<td class="center"><%=objContact.getMessage()%></td>
										<td class="center"><a
											href="<%=request.getContextPath()%>/admin/contact/edit?contactId=<%=objContact.getId()%>"
											title="" class="btn btn-primary"><i class="fa fa-edit "></i>
												Sửa</a> <a
											href="<%=request.getContextPath()%>/admin/contact/del?contactId=<%=objContact.getId()%>"
											title="" class="btn btn-danger"><i class="fa fa-pencil"></i>
												Xóa</a> <a
											href="<%=request.getContextPath()%>/admin/contact/rep?contactId=<%=objContact.getId()%>"
											class="btn btn-success btn-md">Phản hồi</a></td>
									</tr>
								</tbody>
								<%
									}
								}
								}
								%>
							</table>
							<div class="col-sm-6">
								<a href="<%=request.getContextPath()%>/admin/contact/del"
									class="btn btn-danger">Xóa tất cả</a>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="dataTables_info" id="dataTables-example_info"
										style="margin-top: 27px">Hiển thị từ 1 đến 5 của 24
										truyện</div>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<div class="dataTables_paginate paging_simple_numbers"
										id="dataTables-example_paginate">
										<ul class="pagination">
											<li class="paginate_button previous disabled"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a href="#">Trang
													trước</a></li>
											<li class="paginate_button active"
												aria-controls="dataTables-example" tabindex="0"><a
												href="">1</a></li>
											<li class="paginate_button"
												aria-controls="dataTables-example" tabindex="0"><a
												href="">2</a></li>
											<li class="paginate_button"
												aria-controls="dataTables-example" tabindex="0"><a
												href="">3</a></li>
											<li class="paginate_button"
												aria-controls="dataTables-example" tabindex="0"><a
												href="">4</a></li>
											<li class="paginate_button"
												aria-controls="dataTables-example" tabindex="0"><a
												href="">5</a></li>
											<li class="paginate_button next"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
										</ul>
									</div>
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
	document.getElementById("contact").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>