<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="site" %>
<html:html locale="true">
  <head>
    <title>Bookmark List</title>
    <site:css/>
  </head>
  <body>
    <h1>Bookmark List</h1>

    <table border="1">
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>URL</th>
        <th>Action</th>
      </tr>
  <c:forEach items="${list}" var="b">
      <tr>
        <th>${b.id}</th>
        <td><a href="${b.url}" target="_new">${b.name}</a></td>
        <td>${b.url}</td>
        <td><a href="<c:url value="/edit.do?id=${b.id}"/>">Edit</a>&nbsp;<a href="<c:url value="/delete.do?id=${b.id}"/>">Delete</a></td>
      </tr>
  </c:forEach>
    </table>
    <br/>
    <h2>New Bookmark:</h2>
    <html:form action="/add" method="POST">
      <html:hidden property="id"/>
      <table border="1">
        <tr>
          <th>Name</th>
          <td><html:text property="name" maxlength="40" size="40" value=""/></td>
        </tr>
        <tr>
          <th>URL</th>
          <td><html:text property="url" maxlength="255" size="40" value=""/></td>
        </tr>
        <tr>
          <td colspan="2"><html:submit value="Save"/></td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>
