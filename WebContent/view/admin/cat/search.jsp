<%@page import="java.util.List"%>
<%@page import="model.Categories"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Cập nhật</h2>
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
								<form role="form" method="post" id="form">
									<div class="form-group">
										<%
											if (request.getAttribute("lisCategories") != null) {
											List<Categories> lisCategories =(List<Categories>)request.getAttribute("lisCategories");
											for (Categories objCategories : lisCategories) {
											int id = objCategories.getId();
											String name = objCategories.getName();
										%>
										<input type="hidden" value="<%=id%>" name="idCat" /> <label
											for="name">Tên danh mục</label> <input type="text"
											id="nameCat" value="<%=name%>" name="nameCat"
											class="form-control" />
										<%
											}}
										%>
									</div>
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