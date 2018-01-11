package bean;


public class Company {
    private String companyId;
    private String pwd;
    private String name;
    private String description;
    private String wsdl;
    private String updateAt;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", wsdl='" + wsdl + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", type=" + type +
                '}';
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
