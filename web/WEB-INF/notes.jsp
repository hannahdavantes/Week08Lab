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
        <form action="notes" method="post">
            <table>
                <tr>
                    <th>Date Created</th>
                    <th>Title</th>
                </tr>
                <c:forEach var="note" items="${notes}">
                    <tr>

                        <td>${note.datecreated}</td>
                        <td>${note.title}</td>

                    </tr>
                </c:forEach>
            </table>


            <input type="hidden" name="actionType" value="editNote">
        </form>

        <form action="notes" method="post">

            <h2>Add Note</h2>
            <input type="text" name="inputTitle"><br>
            <textarea name="inputNote" rows="10" cols="40"></textarea>
            <input type="hidden" name="actionType" value="addNote">
        </form>
    </body>
</html>
