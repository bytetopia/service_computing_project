<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登录</title>
  <!--Import Google Icon Font-->
  <link href="css/googlefont.css" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <!--custom styles!-->
  <link href="css/custom.css" rel="stylesheet">
</head>
<body style="min-height:800px;height:100%;width:100%;" class="valign-wrapper">
<div class="container v-align">
    <div class="row">
      <div class="valign col s12 m8 push-m2 l6 push-l3">
        <div class="card">
          <form style="display:inline-block" action="<c:url value='/UserServlet'/>" method="post">
            <div class="card-image">
              <img style="max-height:300px;overflow:hidden;" src="images/login-pic.jpg">
              <span class="card-title">旅游代理系统</span>
              <button type="submit" class="btn-floating halfway-fab waves-effect waves-light blue darken-3"><i class="material-icons">arrow_forward</i></button>
            </div>
            <div class="card-content">
                <input type="hidden" name="m" value="login"/>
                <div class="input-field col s12">
                     <span style="color:#ff1760;">${msg}</span>
                </div>
                <div class="input-field col s12">
                  <input id="userId" name="userId" required type="text" value="${userId}">
                  <label for="userId">用户名</label>
                </div>
                <div class="input-field col s12">
                  <input id="password" name="password" required type="password">
                  <label for="password">密码</label>
                </div>
            </div>
          </form>
            <br/>
        </div>
      </div>
    </div>
</div>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
