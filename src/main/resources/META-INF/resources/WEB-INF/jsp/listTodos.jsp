<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Java Spring Todo</title>
  </head>
  <body>
    <div>List Todos page</div>
    <div>You todos are :</div>
    <table>
      <thead>
        <tr>
          <th>id</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Completed?</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
