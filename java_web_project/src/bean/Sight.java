package bean;

public class Sight {
    private String original;
    private String orderno;
    private String v_name;
    private String city;
    private String v_county;
    private int v_price;
    private String g_name;
    private String company;
    private int price;

    public void parse(String original){
        this.original = original;
        String[] res = original.split(" ");
        v_name=res[0];
        city=res[1];
        v_county=res[2];
        v_price=Integer.parseInt(res[3]);
        if(res.length>4){
            g_name=res[4];
            company=res[5];
            price=Integer.parseInt(res[6]);
        }
        else{
            g_name="-";
            company="-";
            price=0;
        }
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOriginal() {
        return original;
    }

    public String getOrderno() {
        return orderno;
    }

    public String getV_name() {
        return v_name;
    }

    public String getCity() {
        return city;
    }

    public String getV_county() {
        return v_county;
    }

    public int getV_price() {
        return v_price;
    }

    public String getG_name() {
        return g_name;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }
}
