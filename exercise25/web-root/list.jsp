<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic-el.tld" prefix="logic" %>
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
    <a href="<c:url value="/add.do"/>">Add Bookmark</a>
  </body>
</html:html>
