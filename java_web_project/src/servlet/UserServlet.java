package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Company;
import bean.User;
import dao.UserDao;

import java.text.SimpleDateFormat;
import java.util.Date;


public class UserServlet extends BaseServlet {

    private UserDao userDao=new UserDao();

    //用户登录
    public String login(HttpServletRequest req, HttpServletResponse resp){
        String userId=req.getParameter("userId");
        String pwd=req.getParameter("password");
        User user=userDao.getUserById(userId);
        //用户尚未注册
        if(user==null){
            req.setAttribute("msg","找不到用户");
        }
        else if(user.getPwd().equals(pwd)){
            req.getSession().setAttribute("user",user);
            return "user/index.jsp";
        }
        else{
            req.setAttribute("msg","密码错误");
        }
        req.setAttribute("userId", userId);
        return "login.jsp";
    }

    //注销登录
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().invalidate();
        return "login.jsp";
    }

    //企业登录
    public String companyLogin(HttpServletRequest req, HttpServletResponse resp){
        String companyId=req.getParameter("companyId");
        String pwd=req.getParameter("password");
        Company company=userDao.getCompanyUserById(companyId);
        //用户尚未注册
        if(company==null){
            req.setAttribute("msg","找不到用户");
        }
        else if(company.getPwd().equals(pwd)){
            req.getSession().setAttribute("company",company);
            return "company/index.jsp";
        }
        else{
            req.setAttribute("msg","密码错误");
        }
        req.setAttribute("companyId", companyId);
        return "companyLogin.jsp";
    }

    //注销登录
    public String companyLogout(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().invalidate();
        return "companyLogin.jsp";
    }

    public String updateCompanyInfo(HttpServletRequest req, HttpServletResponse resp){
        Company c = (Company)req.getSession().getAttribute("company");
        c.setPwd(req.getParameter("pwd"));
        c.setName(req.getParameter("name"));
        c.setDescription(req.getParameter("description"));
        userDao.updateCompanyInfo(c);
        req.setAttribute("msg","更新成功。");
        return "company/user.jsp";
    }

    public String companyUpdateWsdl(HttpServletRequest req, HttpServletResponse resp){
        Company c = (Company)req.getSession().getAttribute("company");
        c.setWsdl(req.getParameter("wsdl"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d=new Date();
        c.setUpdateAt(sdf.format(d));
        userDao.updateCompanyInfo(c);
        req.setAttribute("msg","更新成功。");
        return "company/index.jsp";
    }

    public String updateUserInfo(HttpServletRequest req, HttpServletResponse resp){
        User u = (User)req.getSession().getAttribute("user");
        u.setPwd(req.getParameter("pwd"));
        u.setEmail(req.getParameter("email"));
        u.setPhone(req.getParameter("phone"));
        userDao.updateUserInfo(u);
        req.setAttribute("msg","更新成功。");
        return "user/user.jsp";
    }



}

