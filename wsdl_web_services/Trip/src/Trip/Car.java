package Trip;

public class Car {
	private Integer id;
	private String company;
	private String city;
	private String type;
	private String drivemode;
	private Integer price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDrivemode() {
		return drivemode;
	}
	public void setDrivemode(String drivemode) {
		this.drivemode = drivemode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}

