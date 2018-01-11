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
        <span class="card-title grey-text text-darken-4">方案选择</span>
      <c:if test="${fn:length(sq.queryResult)==0 or fn:length(hq.queryResult)==0 or fn:length(aq.queryResult)==0 or fn:length(cq.queryResult)==0}">
          <span>抱歉！没有找到符合要求的方案，请返回修改一下哦！</span>
      </c:if>
      <c:if test="${fn:length(sq.queryResult)!=0 and fn:length(hq.queryResult)!=0 and fn:length(aq.queryResult)!=0 and fn:length(cq.queryResult)!=0}">
          <span>根据您的偏好，为您推荐以下方案，可自由搭配！</span>
      </c:if>
      </div>
      <div class="card-content">
        <div class="row">
        <form method="post" action="<c:url value='/OrderServlet?m=confirmOrder'/>">
            <input type="hidden" name="orderno" value="${orderno}"/>
          <div class="col s12">
            <ul class="collapsible" data-collapsible="expandable">
              <li class="active">
                <div class="collapsible-header active"><i class="material-icons">account_box</i> 基本信息</div>
                <div class="collapsible-body active">
                  <p>航班出发日期： ${aq.flightdate}</p>
                  <p>酒店入住日期： ${hq.checkindate}</p>
                  <p>酒店退房日期： ${hq.checkoutdate}</p>
                  <p>出行地点： ${hq.city}</p>
                  <p>旅行预算： ￥${budget}</p>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">flight_takeoff</i> 航班</div>
                <div class="collapsible-body">
                  <c:if test="${fn:length(aq.queryResult)==0}">
                    <span>抱歉！没有符合您要求的航班 T^T</span>
                  </c:if>
                  <c:if test="${fn:length(aq.queryResult)!=0}">
                  <span>为你推荐以下航班可供选择：</span>
                  <table class="striped responsive-table">
                    <thead>
                      <tr>
                        <th>选择</th>
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
                        <td>
                          <input class="with-gap" type="radio" id="${a.company}#${aq.orderno}#${a.flightno}" name="airline" value="${a.company}#${aq.orderno}#${a.flightno}" required/>
                          <label for="${a.company}#${aq.orderno}#${a.flightno}"> </label>
                        </td>
                        <td>${a.flightno}</td>
                        <td>${a.company}</td>
                        <td>${a.departtime}</td>
                        <td>${a.arrivetime}</td>
                        <td>${a.price}</td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  </c:if>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">directions_car</i> 租车</div>
                <div class="collapsible-body">
                  <c:if test="${fn:length(cq.queryResult)==0}">
                    <span>抱歉！没有符合您要求的租车服务 T^T</span>
                  </c:if>
                  <c:if test="${fn:length(cq.queryResult)!=0}">
                  <span>为你推荐以下租车方案：</span>
                  <table class="striped responsive-table">
                    <thead>
                      <tr>
                        <th>选择</th>
                        <th>车编号</th>
                        <th>租车公司</th>
                        <th>车型</th>
                        <th>驾驶模式</th>
                        <th>日租金</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cq.queryResult}" var="c">
                    <tr>
                      <td>
                        <input class="with-gap" type="radio" id="${c.company}#${cq.orderno}#${c.c_id}" name="car" value="${c.company}#${cq.orderno}#${c.c_id}" required/>
                        <label for="${c.company}#${cq.orderno}#${c.c_id}"> </label>
                      </td>
                      <td>${c.c_id}</td>
                      <td>${c.company}</td>
                      <td>${c.type}</td>
                      <td>${c.drivemode}</td>
                      <td>${c.price}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  </c:if>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">business</i> 酒店</div>
                <div class="collapsible-body">
                  <c:if test="${fn:length(hq.queryResult)==0}">
                    <span>抱歉！没有符合您要求的酒店方案 T^T</span>
                  </c:if>
                  <c:if test="${fn:length(hq.queryResult)!=0}">
                  <span>为你推荐以下酒店方案：</span>
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>选择</th>
                      <th>房间编号</th>
                      <th>酒店</th>
                      <th>房间配置</th>
                      <th>日租金</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hq.queryResult}" var="h">
                    <tr>
                      <td>
                        <input class="with-gap" type="radio" id="${h.company}#${hq.orderno}#${h.h_id}#${h.checkindate}#${h.checkoutdate}" name="hotel" value="${h.company}#${hq.orderno}#${h.h_id}#${h.checkindate}#${h.checkoutdate}" required/>
                        <label for="${h.company}#${hq.orderno}#${h.h_id}#${h.checkindate}#${h.checkoutdate}"> </label>
                      </td>
                      <td>${h.h_id}</td>
                      <td>${h.company}</td>
                      <td>${h.type}</td>
                      <td>${h.price}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  </c:if>
                </div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">map</i> 景点</div>
                <div class="collapsible-body">
                  <c:if test="${fn:length(sq.queryResult)==0}">
                    <span>抱歉！没有符合您要求的景点导游方案 T^T</span>
                  </c:if>
                  <c:if test="${fn:length(sq.queryResult)!=0}">
                  <span>为你推荐以下景点：</span>
                  <table class="striped responsive-table">
                    <thead>
                    <tr>
                      <th>多选</th>
                      <th>景点</th>
                      <th>区域</th>
                      <th>票价</th>
                      <th>导游</th>
                      <th>导游公司</th>
                      <th>导游费用</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sq.queryResult}" var="s">
                    <tr>
                      <td>
                        <input class="filled-in" type="checkbox" id="${s.company}#${sq.orderno}#${s.v_name}#${s.g_name}" name="sight" value="${s.company}#${sq.orderno}#${s.v_name}#${s.g_name}"/>
                        <label for="${s.company}#${sq.orderno}#${s.v_name}#${s.g_name}"> </label>
                      </td>
                      <td>${s.v_name}</td>
                      <td>${s.v_county}</td>
                      <td>${s.v_price}</td>
                      <td>${s.g_name}</td>
                      <td>${s.company}</td>
                      <td>${s.price}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  </c:if>
                </div>
              </li>
            </ul>
          </div>
          <br/>
          <div class="col s12">
            <div class="input-field col s12 m8 l4">
            <c:if test="${fn:length(sq.queryResult)==0 or fn:length(hq.queryResult)==0 or fn:length(aq.queryResult)==0 or fn:length(cq.queryResult)==0}">
              <a class="waves-effect waves-light btn green darken-1" onclick="javascript:history.back();"><i class="material-icons left">arrow_back</i>返回调整</a>
            </c:if>
            <c:if test="${fn:length(sq.queryResult)!=0 and fn:length(hq.queryResult)!=0 and fn:length(aq.queryResult)!=0 and fn:length(cq.queryResult)!=0}">
              <button class="waves-effect waves-light btn cyan darken-1" type="submit"><i class="material-icons right">arrow_forward</i>确认下单</button>
            </c:if>
            </div>
          </div>
        </form>
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
