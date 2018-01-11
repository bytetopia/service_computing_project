package bean;

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
import java.util.ArrayList;
import java.util.Iterator;

public class AirlineQuery {
    private String orderno="-";
    private String flightdate;
    private String departcity;
    private String arrivecity;
    private ArrayList<Airline> queryResult=null;

    public void initialQueryResult(){
        queryResult = new ArrayList<Airline>();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getFlightdate() {
        return flightdate;
    }

    public void setFlightdate(String flightdate) {
        this.flightdate = flightdate;
    }

    public String getDepartcity() {
        return departcity;
    }

    public void setDepartcity(String departcity) {
        this.departcity = departcity;
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity;
    }

    public ArrayList<Airline> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(ArrayList<Airline> queryResult) {
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

            OMElement method = fac.createOMElement("getAirline", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("flightdate", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, flightdate)); //define the parameter value
            method.addChild(symbol1);

            OMElement symbol2 = fac.createOMElement("departcity", omNs); //define the parameter name
            symbol2.addChild(fac.createOMText(symbol2, departcity)); //define the parameter value
            method.addChild(symbol2);

            OMElement symbol3 = fac.createOMElement("arrivecity", omNs); //define the parameter name
            symbol3.addChild(fac.createOMText(symbol3, arrivecity)); //define the parameter value
            method.addChild(symbol3);

            method.build();
            System.out.println(method);
            result = sender.sendReceive(method);

            //Get the result by loop
            Iterator iterator =  result.getChildElements();
            while (iterator.hasNext()) {
                OMElement omNode = (OMElement) iterator.next();
                Airline a=new Airline();
                a.parse(omNode.getText());
                queryResult.add(a);
                System.out.println(omNode.getLocalName() + ": " + omNode.getText());
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
                Airline a=new Airline();
                String backText=omNode.getText();
                backText=backText.substring(backText.indexOf(" ")+1, backText.length());
                a.parse(backText);
                queryResult.add(a);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
