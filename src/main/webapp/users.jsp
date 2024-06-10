<%@ page import="java.util.List" %>
<%@ page import="ResumeJpaDb.Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03-Jun-24
  Time: 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%="Users"%>
    </title>
    <link rel="stylesheet" href="assets/css/usertamplate.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="assets/js/user.js"></script>
    <script src="https://kit.fontawesome.com/aec1554bc2.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    User user = (User) request.getSession().getAttribute("loggedInUser");
%>
<div class="container mycontainer">
    Welcome, <%=user.getFirstname()%>
    <form action="logout" method="post">
        <div style="position: absolute;top: 8px;right: 16px;">
            <button class="btn btn-info btn-lg">
                <span class="glyphicon glyphicon-log-out"></span> Log out
            </button>
        </div>
    </form>
    <form action="users" method="get">
        <div class="row">
            <div class="form-group col-4">
                <label for="name">Name:</label>
                <input type="text" name="firstname" value="" class="form-control" placeholder="Enter firstname">
                <br>
                <label for="surname">Surname:</label>
                <input type="text" name="lastname" value="" class="form-control" placeholder="Enter lastname">
                <br>
                <input type="submit" name="search" value="search" class="btn btn-primary">
            </div>
        </div>
    </form>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">№</th>
                <th scope="col">Firstname</th>
                <th scope="col">Lastname</th>
                <th scope="col">E-mail</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                int i = 0;
                for (User u : users) {
                    i++;
            %>
            <tr>
                <th scope="row"><%=i%>
                </th>
                <td><%=u.getFirstname() == null ? "N/A" : u.getFirstname()%>
                </td>
                <td><%=u.getLastname() == null ? "N/A" : u.getLastname()%>
                </td>
                <td><%=u.getEmail() == null ? "N/A" : u.getEmail()%>
                </td>
                <td>
                    <button class="btn btn-danger" data-toggle="modal"
                            data-target="#exampleModal"
                            onclick="setIdForDelete(<%=u.getId()%>)">
                        <i class="fa-solid fa-user-xmark"></i>
                    </button>
                </td>
                <td>
                    <form action="userupdate" method="get">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <button name="action" value="update" class="btn btn-secondary">
                            <i class="fa-solid fa-pencil"></i>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="userdetail" method="get">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <button name="action" value="detail" class="btn btn-info">
                            <i class="fa-solid fa-circle-info"></i>
                        </button>
                    </form>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>

    </div>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
                <form action="userdelete" method="post">
                    <input type="hidden" name="id" value="" id="IdForDelete">
                    <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
