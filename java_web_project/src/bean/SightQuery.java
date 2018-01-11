package bean;

import java.util.ArrayList;
import java.util.Arrays;
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

public class SightQuery {
    private String orderno="-";
    private String v_name;
    private String g_name;
    private String needGuide;
    private String isAll;
    private String city;
    private ArrayList<Sight> queryResult=null;

    private ArrayList<String> orderResult=null;

    public void initialQueryResult(){
        queryResult = new ArrayList<Sight>();
        orderResult = new ArrayList<String>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getNeedGuide() {
        return needGuide;
    }

    public void setNeedGuide(String needGuide) {
        this.needGuide = needGuide;
    }

    public String getIsAll() {
        return isAll;
    }

    public void setIsAll(String isAll) {
        this.isAll = isAll;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
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

    public ArrayList<Sight> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(ArrayList<Sight> queryResult) {
        this.queryResult = queryResult;
    }

    public ArrayList<String> getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(ArrayList<String> orderResult) {
        this.orderResult = orderResult;
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

            OMElement method = fac.createOMElement("getSight", omNs); //which function you want to invoke

            OMElement symbol1 = fac.createOMElement("city", omNs); //define the parameter name
            symbol1.addChild(fac.createOMText(symbol1, city)); //define the parameter value
            method.addChild(symbol1);

            OMElement symbol2 = fac.createOMElement("needGuide", omNs); //define the parameter name
            symbol2.addChild(fac.createOMText(symbol2, needGuide)); //define the parameter value
            method.addChild(symbol2);

            OMElement symbol3 = fac.createOMElement("isAll", omNs); //define the parameter name
            symbol3.addChild(fac.createOMText(symbol3, isAll)); //define the parameter value
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
                Sight s = new Sight();
                s.parse(omNode.getText());
                queryResult.add(s);
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
                String toParse=omNode.getText().split(" ")[1];
                String[] parsed=toParse.split("#");
                orderResult.addAll(Arrays.asList(parsed));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
