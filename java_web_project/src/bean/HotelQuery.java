package bean;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import java.util.ArrayList;
import java.util.Iterator;

public class HotelQuery {
    private String orderno="-";
    private String h_id;
    private String checkindate;
    private String checkoutdate;
    private String roomtype;
    private String city;
    private ArrayList<Hotel> queryResult=null;

    public void initialQueryResult(){
        queryResult = new ArrayList<Hotel>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
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

    public ArrayList<Hotel> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(ArrayList<Hotel> queryResult) {
        this.queryResult = queryResult;
    }

    public void executeQuery(String wsdlUrl){
        OMElement result = null;
        try {
            String url = wsdlUrl; //BPEL or WSDL address
            Options options = new Options();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);

            OMFactory fac = OMAbstractFactory.getOMFactory();
            String tns = "http://Trip"; //the same as the BPEL or WSDL namespace

            OMNamespace omNs = fac.createOMNamespace(tns, "");

            OMElement method = fac.createOMElement("getHotelRoom", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("checkindate", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, checkindate)); //define the parameter value
            method.addChild(symbol1);

            OMElement symbol2 = fac.createOMElement("checkoutdate", omNs); //define the parameter name
            symbol2.addChild(fac.createOMText(symbol2, checkoutdate)); //define the parameter value
            method.addChild(symbol2);

            OMElement symbol3 = fac.createOMElement("city", omNs); //define the parameter name
            symbol3.addChild(fac.createOMText(symbol3, city)); //define the parameter value
            method.addChild(symbol3);

            OMElement symbol4 = fac.createOMElement("type", omNs); //define the parameter name
            symbol4.addChild(fac.createOMText(symbol4, roomtype)); //define the parameter value
            method.addChild(symbol4);

            method.build();
            System.out.println(method);
            result = sender.sendReceive(method);

            //Get the result by loop
            Iterator iterator =  result.getChildElements();
            while (iterator.hasNext()) {
                OMElement omNode = (OMElement) iterator.next();
                System.out.println(omNode.getLocalName() + ": " + omNode.getText());
                if(omNode.getText()==null || omNode.getText().equals("")){
                    break;
                }
                Hotel h= new Hotel();
                h.parse(omNode.getText());
                queryResult.add(h);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executeOrderQuery(String wsdlUrl, String orderno){
        OMElement result = null;
        try {
            String url = wsdlUrl; //BPEL or WSDL address
            Options options = new Options();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);

            OMFactory fac = OMAbstractFactory.getOMFactory();
            String tns = "http://Trip"; //the same as the BPEL or WSDL namespace

            OMNamespace omNs = fac.createOMNamespace(tns, "");

            OMElement method = fac.createOMElement("getOrder", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("orderno", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, orderno)); //define the parameter value
            method.addChild(symbol1);

            method.build();
            System.out.println(method);
            result = sender.sendReceive(method);

            //Get the result by loop
            Iterator iterator =  result.getChildElements();
            while (iterator.hasNext()) {
                OMElement omNode = (OMElement) iterator.next();
                System.out.println(omNode.getLocalName() + ": " + omNode.getText());
                if(omNode.getText()==null || omNode.getText().equals("")){
                    break;
                }
                Hotel h= new Hotel();
                h.parse(omNode.getText());
                queryResult.add(h);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
