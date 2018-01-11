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
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text active" href="<c:url value='/user/index.jsp'/>">行程预定</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/OrderServlet?m=myOrder'/>">我的订单</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/user/user.jsp'/>">个人信息</a></li>
  	</ul>
  </div>
</nav>
<br/><br/><br/>

<div class="container" style="height:100%;">
  <div class="row">
    <div class="col s12 card">
      <div class="card-content">
        <span class="card-title grey-text text-darken-4">订单详情</span>
      </div>
      <div class="card-content">
        <div class="row">
          <div class="col s12">
            <ul class="collapsible" data-collapsible="expandable">
              <li class="active">
                <div class="collapsible-header active"><i class="material-icons">account_box</i> 基本信息</div>
                <div class="collapsible-body active">
                  <p>订单号：${aq.orderno}</p>
                  <p>航班下单状态： ${order.airlineStatus}</p>
                  <p>酒店下单状态： ${order.hotelStatus}</p>
                  <p>租车下单状态： ${order.carStatus}</p>
                  <p>景点下单状态： ${order.sightStatus}</p>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">flight_takeoff</i> 航班</div>
                <div class="collapsible-body">
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>航班号</th>
                      <th>航空公司</th>
                      <th>出发时间</th>
                      <th>到达时间</th>
                      <th>票价</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${aq.queryResult}" var="a">
                      <tr>
                        <td>${a.flightno}</td>
                        <td>${a.company}</td>
                        <td>${a.departtime}</td>
                        <td>${a.arrivetime}</td>
                        <td>${a.price}</td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">directions_car</i> 租车</div>
                <div class="collapsible-body">
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>租车公司</th>
                      <th>车型</th>
                      <th>驾驶模式</th>
                      <th>日租金</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cq.queryResult}" var="c">
                      <tr>
                        <td>${c.company}</td>
                        <td>${c.type}</td>
                        <td>${c.drivemode}</td>
                        <td>${c.price}</td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">business</i> 酒店</div>
                <div class="collapsible-body">
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>酒店</th>
                      <th>房间配置</th>
                      <th>日租金</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hq.queryResult}" var="h">
                      <tr>
                        <td>${h.company}</td>
                        <td>${h.type}</td>
                        <td>${h.price}</td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">map</i> 景点</div>
                <div class="collapsible-body">
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>景点-导游</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sq.orderResult}" var="s">
                    <tr>
                      <td>${s}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </li>
            </ul>
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
