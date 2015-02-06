<#import "/spring.ftl" as spring />
<html>

<body>
<h1>SpringMVC localization example</h1>
<@spring.message "global.username"/>
<form method="POST" action='<@spring.url "/welcome"/>'>
<@spring.bind "mb.message" />
<@spring.showErrors "<br>"/><p>
<@spring.formInput "mb.message",""/>
<input type="submit">
</form>

</body>
</html>