<%@page import="model.Contacts"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Phản hồi</h2>
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
								<form role="form" method="post"
									action="<%=request.getContextPath()%>/admin/contact/rep "
									id="form">
									<%
										if (request.getAttribute("contacts") != null) {
										Contacts contacts = (Contacts) request.getAttribute("contacts");
									%>
									<div class="form-group">
										<label for="name">Gửi đến:</label>
										 <input type="text"
											id="name" value="<%=contacts.getEmail()%>" name="email"
											class="form-control modifine" />
											 <input type="hidden"
											id="name" value="<%=contacts.getId()%>" name="id"
											class="form-control modifine" /> <label for="name">Tên:</label>
										<input type="text" id="name" value="<%=contacts.getName()%>"
											name="name" class="form-control modifine" /> <label
											for="name">Website</label> <input type="text" id="name"
											value="<%=contacts.getWebsite()%>" name="website"
											class="form-control modifine" /> <label for="name">Message:</label>
										<textarea rows="10" cols="50" name="message"
											class="form-control ">
                                        
                                        </textarea>
									</div>
									<%
										}
									%>
									<button type="submit" name="submit"
										class="btn btn-success btn-md">Phản hồi</button>
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