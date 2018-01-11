<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <base href="<c:url value='/pages/'/>"/>
  <title>企业管理端</title>
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
    <a href="<c:url value='/service?m=query'/>" class="brand-logo left"><i class="material-icons">extension</i>酒店管理</a>
    <ul class="right">
      <li style="margin-right:30px;">欢迎，管理员</li>
      <li class="waves-effect waves-light"><a href="<c:url value='/service?m=logout'/>" title="退出"><i class="material-icons">exit_to_app</i></a></li>
    </ul>
    <ul class="tabs" style="background:transparent;">
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/service?m=query'/>">查看酒店</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text active" href="<c:url value='/pages/add.jsp'/>">新增酒店</a></li>
  	</ul>
  </div>
</nav>
<br/><br/><br/>

<div class="container" style="height:100%;">
  <div class="row">
    <div class="col s12 card">
      <div class="card-content">
        <span class="card-title grey-text text-darken-4">新增酒店</span>
      </div>
      <div class="card-content">
        <div class="row">
        <br/>  &nbsp;&nbsp;${msg }<br/>
        <form method="post" action="<c:url value='/service?m=add'/>">
        <div class="input-field col s12 m3 l2">
            <label for="no">酒店号码 </label>
            <input id="no" type="text" name="no" required/>
          </div>
          <div class="input-field col s12 m3 l2">
            <label for="city">所在城市 </label>
            <input id="city" type="text" name="city" required/>
          </div>
          <div class="input-field col s12 m3 l2">
            <label for="price">价位 </label>
            <input id="price" type="number" min="0.0" step="0.01" name="price" required/>
          </div>
          <div class="input-field col s12 m8 l4">
              <button class="waves-effect waves-light btn cyan darken-1" type="submit"><i class="material-icons right">arrow_forward</i>保存</button>
          </div>
         </form>
         <br/><br/>
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
