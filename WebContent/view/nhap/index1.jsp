<%@page import="model.Contacts"%>
<%@page import="model.User"%>
<%@page import="model.Songs"%>
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
				<h2>TRANG QUẢN TRỊ VIÊN</h2>
				<table border="1">
					<thead>
						<tr>
							<td>Phân chức năng</td>
							<td>Thêm</td>
							<td>Sửa</td>
							<td>Xóa</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Quản trị viên</td>
							<td><a href="javascript:void(0)"> <img alt=""
									src="<%=request.getContextPath()%>/uploads/img/tick.png"
									style="width: 50px; height: 50px;" onclick="changesImage()"></td>
							</a>

						</tr>
						<tr>
							<td>Người dùng</td>
						</tr>
					</tbody>
				</table>
				<script>
					$("img").click(function(){
					    var image = $(this)
					    $.ajax({
							url: '<%=request.getContextPath()%>/admin/decent/index',
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
			</div>
		</div>
	</div>
</div>
<script>
	document.getElementById("decent").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>