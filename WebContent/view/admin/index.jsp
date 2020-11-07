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
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-4">
				<div class="panel panel-back noti-box">
					<span class="icon-box bg-color-green set-icon"> <i
						class="fa fa-bars"></i>
					</span>
					<%
						if (request.getAttribute("listCat") != null) {
						List<Categories> listCat = (List<Categories>) request.getAttribute("listCat");
						if (listCat.size() >= 0) {
					%>
					<div class="text-box">
						<p class="main-text">
							<a href="<%=request.getContextPath()%>/admin/cat/index" title="">Quản
								lý danh mục</a>
						</p>
						<p class="text-muted">
							Có
							<%=listCat.size()%>
							danh mục
						</p>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				<div class="panel panel-back noti-box">
					<span class="icon-box bg-color-blue set-icon"> <i
						class="fa fa-music"></i>
					</span>
					<%
						if (request.getAttribute("listSong") != null) {
						List<Songs> listSong = (List<Songs>) request.getAttribute("listSong");
						if (listSong.size() >= 0) {
					%>
					<div class="text-box">
						<p class="main-text">
							<a href="<%=request.getContextPath()%>/admin/song/index"
								title="">Quản lý bài hát</a>
						</p>
						<p class="text-muted">
							Có
							<%=listSong.size()%>
							bài hát
						</p>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				<div class="panel panel-back noti-box">
					<span class="icon-box bg-color-red set-icon"> <i
						class="fa fa-rocket"></i>
					</span>
					<%
						if (request.getAttribute("lisContact") != null) {
						List<Contacts> lisContact = (List<Contacts>) request.getAttribute("lisContact");
						if (lisContact.size() >= 0) {
					%>
					<div class="text-box">
						<p class="main-text">
							<a href="<%=request.getContextPath()%>/admin/user/index"
								title="">Quản lý người dùng</a>
						</p>
						<p class="text-muted">
							Có
							<%=lisContact.size()%>
							người dùng
						</p>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				<div class="panel panel-back noti-box">
					<span class="icon-box bg-color-brown set-icon"> <i
						class="fa fa-phone"></i>
					</span>
					<%
						if (request.getAttribute("listUser") != null) {
						List<User> listUser = (List<User>) request.getAttribute("listUser");
						if (listUser.size() >= 0) {
					%>
					<div class="text-box">
						<p class="main-text">
							<a href="<%=request.getContextPath()%>/admin/contact/index"
								title="">Quản lý Liên hệ</a>
						</p>
						<p class="text-muted">
							Có
							<%=listUser.size()%>
							người dùng
						</p>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
		</div>

	</div>
</div>
<script>
	document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>