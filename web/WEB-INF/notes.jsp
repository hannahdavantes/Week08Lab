<%-- 
    Document   : notes
    Created on : Oct 29, 2019, 9:04:08 AM
    Author     : 652343
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
    </head>
    <body>
        <h1>Notes!</h1>

        <table>
            <tr>
                <th width="250">Date Created</th>
                <th width="200">Title</th>
            </tr>
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td width="250">${note.datecreated}</td>
                    <td width="200">${note.title}</td>
                    <td>   
                        <form action="<c:url value='notes'>
                                  <c:param name='action' value='view'/>
                                  <c:param name='id' value='${note.noteid}'/></c:url>" method="post">
                                  <input type="submit" value="Edit">
                              </form>
                        </td>
                    </tr>
            </c:forEach>
        </table>

        <br><br><br>
        <c:if test="${edit eq false}">
            <form action="<c:url value='notes'>
                      <c:param name='action' value='add'/></c:url>" method="post">
                      <h2>Add Note</h2>
                      <input type="text" name="inputTitle" placeholder="title" value="${note.title}"><br>
                  <textarea name="inputContents" rows="10" cols="40" placeholder="type a note...">${note.contents}</textarea><br>
                  <input type="submit" value="Add">
            </form>
        </c:if>

        <c:if test="${edit eq true}">
            <form action="<c:url value='notes'>
                      <c:param name='action' value='delete'/>
                      <c:param name='id' value='${note.noteid}'/></c:url>" method="post">
                      <input type="submit" value="Delete">
                  </form>
                  <form action="<c:url value='notes'>
                      <c:param name='action' value='edit'/>
                      <c:param name='id' value='${note.noteid}'/></c:url>" method="post">
                      <h2>Edit Note</h2>
                      <input type="text" name="inputTitle" value="${note.title}"><br>
                  <textarea name="inputContents" rows="10" cols="40">${note.contents}</textarea><br>
                  <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
