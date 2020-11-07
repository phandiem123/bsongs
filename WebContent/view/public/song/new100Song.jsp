<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		
		<p class="pages">
			<%
				if (request.getAttribute("countPage") != null) {
				int countPage = (int) request.getAttribute("countPage");
				for (int i = 1; i < countPage; i++) {
			%>
			 <a href="<%= request.getContextPath()%>/new?page=<%= i %>"><%= i %></a>
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
<%@ include file="/templates/public/inc/footer.jsp"%>