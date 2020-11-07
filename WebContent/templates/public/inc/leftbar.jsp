<%@page import="model.Songs"%>
<%@page import="dao.SongsDao"%>
<%@page import="dao.CatDao"%>
<%@page import="util.StringUtil"%>
<%@page import="model.Categories"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	CatDao catDao = new CatDao();
	List<Categories> listCat = catDao.findAll();
%>
<div class="searchform">
	<form id="formsearch" name="" method="post"
		action="<%=request.getContextPath()%>/search">
		<select name = "idCat" >
			<%
				for (Categories objCat : listCat) {
			%>
			<option value="<%= objCat.getId()%>"><%= objCat.getName() %></option>
			<% } %>
			<option value="0" selected="selected">----------------</option>
		</select>
		<br> <br> 
		<span> <input name="editbox_search" class="editbox_search"
			id="editbox_search" maxlength="80"
			placeholder="Nhập bài hát tìm kiếm" type="text" />
		</span> <input name="button_search"
			src="<%=request.getContextPath()%>/templates/public/images/search.jpg"
			class="button_search" type="image" /> 
	</form>
</div>
<div class="clr"></div>
<div class="gadget">
	<h2 class="star">Danh mục bài hát</h2>
	<div class="clr"></div>
	<ul class="sb_menu">
		<%
			if (listCat.size() > 0) {
			for (Categories objCat : listCat) {
				//danh-muc/nhac-tru-tinh-10
				String urlSlug = request.getContextPath() + "/danh-muc/" + StringUtil.makeSlug(objCat.getName()) + "-"
				+ objCat.getId() + ".html";
				String name = objCat.getName();
				int id = objCat.getId();
		%>
		<li><a
			href="<%=request.getContextPath()%>/cat?idCat=<%=objCat.getId()%>"><%=name%></a></li>
		<%
			}
		}
		%>
	</ul>
</div>

<div class="gadget">
	<h2 class="star">
		<span>Bài hát mới</span>
	</h2>
	<div class="clr"></div>
	<ul class="ex_menu">
		<%
			SongsDao songsDao = new SongsDao();
		List<Songs> listNewSong = songsDao.getNewSong();
		if (listNewSong.size() > 0) {
			for (Songs objSong : listNewSong) {
		%>
		<li><a
			href="<%=request.getContextPath()%>/detail?idSong=<%=objSong.getId()%>"><%=objSong.getName()%></a><br /><%=objSong.getCreat_at()%></li>
		<%
			}
		}
		%>
	</ul>
</div>