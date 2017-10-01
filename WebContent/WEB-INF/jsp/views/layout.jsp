<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link type="text/css" rel="stylesheet" href="<c:url value="/styles/main.css" />" />
</head>
<body>
	<span id="dialogContainer " style="visibility: none;"></span>
	<table class="layout_main_table" border="3" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td class="css_layout_header" align="center" height="30">
				<tiles:insertAttribute name="header" />
		</tr>
		<tr>
			<td class="css_layout_menu" height="20">
				<tiles:insertAttribute name="menu" />
		</tr>
		<tr>
			<td class="css_layout_body">
				<tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr>
			<td class="css_layout_footer" height="30">
				<tiles:insertAttribute name="footer" />
		</tr>
	</table>
</body>
</html>