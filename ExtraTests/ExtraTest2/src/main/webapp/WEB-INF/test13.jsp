<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <s:set var="foo">abcdABCD1234</s:set>
    検索対象文字列：<s:property value="#foo"/><p>
  ABCがどこかにあればマッチ:<s:if test="#foo.contains('ABC')">Match!</s:if><p>
  ABCが先頭にあればマッチ：<s:if test="#foo.startsWith('ABC')">Match!</s:if><p>
  ABCが末尾にあればマッチ：<s:if test="#foo.endsWith('ABC')">Match!</s:if><p>
 
</body>
</html>