<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="site" %>
<html:html locale="true">
  <head>
    <title>Bookmark Delete</title>
    <site:css/>
  </head>
  <body>
    <h1>Bookmark Delete</h1>

    <html:form action="/deletebookmark" method="POST">
      <html:hidden property="id"/>
      <table border="1">
        <tr>
          <th>Name</th>
          <td>${bookmarkForm.name}</td>
        </tr>
        <tr>
          <th>URL</th>
          <td>${bookmarkForm.url}</td>
        </tr>
        <tr>
          <td colspan="2"><html:submit value="Delete"/>&nbsp;<html:cancel value="Cancel"/></td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>
