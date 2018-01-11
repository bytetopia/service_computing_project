——数据库——
用户名：abc 
密码：123456


——接口说明——
---AirlineCompany1---

--ArrayList<String> getAirline(String flightdate, String departcity, String arrivecity)
INPUT:
出发日期，CHAR(8)，如20180103
出发地
目的地

OUTPUT:
flightno + " " + company + " " + flightdate + " " + departtime + " " + arrivetime + " " + departcity + " " + arrivecity + " " + price.toString()
 航班号           航空公司            出发日期           出发时间             到达时间             出发地              目的地                票价     
CHAR(11),如20180103101                                   CHAR(5)，如12:30                                                           INT
即出发日期为20180103，航空公司为airline1，当天发出批次为01                    


--void setOrder(String orderno, String flightno)
INPUT:
订单号，VARCHAR(20)
航班号


--String getOrder(String orderno)
INPUT:
订单号

OUTPUT:
orderno + " " + flightno + " " + company + " " + flight_date + " " + departtime + " " + arrivetime + " " + depart_city + " " + arrive_city + " " + price.toString()
 订单号            航班号           航空公司           出发日期             出发时间             到达时间             出发地               目的地               票价



---CarCompany1---

--ArrayList<String> getCar(String city, String type, String drivemode)
INPUT:
目的地
车型，{“五座”，“七座”}
驾驶模式，{“手动挡”，“自动挡”}

OUTPUT:
id.toString() + " " + company + " " + city + " " + type + " " + drivemode  + " " + price.toString()
 车编号                租车公司          目的地         车型          驾驶模式            日租金
 INT                                                                                INT


--void setOrder(String orderno, Integer c_id)
INPUT:
订单号，VARCHAR(20)
车编号


--String getOrder(String orderno)
INPUT:
订单号

OUTPUT:
orderno + " " + company + " " + city + " " + type + " " + drivemode + " " + price.toString()
 订单号          租车公司          目的地         车型          驾驶模式           日租金



---HotelCompany1---

--ArrayList<String> getHotelRoom(String checkindate, String checkoutdate, String city, String type)
INPUT:
入住日期，CHAR(8)，如20180104
退房日期，CHAR(8)，如20180106
目的地
房间配置，{“经济”，“商务”，“豪华”}

OUTPUT:
id.toString() + " " + company + " " + checkindate + " " + checkoutdate + " " + city + " " + type + " " + price.toString()
 房间编号                酒店            入住日期              退房日期              目的地        房间配置        日租金
  INT                                                                                                      INT


--void setOrder(String orderno, Integer h_id, String checkindate, String checkoutdate)
INPUT:
订单号
房间编号
入住日期
退房日期


--String getOrder(String orderno)
INPUT:
订单号

OUTPUT:
orderno + " " + company + " " + checkindate + " " + checkoutdate + " " + city + " " + type + " " + price.toString()
 订单号           酒店             入住日期              退房日期             目的地        房间配置        日租金



---SightCompany---

--ArrayList<String> getSight(String city, Boolean needGuide, Boolean isAll)
INPUT:
目的地
是否需要推荐导游
是否需要导游全程陪同

OUTPUT:
v_name + " " + city + " " + v_county + " " + v_price (+ " " + g_name + " " + company + " " + price.toString())
 景点          目的地         区，如海淀          景点票价           导游          景点管理公司        导游费     


--void setOrder(String orderno, ArrayList<String> v_name, ArrayList<String> g_name)
INPUT:
订单号
景点列表
导游列表，需要与景点列表大小一致，如果对应景点没有预约导游设置为null


--String getOrder(String orderno)
INPUT:
订单号

OUTPUT:
orderno + " " + content
                景点和导游预约情况
                如，长城-小红#颐和园#

