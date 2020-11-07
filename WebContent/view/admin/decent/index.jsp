<%@page import="model.Role"%>
<%@page import="model.Decentralazition"%>
<%@page import="model.Categories"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/assets/js/jquery-3.2.1.js"></script>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Quản lý Quyền</h2>
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
									<a href="<%=request.getContextPath()%>/admin/decent/addrole"
										class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post"
										action="<%=request.getContextPath()%>/admin/cat/search">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập tên quyền"
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
										<td>Tên Quyền</td>
										<th>Thêm Người Dùng</th>
										<th>Sửa Người Dùng</th>
										<th>Xóa Người Dùng</th>
										<th>Thêm Của Mình</th>
										<th>Sửa Của Mình</th>
										<th>Xóa Của Mình</th>
										<th>Thêm Của Người khác</th>
										<th>Sửa Của Người khác</th>
										<th>Xóa Của Người khác</th>
										<th>Danh sách</th>
									</tr>
								</thead>
								<%-- <%
									if (request.getAttribute("listDecentralazition") != null) {
									List<Decentralazition> listRole = (List<Decentralazition>) request.getAttribute("listDecentralazition");
									if (listRole.size() > 0) {
										for (Decentralazition objRole : listRole) {
								%> --%>
								<tbody>

										
										<%
											if (request.getAttribute("listDecentralazition") != null) {
											List<Decentralazition> listDecentralazition = (List<Decentralazition>) request.getAttribute("listDecentralazition");
											if (listDecentralazition.size() > 0) {
												for (Decentralazition objRole : listDecentralazition) {
										%>
									<tr>
										<td><%=123%></td>
										<%
											for (int i = 0; i <= 8; i++) {
												
										%>
										<td><a href="javascript:void(0)" title=""><img
												id="<%=0 %>" class="<%=listDecentralazition.get(0).getIdRole() %>" alt=""
												src="<%=request.getContextPath()%>/uploads/img/tick.png"
												style="width: 45px; height: 45px; text-align: center;"></a>
										</td>
										<%} %>
										 <td><a
											href="<%=request.getContextPath()%>/admin/decent/dashboard?idRole=<%=listDecentralazition.get(0).getIdRole()%>">Click
												here</a></td> 
										<%}}} %>
									</tr>
								</tbody>
								<%-- <%
									}
								}
								}
								%> --%>
							</table>

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
				url: '<%=request.getContextPath()%>/admin/decent/index',
			type : 'POST',
			cache : false,
			data : {
				asrc : image.attr("src"),
				aid : image.attr("id"),
				aobjRole : image.attr("class")
			},
			success : function(data) {
				image.attr("src", data)
			},
			error : function() {
				alert("Có lỗi xảy ra")
			}
		});
	});
</script>
<script>
	document.getElementById("dencent").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>