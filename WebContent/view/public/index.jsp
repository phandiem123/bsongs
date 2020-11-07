<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<%
			if (request.getParameter("msg") != null) {
			String msg = request.getParameter("msg");
		%>
		<%
			if ("delok".equals(msg)) {
		%>
		<div class="alert alert-success">
			<strong style="color: red"> Bạn đã Xóa thành công.</strong>
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
			if ("addContactOk".equals(msg)) {
		%>
		<div class="alert alert-success">
			<strong> Bạn đã gửi liên hệ thành công.</strong>
		</div>
		<%
			}
		}
		%>
		<div class="article">
			<%
				if (request.getAttribute("listPage") != null) {
				int i = 0;
				List<Songs> listSong = (List<Songs>) request.getAttribute("listPage");
				if (listSong.size() >= 0) {
					for (Songs objSongs : listSong) {
						String songDate =new  SimpleDateFormat("dd-mm-yyyy").format(objSongs.getCreat_at());
						i++;
			%>
			<h2>
				<a
					href="<%=request.getContextPath()%>/detail?idSong=<%=objSongs.getId()%>"
					title="<%=objSongs.getName()%>"><%=objSongs.getName()%></a>
			</h2>
			<div></div>
			<p class="infopost">
				Ngày đăng:
				<%=songDate%>
				Lượt xem:<%= objSongs.getCounter()%>
				<a href="#" class="com"><span><%=i%></span></a>
			</p>
			<div class="clr"></div>
			<div class="img">
				<%
					if (!"".equals(objSongs.getPicture())) {
				%>
				<img width="177px" height="213px"
					src="<%=request.getContextPath()%>/uploads/img/<%=objSongs.getPicture()%>"
					alt="<%=objSongs.getName()%>"  class="fl"/>
				<%
					} else {
				%>
				<img width="177px" height="213px"
					src="<%=request.getContextPath()%>/uploads/img/nopicture.png"
					alt="no picture"  class="fl" />
				<%
					}
				%>
			</div>
			<div class="clr"></div>
			<%
				}
			}
			}
			%>
		</div>
		
		<p class="pages">
			<%
				if (request.getAttribute("countPage") != null) {
				int countPage = (int) request.getAttribute("countPage");
				for (int i = 1; i < countPage; i++) {
			%>
			<a href="<%=request.getContextPath()%>/index?page=<%=i%>"><%=i%></a>
			<%
				}
			}
			%>
			<a href="#">&raquo;</a>
		</p>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<script>
	document.getElementById("pages").classList.add('active-menu');
</script>
<%@ include file="/templates/public/inc/footer.jsp"%>