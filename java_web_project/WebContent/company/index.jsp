<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <base href="<c:url value='/company/'/>"/>
  <title>旅游系统企业端</title>
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
  <div class="nav-wrapper" style="background-image:url('../images/bar-1.png');background-size:cover;">
    <a href="<c:url value='/company/index.jsp'/>" class="brand-logo left"><i class="material-icons">beach_access</i>旅游代理系统企业端</a>
    <ul class="right">
      <li style="margin-right:30px;">欢迎，${sessionScope.company.name}</li>
      <li class="waves-effect waves-light"><a href="<c:url value='/UserServlet?m=companyLogout'/>" title="退出"><i class="material-icons">exit_to_app</i></a></li>
    </ul>
    <ul class="tabs" style="background:transparent;">
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text active" href="<c:url value='/company/index.jsp'/>">我的服务</a></li>
      <li class="tab col s2"><a target="_self" class="waves-effect waves-light white-text " href="<c:url value='/company/user.jsp'/>">企业信息</a></li>
  	</ul>
  </div>
</nav>
<br/><br/><br/>

<div class="container" style="height:100%;">
  <div class="row">
    <div class="col s12 card">
      <div class="card-content">
        <span class="card-title grey-text text-darken-4">我的服务</span>
        <span>提供WSDL文档地址，注册你的服务！</span>
        <span style="color:purple;">${msg}</span>
      </div>
      <div class="card-content">
        <div class="row">
        <form method="post" action="<c:url value='/UserServlet?m=companyUpdateWsdl'/>">
          <div class="col s12">
            <div class="input-field col s12">
              <label for="wsdl">wsdl地址 上次更新于${sessionScope.company.updateAt}</label>
              <input id="wsdl" type="text" name="wsdl" value="${sessionScope.company.wsdl}" required/>
            </div>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m8 l4">
              <button class="waves-effect waves-light btn cyan darken-1" type="submit"><i class="material-icons right">arrow_forward</i>保存</button>
            </div>
          </div>
         </form>
        </div>
      </div>
    </div>
  </div>
</div>


<footer class="page-footer" style="background-image:url('../images/bar-1.png');background-size:cover;margin-top:100px;width:100%;position:fixed;bottom:0px;">
  <div class="footer-copyright">
      © 服务计算 2017-2018 <br/><br/>
  </div>
</footer>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/materialize.min.js"></script>



</body>
</html>
