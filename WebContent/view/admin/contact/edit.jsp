<%@page import="model.Contacts"%>
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
											if (request.getAttribute("itemContact") != null) {
											Contacts itemContact = (Contacts) request.getAttribute("itemContact");
										%>
										<input type="hidden" value="<%=itemContact.getId()%>" name="idCat" />
										 <label
											for="name">Tên </label> <input type="text"
											id="name" value="<%=itemContact.getName()%>" name="name"
											class="form-control" />
										<label
											for="name">Email:</label> <input type="text"
											id="email" value="<%=itemContact.getEmail()%>" name="email"
											class="form-control" />
										<label
											for="name">Website</label> <input type="text"
											id="website" value="<%=itemContact.getWebsite()%>" name="website"
											class="form-control" />
										<label
											for="name">Message:</label> <input type="text"
											id="message" value="<%=itemContact.getMessage()%>" name="message"
											class="form-control" />
										<%
											}
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