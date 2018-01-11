服务计算是第一学期的课程，主要讲了怎么把多个不同商家提供的web服务，通过一种规范的方式定义接口，然后进行服务的组合调用。

课程的大作业，是做一个旅游代理系统，将航班、酒店、租车、景点导游等几种以wsdl文档形式提供出来的服务，使用bpel进行组合，完成一键下单的功能。

## web服务
简单的java程序。接收用户的条件参数，在数据库中查询，返回符合条件的结果。接收下单参数，数据库中增加订单。
web服务最终需通过axis2 archiver打包为aar文件，部署在axis2中。

> ref：http://blog.csdn.net/xiaochunyong/article/details/7764683

## bpel文档
通过Eclipse安装Bpel插件，可以可视化编辑bpel文档，完成对各个web服务的添加，和整个调用的流程。
bpel文档最终也会被打包，部署在apache ode，仍然是通过wsdl文档的方式对外提供接口，供外界调用。

> ref: https://daod.github.io/Tutorial-on-BPEL/

## 客户界面
通过jsp简单做了web界面，用户输入条件，通axis2提供的一些jar包，在java中可以调用web服务。（其实就是通过post请求的方式传参数，然后解析返回的xml，封装起来了）。