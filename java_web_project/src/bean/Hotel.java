package bean;

public class Hotel {
    String original;
    String orderno;
    String h_id;
    String company;
    String checkindate;
    String checkoutdate;
    String city;
    String type;
    int price;

    public void parse(String original){
        this.original = original;
        String[] res = original.split(" ");
        h_id=res[0];
        company=res[1];
        checkindate=res[2];
        checkoutdate=res[3];
        city=res[4];
        type=res[5];
        price=Integer.parseInt(res[6]);
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

    public String getH_id() {
        return h_id;
    }

    public String getCompany() {
        return company;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
