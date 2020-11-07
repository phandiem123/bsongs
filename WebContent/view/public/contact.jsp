<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<h2>
				<span>Liên hệ</span>
			</h2>
			<div class="clr"></div>
			<div class="map">
			<iframe 
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d33447.440316449305!2d108.15375929965435!3d16.069130694685548!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218d6a5e59b83%3A0x899fd6521e2fd12d!2zOTggTmd1eeG7hW4gTMawxqFuZyBC4bqxbmcsIEhvw6AgS2jDoW5oIELhuq9jLCBMacOqbiBDaGnhu4N1LCDEkMOgIE7hurVuZyA1NTAwMDAsIFZpZXRuYW0!5e0!3m2!1sen!2s!4v1603700799655!5m2!1sen!2s"
				width="600" height="450" frameborder="0" style="border: 0;"
				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
			</div>
		</div>
		<div class="article">
			<h2>Gửi liên hệ đến chúng tôi</h2>
			<div class="clr"></div>
			<form action="" method="post" id="sendemail">
				<ol>
					<li><label for="name">Họ tên (required)</label> <input
						id="name" value="" name="name" class="text" /></li>
					<li><label for="email">Email (required)</label> <input
						id="email" value="" name="email" class="text" /></li>
					<li><label for="website">Website</label> <input id="website"
						value="" name="website" class="text" /></li>
					<li><label for="message">Nội dung</label> <textarea
							id="message" name="message" rows="8" cols="50"></textarea></li>
					<li><input type="image" name="imageField" id="imageField"
						src="templates/public/images/submit.gif" class="send" />
						<div class="clr"></div></li>
				</ol>
			</form>
		</div>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<script>
	var editor = CKEDITOR.replace('message');
</script>
<%@ include file="/templates/public/inc/footer.jsp"%>