<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<%
				if (request.getAttribute("listPage") != null) {
				int i = 0;
				List<Songs> listSong = (List<Songs>) request.getAttribute("listPage");
				if (listSong.size() >= 0) {
					for (Songs objSongs : listSong) {
				String songDate = new SimpleDateFormat("dd-mm-yyyy").format(objSongs.getCreat_at());
				i++;
			%>
			<h2>
				<a
					href="#"
					title="<%=objSongs.getName()%>"><%=objSongs.getName()%></a>
			</h2>
			<div></div>
			<p class="infopost">
				Ngày đăng:
				<%=songDate%>
				Lượt xem:<%=objSongs.getCounter()%>
				<a href="#" class="com"><span><%=i%></span></a>
			</p>
			<div class="clr"></div>
			<div class="img">
				<%
					if (!"".equals(objSongs.getPicture())) {
				%>
				<img width="177px" height="213px"
					src="<%=request.getContextPath()%>/uploads/img/<%=objSongs.getPicture()%>"
					alt="<%=objSongs.getName()%>" class="fl" />
				<%
					} else {
				%>
				<img width="177px" height="213px"
					src="<%=request.getContextPath()%>/uploads/img/nopicture.png"
					alt="no picture" class="fl" />
				<%
					}
				%>
			</div>
			<div>
				<div style="overflow-y: scroll;height: 150px;">
					<div style="float: left;">
						<span>phan diem:</span> <span>helo mọi người</span><br>
					</div>
					<div style="float: right:;">
						<div>
							<a href="" onclick="	">Trả lời</a> <a>Chưa làm nha</a>
						</div>
						<span></span>
					</div>
					<a> Hiển thị thêm...</a>
					<div class="clr"></div>
				</div>
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
				for (int i = 1; i <= countPage; i++) {
			%>
			<a href="<%=request.getContextPath()%>/admin/reply?page=<%=i%>"><%=i%></a>
			<%
				}
			}
			%>
			<a href="#">&raquo;</a>
		</p>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/admin/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<script>
	document.getElementById("pages").classList.add('active-menu');
</script>
<%@ include file="/templates/public/inc/footer.jsp"%>