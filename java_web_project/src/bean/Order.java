package bean;

import java.util.ArrayList;
import java.util.Base64;
import java.util.zip.CheckedOutputStream;
import java.util.Iterator;

import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class Order {

    private String orderId;
    private String userId;
    private String orderAt;
    private String airlineId;
    private String hotelId;
    private String carId;
    private String sightId;
    private String airlineStatus;
    private String hotelStatus;
    private String carStatus;
    private String sightStatus;

    private String orderno;
    private String flightno;
    private String c_id;
    private String h_id;
    private String checkindate;
    private String checkoutdate;
    private String v_name="";
    private String g_name="";

    public void parseAirline(String original){
        String[] res = original.split("#");
        airlineId=res[0];
        orderno=res[1];
        flightno=res[2];
    }

    public void parseCar(String original){
        String[] res = original.split("#");
        carId=res[0];
        orderno=res[1];
        c_id=res[2];
    }

    public void parseHotel(String original){
        String[] res = original.split("#");
        hotelId=res[0];
        orderno=res[1];
        h_id=res[2];
        checkindate=res[3];
        checkoutdate=res[4];
    }

    public void parseSight(String[] original){
        if(original.length>0){
            String[] res = original[0].split("#");
            sightId=res[0];
            orderno=res[1];
            v_name+=res[2];
            if(res[3].equals("-")){
                g_name+="null";
            }
            else{
                g_name+=res[3];
            }
            if(original.length>1){
                for(int t=1;t<original.length;t++){
                    res = original[t].split("#");
                    v_name=v_name+"#"+res[2];
                    if(res[3].equals("-")){
                        g_name=g_name+"#"+"null";
                    }
                    else{
                        g_name=g_name+"#"+res[3];
                    }
                }
            }
        }
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(String orderAt) {
        this.orderAt = orderAt;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getSightId() {
        return sightId;
    }

    public void setSightId(String sightId) {
        this.sightId = sightId;
    }

    public String getAirlineStatus() {
        return airlineStatus;
    }

    public void setAirlineStatus(String airlineStatus) {
        this.airlineStatus = airlineStatus;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getSightStatus() {
        return sightStatus;
    }

    public void setSightStatus(String sightStatus) {
        this.sightStatus = sightStatus;
    }


    public void submitOrder(String bpelCode){
        OMElement result = null;
        try {
            String url = "http://116.196.88.102:8080/ode/processes/bpel"+bpelCode+"?wsdl"; //BPEL or WSDL address
            Options options = new Options();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);

            OMFactory fac = OMAbstractFactory.getOMFactory();
            String tns = "http://Trip"; //the same as the BPEL or WSDL namespace

            OMNamespace omNs = fac.createOMNamespace(tns, "");

            OMElement method = fac.createOMElement("bpel"+bpelCode+"Request", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("orderno", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, orderno)); //define the parameter value
            method.addChild(symbol1);

            OMElement symbol2 = fac.createOMElement("flightno", omNs); //define the parameter name
            symbol2.addChild(fac.createOMText(symbol2, flightno)); //define the parameter value
            method.addChild(symbol2);

            OMElement symbol3 = fac.createOMElement("c_id", omNs); //define the parameter name
            symbol3.addChild(fac.createOMText(symbol3, c_id)); //define the parameter value
            method.addChild(symbol3);

            OMElement symbol4 = fac.createOMElement("h_id", omNs); //define the parameter name
            symbol4.addChild(fac.createOMText(symbol4, h_id)); //define the parameter value
            method.addChild(symbol4);

            OMElement symbol5 = fac.createOMElement("checkindate", omNs); //define the parameter name
            symbol5.addChild(fac.createOMText(symbol5, checkindate)); //define the parameter value
            method.addChild(symbol5);

            OMElement symbol6 = fac.createOMElement("checkoutdate", omNs); //define the parameter name
            symbol6.addChild(fac.createOMText(symbol6, checkoutdate)); //define the parameter value
            method.addChild(symbol6);

            Base64.Encoder encoder = Base64.getEncoder();
            String encoded_v_name=encoder.encodeToString(v_name.getBytes("UTF-8"));
            String encoded_g_name=encoder.encodeToString(g_name.getBytes("UTF-8"));

            OMElement symbol7 = fac.createOMElement("v_name", omNs); //define the parameter name
            symbol7.addChild(fac.createOMText(symbol7, encoded_v_name)); //define the parameter value
            method.addChild(symbol7);

            OMElement symbol8 = fac.createOMElement("g_name", omNs); //define the parameter name
            symbol8.addChild(fac.createOMText(symbol8, encoded_g_name)); //define the parameter value
            method.addChild(symbol8);

            method.build();
            //System.out.println(method);
            result = sender.sendReceive(method);

            //Get the result by loop
            Iterator iterator =  result.getChildElements();
            int i=0;
            while (iterator.hasNext()) {
                OMElement omNode = (OMElement) iterator.next();
                System.out.println(omNode.getLocalName() + ": " + omNode.getText());
                if(i==0){
                    airlineStatus= omNode.getText();
                }
                else if(i==1){
                    carStatus=omNode.getText();
                }
                else if(i==2){
                    hotelStatus=omNode.getText();
                }
                else{
                    sightStatus= omNode.getText();
                }
                i++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
