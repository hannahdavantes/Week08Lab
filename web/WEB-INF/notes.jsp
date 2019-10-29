<%-- 
    Document   : notes
    Created on : Oct 29, 2019, 9:04:08 AM
    Author     : 652343
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
    </head>
    <body>
        <form action="notes" method="post">
            <h1>Notes!</h1>
            <h2>Add Note</h2>
            <input type="text" name="inputTitle"><br>
            <textarea name="inputNote" rows="10" cols="40"></textarea>
        </form>
    </body>
</html>
