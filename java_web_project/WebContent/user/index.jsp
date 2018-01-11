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
        <span class="card-title grey-text text-darken-4">行程预定</span>
        <span>输入偏好信息，为你规划旅游行程！</span>
      </div>
      <div class="card-content">
        <div class="row">
        <form method="post" action="<c:url value='/OrderServlet?m=queryPlans'/>">
          <div class="col s12">
            <div class="input-field col s12 m3 l2" style="color:#144787;font-size:20px;">
              <i class="material-icons">flight_takeoff</i> 航班
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="flightdate">乘坐日期 </label>
              <input id="flightdate" type="date" name="flightdate" class="datepicker" required/>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="departcity">出发地 </label>
              <input id="departcity" type="text" name="departcity" required/>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="arrivecity">目的地 </label>
              <input id="arrivecity" type="text" name="arrivecity" required/>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m3 l2" style="color:#144787;font-size:20px;">
              <i class="material-icons">directions_car</i> 租车
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="cartype"></label>
              <select name="cartype" id="cartype" required>
                <option value="五座">五座车</option>
                <option value="七座">七座车</option>
              </select>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="drivemode"></label>
              <select name="drivemode" id="drivemode" required>
                <option value="手动挡">手动挡</option>
                <option value="自动挡">自动挡</option>
              </select>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m3 l2" style="color:#144787;font-size:20px;">
              <i class="material-icons">business</i> 酒店
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="checkindate">入住时间 </label>
              <input id="checkindate" type="date" name="checkindate" class="datepicker" required/>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="checkoutdate">退房时间 </label>
              <input id="checkoutdate" type="date" name="checkoutdate" class="datepicker" required/>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="roomtype"></label>
              <select name="roomtype" id="roomtype" required>
                <option value="经济">经济型房间</option>
                <option value="商务">商务型房间</option>
                <option value="豪华">豪华型房间</option>
              </select>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m3 l2" style="color:#144787;font-size:20px;">
              <i class="material-icons">map</i> 景点
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="needGuide"></label>
              <select name="needGuide" id="needGuide" required>
                <option value="True">需要导游</option>
                <option value="False">不需要导游</option>
              </select>
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="isAll"></label>
              <select name="isAll" id="isAll" required>
                <option value="True">需要全程陪同</option>
                <option value="False">不需要全程陪同</option>
              </select>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m3 l2" style="color:#144787;font-size:20px;">
              <i class="material-icons">account_balance_wallet</i> 预算
            </div>
            <div class="input-field col s12 m3 l2">
              <label for="budget">大致预算 </label>
              <input id="budget" type="number" name="budget" required/>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m8 l4">
              <button class="waves-effect waves-light btn cyan darken-1" type="submit"><i class="material-icons right">arrow_forward</i>规划方案</button>
            </div>
          </div>
         </form>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="container" style="height:100%;">
  <div class="row">
    <div class="col s12 card">
      <div class="card-content">
        <span class="card-title grey-text text-darken-4">大家都在这样玩</span>
      </div>
      <div class="card-content">
        <div class="row">
          <div class="col s12">
            <a href="<c:url value='/OrderServlet?m=presetOrder&otype=bj'/>">
              <img style="height:240px;" src="<c:url value='/images/bj_tour.png'/>"/>
            </a>
          </div>
          <div class="col s12">
            <a href="<c:url value='/OrderServlet?m=presetOrder&otype=sh'/>">
              <img style="height:245px;" src="<c:url value='/images/sh_tour.png'/>"/>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<footer class="page-footer" style="background-image:url('../images/footer-bar.jpg');background-size:cover;margin-top:100px;">
  <div class="footer-copyright">
      © 服务计算 2017-2018 <br/><br/>
  </div>
</footer>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/materialize.min.js"></script>


<script>
    $('.datepicker').pickadate({
        today: '今天',
        clear: '',
        close: '确定',
        format: 'yyyymmdd'
    });
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

</body>
</html>
