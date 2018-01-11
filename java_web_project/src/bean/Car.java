package bean;

public class Car {
    private String original;
    private String orderno;
    private String c_id;
    private String company;
    private String city;
    private String type;
    private String drivemode;
    private int price;

    public void parse(String original){
        this.original = original;
        String[] res = original.split(" ");
        c_id=res[0];
        company=res[1];
        city=res[2];
        type=res[3];
        drivemode=res[4];
        price=Integer.parseInt(res[5]);
    }

    public String getC_id() {
        return c_id;
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

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getDrivemode() {
        return drivemode;
    }

    public int getPrice() {
        return price;
    }
}
