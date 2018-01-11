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

public class CarQuery {
    private String orderno="-";
    private String city;
    private String type;
    private String drivemode;
    private String c_id;
    private ArrayList<Car> queryResult = null;

    public void initialQueryResult(){
        queryResult=new ArrayList<Car>();
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDrivemode() {
        return drivemode;
    }

    public void setDrivemode(String drivemode) {
        this.drivemode = drivemode;
    }

    public ArrayList<Car> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(ArrayList<Car> queryResult) {
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

            OMElement method = fac.createOMElement("getCar", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("city", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, city)); //define the parameter value
            method.addChild(symbol1);

            OMElement symbol2 = fac.createOMElement("type", omNs); //define the parameter name
            symbol2.addChild(fac.createOMText(symbol2, type)); //define the parameter value
            method.addChild(symbol2);

            OMElement symbol3 = fac.createOMElement("drivemode", omNs); //define the parameter name
            symbol3.addChild(fac.createOMText(symbol3, drivemode)); //define the parameter value
            method.addChild(symbol3);

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
                Car c=new Car();
                c.parse(omNode.getText());
                queryResult.add(c);
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
                Car c=new Car();
                c.parse(omNode.getText());
                queryResult.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
