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
				<h2>Quản lý danh mục</h2>
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
								if ("3".equals(msg)) {
							%>
							<div class="alert alert-danger">
								<strong>Success!</strong> Bạn đã xóa thành công
							</div>
							<%
								}
							%>
							<%
								}
							%>
							<div class="row">
								<div class="col-sm-6">
									<a href="<%= request.getContextPath() %>/admin/cat/add" class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post" action="<%= request.getContextPath()%>/admin/cat/search">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập danh mục"
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
										<th>Danh mục</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<%
									if (request.getAttribute("catList") != null) {
									List<Categories> catList = (List<Categories>) request.getAttribute("catList");
									if (catList.size() > 0) {
										for (Categories objCat : catList) {
									int id = objCat.getId();
									String name = objCat.getName();
								%>
								<tbody>
									<tr>
										<td><%=id%></td>
										<td class="center"><%=name%></td>
										<td class="center"><a
											href="<%=request.getContextPath()%>/admin/cat/edit?catId=<%=id%>"
											title="" class="btn btn-primary"><i class="fa fa-edit "></i>
												Sửa</a> <a
											href="<%=request.getContextPath()%>/admin/cat/del?catId=<%=id%>"
											title="" class="btn btn-danger"><i class="fa fa-pencil"></i>
												Xóa</a></td>
									</tr>
								</tbody>
								<%
									}
								}
								}
								%>
							</table>
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
	document.getElementById("category").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>