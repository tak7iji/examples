<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<body>
<h1>Struts 2 download file example</h1>

<s:url id="fileDownload" namespace="/" action="download" ></s:url>

<h4>Download file - <s:a href="%{fileDownload}">fileABC.txt</s:a>
</h4>
	
</body>
</html>