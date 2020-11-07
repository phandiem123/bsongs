<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<%
			if (request.getAttribute("listSongsByIdCat") != null) {
			List<Songs> listSongsByIdCat = (List<Songs>) request.getAttribute("listSongsByIdCat");
			if (listSongsByIdCat.size() > 0) {
				 int i=0; 
		%>
		<div class="article">
			<h1><%=listSongsByIdCat.get(0).getCat().getName()%></h1>
		</div>
		<%
			for (Songs objSongs : listSongsByIdCat) {
				i++;
		%>
		<div class="article">
			<h2>
				<a
					href="<%=request.getContextPath()%>/detail?idSong=<%=objSongs.getId()%>"
					title="<%=objSongs.getName()%>"><%=objSongs.getName()%></a>
			</h2>
			<p class="infopost">
				Ngày đăng:
				<%=objSongs.getCreat_at()%>
				Lượt xem:
				<%=objSongs.getCounter()%>
				<a href="#" class="com"><span><%= i %></span></a>
			</p>
			<div class="clr"></div>
			<div class="img">
				<img
					src="<%=request.getContextPath()%>/templates/public/images/<%=objSongs.getPicture()%>"
					width="177" height="213" alt="<%=objSongs.getName()%>" class="fl" />
			</div>
			<div class="post_content">
				<p><%=objSongs.getDecription()%></p>
				<p class="spec">
					<a href="" class="rm">Chi tiết &raquo;</a>
				</p>
			</div>
			<div class="clr"></div>
		</div>
		<%
			}
		}
		%>
		<%
			if (request.getAttribute("countPage") != null) {
			int countPage = (int) request.getAttribute("countPage");
		%>
		<p class="pages">
			<%
				for (int i = 1; i < countPage; i++) {
			%>
			<a href="<%= request.getContextPath()%>/cat?id=<%=listSongsByIdCat.get(0).getCat().getId()%>&page=<%=i%>"><%=i%></a>
			<%
				}
			%>
			<a href="#">&raquo;</a>
		</p>
		<%
			}}
		%>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp"%>