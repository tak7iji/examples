<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html><body>

<h1>For Struts1</h1>
<bean:define id="foo" value="abcdABCD1234"/>
検索対象文字列：<bean:write name="foo"/><p>
ABCがどこかにあればマッチ: <logic:match name="foo" value="ABC">Match!</logic:match><p>
ABCが先頭にあればマッチ：<logic:match name="foo" location="start" value="ABC">Match!</logic:match><p>
ABCが末尾にあればマッチ：<logic:match name="foo" location="end" value="ABC">Match!</logic:match><p>

<h1>For JSTL</h1>
検索対象文字列：<c:out value="${foo}"/><p>
ABCがどこかにあればマッチ:<c:if test="${fn:contains(foo,'ABC')}">Match!</c:if><p>
ABCが先頭にあればマッチ：<c:if test="${fn:startsWith(foo,'ABC')}">Match!</c:if><p>
ABCが末尾にあればマッチ：<c:if test="${fn:endsWith(foo,'ABC')}">Match!</c:if><p>

<h1>For EL</h1>
検索対象文字列：${foo}<p>
ABCがどこかにあればマッチ:${fn:contains(foo,"ABC") ? "Match!" : ""}<p>
ABCが先頭にあればマッチ：${fn:startsWith(foo,"ABC") ? "Match!" : ""}<p>
ABCが末尾にあればマッチ：${fn:endsWith(foo,"ABC") ? "Match!" : ""}<p>

</body></html> 