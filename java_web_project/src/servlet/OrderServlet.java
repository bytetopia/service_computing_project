package servlet;

import bean.*;
import dao.OrderDao;
import dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderServlet extends BaseServlet {

    private UserDao userDao=new UserDao();
    private OrderDao orderDao=new OrderDao();

    public String myOrder(HttpServletRequest req, HttpServletResponse resp){
        User u=(User)req.getSession().getAttribute("user");
        List<Order> orderList = orderDao.getOrderListByUser(u.getUserId());
        req.setAttribute("orderList", orderList);
        return "user/orderList.jsp";
    }

    public String queryPlans(HttpServletRequest req, HttpServletResponse resp){
        User u=(User)req.getSession().getAttribute("user");
        String orderno=System.currentTimeMillis()+"";
        //接收用户输入，并生成对应的四个类型的查询
        AirlineQuery aq=new AirlineQuery();
        aq.setOrderno(orderno);
        aq.setDepartcity(req.getParameter("departcity"));
        aq.setArrivecity(req.getParameter("arrivecity"));
        aq.setFlightdate(req.getParameter("flightdate"));
        CarQuery cq=new CarQuery();
        cq.setOrderno(orderno);
        cq.setCity(req.getParameter("arrivecity"));
        cq.setType(req.getParameter("cartype"));
        cq.setDrivemode(req.getParameter("drivemode"));
        HotelQuery hq=new HotelQuery();
        hq.setOrderno(orderno);
        hq.setCheckindate(req.getParameter("checkindate"));
        hq.setCheckoutdate(req.getParameter("checkoutdate"));
        hq.setRoomtype(req.getParameter("roomtype"));
        hq.setCity(req.getParameter("arrivecity"));
        SightQuery sq=new SightQuery();
        sq.setOrderno(orderno);
        sq.setCity(req.getParameter("arrivecity"));
        sq.setNeedGuide(req.getParameter("needGuide"));
        sq.setIsAll(req.getParameter("isAll"));
        int budget=Integer.parseInt(req.getParameter("budget"));
        //调用七个web服务，查询并存储结果
        //先初始化
        aq.initialQueryResult();
        cq.initialQueryResult();
        hq.initialQueryResult();
        sq.initialQueryResult();
        //查询所有服务，然后调用
        ArrayList<Company> companyList=userDao.getAllCompany();
        for (Company c:companyList
             ) {
            if(c.getType()==0){ //航空
                aq.executeQuery(c.getWsdl());
            }
            else if(c.getType()==1){ //酒店
                hq.executeQuery(c.getWsdl());
            }
            else if(c.getType()==2){ //租车
                cq.executeQuery(c.getWsdl());
            }
            else{ //景点
                sq.executeQuery(c.getWsdl());
            }
        }
        //将结果装载
        req.setAttribute("aq", aq);
        req.setAttribute("hq", hq);
        req.setAttribute("cq", cq);
        req.setAttribute("sq", sq);
        req.setAttribute("budget", budget);
        req.setAttribute("orderno", orderno);

        return "user/index2.jsp";
    }


    public String confirmOrder(HttpServletRequest req, HttpServletResponse resp) {
        //订单基本信息
        User u=(User)req.getSession().getAttribute("user");
        Order o=new Order();
        o.setOrderId(req.getParameter("orderno"));
        o.setUserId(u.getUserId());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d=new Date();
        o.setOrderAt(sdf.format(d));
        //接收并解析四个服务的参数
        String airlineStr=req.getParameter("airline");
        o.parseAirline(airlineStr);
        String carStr=req.getParameter("car");
        o.parseCar(carStr);
        String hotelStr=req.getParameter("hotel");
        o.parseHotel(hotelStr);
        String[] sightRecv=req.getParameterValues("sight");
        o.parseSight(sightRecv);
/*      航班：订单号orderno，航班号flightno
        租车：订单号orderno，车号c_id（int）
        酒店：订单号orderno，房间号h_id（int），入住日期checkindate，退房日期checkoutdate
        景点：订单号orderno，景点名称字符串v_name，导游名称字符串g_name*/
        //解析公司类型，选择对应的bpel文档
        // 参数传入bpel文档
        String bpelName="";
        if(o.getAirlineId().equals("中国航空")){
            bpelName+="1";
        }
        else{
            bpelName+="2";
        }
        if(o.getCarId().equals("神州租车")){
            bpelName+="1";
        }
        else{
            bpelName+="2";
        }
        if(o.getHotelId().equals("如家")){
            bpelName+="1";
        }
        else{
            bpelName+="2";
        }
        bpelName+="1";
        o.submitOrder(bpelName);
        System.out.println("\n---bpel="+bpelName+"\n");
        orderDao.saveOrder(o);
        req.setAttribute("order", o);
        return "user/index3.jsp";
    }

    public String viewOrderDetail(HttpServletRequest req, HttpServletResponse resp) {
        //订单基本信息
        User u = (User) req.getSession().getAttribute("user");
        String orderno=req.getParameter("oid");
        Order o = orderDao.getOrder(orderno);
        //调用四个服务，获取订单信息
        AirlineQuery aq=new AirlineQuery();
        aq.setOrderno(orderno);
        CarQuery cq=new CarQuery();
        cq.setOrderno(orderno);
        HotelQuery hq=new HotelQuery();
        hq.setOrderno(orderno);
        SightQuery sq=new SightQuery();
        sq.setOrderno(orderno);
        //先初始化
        aq.initialQueryResult();
        cq.initialQueryResult();
        hq.initialQueryResult();
        sq.initialQueryResult();
        //查询所有服务，然后调用
        ArrayList<Company> companyList=userDao.getAllCompany();
        for (Company c:companyList
                ) {
            if(c.getType()==0){ //航空
                aq.executeOrderQuery(c.getWsdl(), orderno);
            }
            else if(c.getType()==1){ //酒店
                hq.executeOrderQuery(c.getWsdl(), orderno);
            }
            else if(c.getType()==2){ //租车
                cq.executeOrderQuery(c.getWsdl(), orderno);
            }
            else{ //景点
                sq.executeOrderQuery(c.getWsdl(), orderno);
            }
        }
        //将结果装载
        req.setAttribute("aq", aq);
        req.setAttribute("hq", hq);
        req.setAttribute("cq", cq);
        req.setAttribute("sq", sq);
        req.setAttribute("order", o);
        return "user/orderDetail.jsp";
    }

    public String presetOrder(HttpServletRequest req, HttpServletResponse resp) {
        String otype=req.getParameter("otype");
        //订单基本信息
        User u=(User)req.getSession().getAttribute("user");
        Order o=new Order();
        o.setOrderId(System.currentTimeMillis()+"");
        o.setUserId(u.getUserId());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d=new Date();
        o.setOrderAt(sdf.format(d));
        //接收并解析四个服务的参数
        String bpelName="1111";
        if(otype.equals("bj")){
            o.setOrderno(o.getOrderId());
            o.setFlightno("20180103102");
            o.setC_id("1");
            o.setH_id("1");
            o.setCheckindate("20180103");
            o.setCheckoutdate("20180105");
            o.setV_name("长城#香山#颐和园");
            o.setG_name("阿满#阿满#阿满");
            bpelName="1111";
        }
        else{
            o.setOrderno(o.getOrderId());
            o.setFlightno("20180103201");
            o.setC_id("5");
            o.setH_id("5");
            o.setCheckindate("20180103");
            o.setCheckoutdate("20180105");
            o.setV_name("杜莎夫人蜡像馆#外滩");
            o.setG_name("null#null");
            bpelName="2221";
        }

        o.submitOrder(bpelName);
        System.out.println("\n---bpel="+bpelName+"\n");
        orderDao.saveOrder(o);
        req.setAttribute("order", o);
        return "user/index3.jsp";
    }


}

