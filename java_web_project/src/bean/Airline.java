package bean;

public class Airline {
    private String original;
    private String orderno;
    private String flightno;
    private String company;
    private String flightdate;
    private String departtime;
    private String arrivetime;
    private String departcity;
    private String arrivecity;
    private int price;

    public void parse(String original){
        this.original = original;
        String[] res = original.split(" ");
        flightno=res[0];
        company=res[1];
        flightdate=res[2];
        departtime=res[3];
        arrivetime=res[4];
        departcity=res[5];
        arrivecity=res[6];
        price=Integer.parseInt(res[7]);
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOriginal() {
        return original;
    }

    public String getFlightno() {
        return flightno;
    }

    public String getCompany() {
        return company;
    }

    public String getFlightdate() {
        return flightdate;
    }

    public String getDeparttime() {
        return departtime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public String getDepartcity() {
        return departcity;
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public int getPrice() {
        return price;
    }
}
