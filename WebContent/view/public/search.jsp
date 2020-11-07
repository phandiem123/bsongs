<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<%
		if (request.getAttribute("listSongs") != null) {
			List<Songs> listSongs =(List<Songs>) request.getAttribute("listSongs");
			if (listSongs.size() >= 0) {
				for(Songs objSongs : listSongs) {
					String songDate = new SimpleDateFormat("dd-mm-yyy").format(objSongs.getCreat_at());
					int i=0;
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
			<div class="post_content">
				<p><%=objSongs.getDecription()%></p>
				<textarea rows="6" cols="55">
				
				</textarea>
				<button>Gửi bình luận</button>
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