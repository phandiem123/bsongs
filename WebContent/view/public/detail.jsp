<%@page import="model.Comment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<%
				if (request.getAttribute("itermSong") != null) {
				Songs itermSong = (Songs) request.getAttribute("itermSong");
				String songDate = new SimpleDateFormat("dd-MM-yyyy").format(itermSong.getCreat_at());
				int count = itermSong.getCounter();
			%>
			<h1><%=itermSong.getName()%></h1>
			<div class="clr"></div>
			<p>
				Ngày đăng:<%=songDate%>
				Lượt xem:
				<%=count%></p>
			<div class="vnecontent">
				<%=itermSong.getDecription()%>
			</div>
			<br>
			<form action="<%= request.getContextPath()%>/song/comment?idSong=<%= itermSong.getId()%>" method="post">
			<input type="hidden" value="<%= itermSong.getId()%>" name = "idSong"/>
			<label>Tên: </label> <input type="text" style="border: none;border-bottom: black;" name="name"> <button style="float: right;margin-right: 110px;">Gửi bình luận</button>
			<br>
			<br>
			<textarea rows="4" cols="70" name="textComment" required="">
				
			</textarea><br>
			</form>
			<%
				}
			%>
			<%
				if (request.getAttribute("lisComments") != null) {
				List<Comment> lisComments = (List<Comment>) request.getAttribute("lisComments");
				for (Comment objComment: lisComments) {
				String commentDate = new SimpleDateFormat("dd-MM-yyyy").format(objComment.getDateCreat());
			%>
			<span><%= objComment.getName() %></span><span><%= objComment.getTextComment()%></span><br>
			<span><%=commentDate %></span>
			<%}} %>
		</div>
		<div class="article">
			<h2>Bài viết liên quan</h2>
			<%
				if (request.getAttribute("listConnectSong") != null) {
				List<Songs> listConnectSong = (List<Songs>) request.getAttribute("listConnectSong");
				for (Songs itermSong: listConnectSong) {
				String songDate = new SimpleDateFormat("dd-MM-yyyy").format(itermSong.getCreat_at());
			%>
			<div class="clr"></div>
			<div class="comment">
				<a href=""><img src="<%= request.getContextPath() %>" width="40"
					height="40" alt="" class="userpic" /></a>
				<h2>
					<a href="<%= request.getContextPath()%>/detail?idSong=<%= itermSong.getId()%>"><%=itermSong.getName() %></a>
				</h2>
				<p><%= itermSong.getDecription() %></p>
			</div>
			<%} }%>
		</div>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp"%>
