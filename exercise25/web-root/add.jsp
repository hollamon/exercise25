<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic-el.tld" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="site" %>
<html:html locale="true">
  <head>
    <title>Bookmark Add</title>
    <site:css/>
  </head>
  <body>
    <h1>Bookmark Add</h1>

<%
// This code will print out all of the items in session.  It is handy when
// debugging stuff.  Uncomment the out.println to make it work.
java.util.Enumeration keys = session.getAttributeNames();
while (keys.hasMoreElements())
{
  String key = (String)keys.nextElement();
  // out.println(key + ": " + session.getValue(key) + "<br>");
}
%>
	<logic:messagesPresent>
		<div class="info">
			<html:messages id="msg">
				<li>${msg}</li>
			</html:messages>
		</div>
	</logic:messagesPresent>
	<br/>
    <html:form action="/addsave" method="POST">
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
