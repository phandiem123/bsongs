﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
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
                                <form role="form" method="post" action="<%= request.getContextPath()%>/admin/contact/add " id="form">
                                    <div class="form-group">
                                        <label for="name">ID</label>
                                        <input type="hidden" id="name" value="" name="id" class="form-control" />
                                        <label for="name">Tên:</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" />
                                        <label for="name">Email</label>
                                        <input type="text" id="name" value="" name="email" class="form-control" />
                                        <label for="name">Website</label>
                                        <input type="text" id="name" value="" name="website" class="form-control" />
                                        <label for="name">Message:</label>
                                        <input type="text" id="name" value="" name="message" class="form-control" />
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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
<%@ include file="/templates/admin/inc/footer.jsp" %>