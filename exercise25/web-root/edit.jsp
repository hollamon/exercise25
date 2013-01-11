<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic-el.tld" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="site" %>
<html:html locale="true">
  <head>
    <title>Bookmark Edit</title>
    <site:css/>
  </head>
  <body>
    <h1>Bookmark Edit</h1>

	<logic:messagesPresent>
		<div class="info">
			<html:messages id="msg">
				<li>${msg}</li>
			</html:messages>
		</div>
	</logic:messagesPresent>
	<br/>
    <html:form action="/editsave" method="POST">
      <html:hidden property="id"/>
      <table border="1">
        <tr>
          <th>Name</th>
          <td><html:text property="name" maxlength="40" size="40"/></td>
        </tr>
        <tr>
          <th>URL</th>
          <td><html:text property="url" maxlength="255" size="40"/></td>
        </tr>
        <tr>
          <td colspan="2"><html:submit value="Save"/>&nbsp;<html:cancel value="Cancel"/></td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>
