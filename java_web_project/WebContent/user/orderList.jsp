<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <base href="<c:url value='/user/'/>"/>
  <title>旅游系统客户端</title>
  <!--Import Google Icon Font-->
  <link href="../css/googlefont.css" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="../css/materialize.min.css" media="screen,projection"/>
  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <!--custom styles!-->
  <link href="../css/custom.css" rel="stylesheet">
</head>
<body>

<nav style="height:100%;width:100%;positon:absolute;top:0px;">
  <div class="nav-wrapper" style="background-image:url('../images/top-bar.jpg');background-size:cover;">
    <a href="<c:url value='/user/index.jsp'/>" class="brand-logo left"><i class="material-icons">beach_access</i>旅游代理系统</a>
    <ul class="right">
      <li style="margin-right:30px;">欢迎，${sessionScope.user.userId}</li>
      <li class="waves-effect waves-light"><a href="<c:url value='/UserServlet?m=logout'/>" title="退出"><i class="material-icons">exit_to_app</i></a></li>
    </ul>
    <ul class="tabs" style="background:transparent;">
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/user/index.jsp'/>">行程预定</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text active" href="<c:url value='/OrderServlet?m=myOrder'/>">我的订单</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/user/user.jsp'/>">个人信息</a></li>
  	</ul>
  </div>
</nav>
<br/><br/><br/>

<div class="container" style="height:100%;">
  <div class="row">
    <div class="col s12 card">
      <div class="card-content">
        <span class="card-title grey-text text-darken-4">我的订单</span>
      </div>
      <div class="card-content">
        <div class="row">
          <div class="col s12">
            <c:if test="${fn:length(orderList)==0 }">
              暂无订单。
            </c:if>
            <c:if test="${fn:length(orderList)!=0}">

            <table class="striped responsive-table">
              <thead>
              <tr>
                <th>订单号</th>
                <th>下单时间</th>
                <th>航班状态</th>
                <th>酒店状态</th>
                <th>租车状态</th>
                <th>景点状态</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${orderList}" var="o">
                <tr>
                  <td>${o.orderId}</td>
                  <td>${o.orderAt}</td>
                  <td>${o.airlineStatus}</td>
                  <td>${o.hotelStatus}</td>
                  <td>${o.carStatus}</td>
                  <td>${o.sightStatus}</td>
                  <td><a href="<c:url value='/OrderServlet?m=viewOrderDetail&oid=${o.orderId}'/>">详情</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            </c:if>
          </div>
          <br/>
        </div>
      </div>
    </div>
  </div>
</div>



<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/materialize.min.js"></script>


</body>
</html>
