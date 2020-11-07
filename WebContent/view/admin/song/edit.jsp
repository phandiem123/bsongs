	<%@page import="java.util.List"%>
<%@page import="model.Categories"%>
<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Thêm bài hát</h2>
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
								<form role="form" method="post" enctype="multipart/form-data"
									id="form">
									<%
										if (request.getAttribute("objSong") != null) {
										Songs objSong = (Songs) request.getAttribute("objSong");
									%>
									<div class="form-group">
									 <input type="hidden"
											id="name" value="<%=objSong.getId()%>" name="idSong"
											class="form-control" />
									</div>

									<div class="form-group">
										<label for="name">Tên bài hát</label> <input type="text"
											id="name" value="<%=objSong.getName()%>" name="name"
											class="form-control" />
									</div>
									<div class="form-group">

										<label for="category">Danh mục bài hát</label> <select
											id="category" name="category" class="form-control">
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
										</select>

									</div>
									<div class="form-group">
										<label for="picture">Hình ảnh</label>
										<p>
											<img width="200px" height="140px"
												src="<%=request.getContextPath()%>/uploads/images/<%=objSong.getPicture()%>" />
										</p>
										<input type="file" name="picture" />
									</div>
									<div class="form-group">
										<label for="preview">Mô tả</label>
										<textarea id="preview" class="form-control" rows="3"
											name="preview">
											<%=objSong.getDecription() %>
											</textarea>
									</div>
									<div class="form-group">
										<label for="detail">Chi tiết</label>
										<textarea id="detail" class="form-control" 
											rows="5" name="detail">123</textarea>
									</div>
									<%
										}
									%>
									<button type="submit" name="submit"
										class="btn btn-success btn-md">Cập nhật</button>
								</form>
								<div>
									<table>
										<tr>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>
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