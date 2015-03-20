<html>
<body>
<h1>SpringMVC + MyBatis example 1</h1>

<#if data??>
<#list data as col>
id: ${col.id}<br>
name: ${col.name}<br>
address: ${col.address}<br>
</#list>
</#if>

</body>
</html>