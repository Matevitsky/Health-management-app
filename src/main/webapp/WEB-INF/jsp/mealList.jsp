<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>

<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>


<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="meals.title"/></h3>

            <form method="post" action="meals/filter">
                <dl>
                    <dt>From Date:</dt>
                    <dd><input type="date" name="startDate" value="${startDate}"></dd>
                </dl>
                <dl>
                    <dt>To Date:</dt>
                    <dd><input type="date" name="endDate" value="${endDate}"></dd>
                </dl>
                <dl>
                    <dt>From Time:</dt>
                    <dd><input type="time" name="startTime" value="${startTime}"></dd>
                </dl>
                <dl>
                    <dt>To Time:</dt>
                    <dd><input type="time" name="endTime" value="${endTime}"></dd>
                </dl>
                <button type="submit"><fmt:message key="meals.filter"/></button>
            </form>
            <hr>
            <a href="meals/create"><fmt:message key="meals.add"/></a>
            <hr>
            <table border="1" cellpadding="8" cellspacing="0">

                <div class="view-box">
                    <a class="btn btn-sm btn-info"><fmt:message key="meals.add"/></a>

                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Date</th>
                            <th>Description</th>
                            <th>Calories</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <c:forEach items="${mealList}" var="meal">
                            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.UserMealWithExceed"/>
                            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                                <td>
                                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                                        ${fn:formatDateTime(meal.dateTime)}
                                </td>
                                <td>${meal.description}</td>
                                <td>${meal.calories}</td>
                                <td><a href="meals/update?id=${meal.id}">Update</a></td>
                                <td><a href="meals/delete?id=${meal.id}">Delete</a></td>
                                <td><a class="btn btn-xs btn-primary">Update</a></td>
                                <td><a class="btn btn-xs btn-danger">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </table>
        </div>
    </div>
</div>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>