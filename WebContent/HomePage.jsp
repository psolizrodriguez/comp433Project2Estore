<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CROMISOFT</title>
<script type="text/javascript"
	src="<c:url value="/jquery-ui-1.8.16.custom/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/jquery.i18n.properties.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/scripts/common.js" />"></script>
<script language="javascript">
	$(function() {
		fullscreen();
	});
	function fullscreen() {
		params = 'width=' + screen.width;
		params += ', height=' + screen.height;
		params += ', top=0, left=0, scrollbars=yes, toolbar=no, menubar=no, status=no,resizable=no';
		//newwin = window.open("contact.html", 'windowname4', params);
		window.location = '' + param.common.welcomePage.value;
		if (window.focus) {
			newwin.focus();
		}
		return false;
	}

	function CloseWindow() {
		window.open('', '_self', '');
		window.close();
	}
</script>
</head>
<body>
</body>
</html>





