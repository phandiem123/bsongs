<%@page import="model.Categories"%>
<%@page import="model.Songs"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Quản lý bài hát</h2>
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
							<div class="row">
								<div class="col-sm-6">
									<a href="<%=request.getContextPath()%>/admin/song/add"
										class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post" action="">
										<select class="input-sm">
											<%
												if (request.getAttribute("listCat") != null) {
												List<Categories> listCat = (List<Categories>) request.getAttribute("listCat");
												if (listCat.size() > 0) {
													for (Categories objCat : listCat) {
											%>
											<option value="<%=objCat.getId()%>"><%=objCat.getName()%></option>
											<%
												}
											}
											}
											%>
											<option value="0" selected="selected">---------------------</option>
										</select> <input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập tên bài hát"
											style="float: right; width: 300px;" />
										<div style="clear: both"></div>
									</form>
									<br />
								</div>
							</div>
							<%
								if (request.getParameter("msg") != null) {
								String msg = request.getParameter("msg");
							%>
							<%
								if ("ok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Success!</strong> Bạn đã cập nhật thành công.
							</div>
							<%
								}
							%>
							<%
								if ("noExit".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Success!</strong>Bài hát không tồn tại.
							</div>
							<%
								}
							%>
							<%
								}
							%>
							<%
								if (request.getParameter("msg") != null) {
								String msg = request.getParameter("msg");
							%>
							<%
								if ("addok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong>Success!</strong> Bạn đã thêm vào danh sách.
							</div>
							<%
								}
							}
							%>
							<%
								if (request.getParameter("msg") != null) {
								String msg = request.getParameter("msg");
							%>
							<%
								if ("delok".equals(msg)) {
							%>
							<div class="alert alert-success">
								<strong> Bạn đã xóa thành công.</strong>
							</div>
							<%
								}
							}
							%>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên bài hát</th>
										<th>Danh mục</th>
										<th>Lượt đọc</th>
										<th>Hình ảnh</th>
										<th width="160px">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%
										if (request.getAttribute("listSong") != null) {
											//out.print(request.getAttribute("listSong"));
										List<Songs> listSong = (List<Songs>) request.getAttribute("listSong");
										if (listSong.size() > 0) {
											for (Songs objSong : listSong) {
												//out.print("ok");
										String urlDel = request.getContextPath() + "/admin/song/del?songId=" + objSong.getId();
										String urlEdit = request.getContextPath() + "/admin/song/edit?songId=" + objSong.getId();
									%>
									<tr>
										<td><%=objSong.getId()%></td>
										<td class="center"><%=objSong.getName()%></td>
										<td class="center"><%=objSong.getCat().getName()%></td>
										<td class="center"><%=objSong.getCounter()%></td>
										<td class="center">
											<%
												if (!"".equals(objSong.getPicture())) {
											%> <img width="200px"
											height="200px"
											src="<%=request.getContextPath()%>/uploads/img/<%=objSong.getPicture()%>"
											alt="<%=objSong.getName()%>" /> <%
 	} else {
 %> <img
											width="200px" height="200px"
											src="<%=request.getContextPath()%>/uploads/img/nopicture.png"
											alt="No picture" /> <%
 	}
 %>
										</td>

										<td class="center"><a href="<%=urlEdit%>" title=""
											class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a> <a
											href="<%=urlDel%>" title="" class="btn btn-danger"
											onclick="return confirm('Bạn có chắc chắn muốn xóa không?')"><i
												class="fa fa-pencil"></i> Xóa</a></td>

									</tr>
									<%
										}
									}
									}
									%>
								</tbody>
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
	document.getElementById("repCom").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>