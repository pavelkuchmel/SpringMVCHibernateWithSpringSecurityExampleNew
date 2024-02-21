<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show office</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%@include file="authheader.jsp" %>

    <div class="well lead">Create office</div>
    <form:form method="POST" modelAttribute='office' class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address">Address</label>
                <div class="col-md-7">
                    <form:input type="text" path="address" id="address" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="address" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="phone1">Phone 1</label>
                <div class="col-md-7">
                    <form:input type="text" path="phone1" id="phone1" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="phone1" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="phone2">Phone 2</label>
                <div class="col-md-7">
                    <form:input type="text" path="phone2" id="phone2" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="phone2" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="postalCode">Postal Code</label>
                <div class="col-md-7">
                    <form:input type="text" path="postalCode" id="postalcode" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="postalCode" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <input type="submit" value="Create" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
    </form:form>

    <a href="<c:url value='/list' />">Go back</a>

</div>
</body>
</html>
