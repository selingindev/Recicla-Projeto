package reciclabackend.model.bean;

public class CodigoBarras {
    int id;
    String description;
    String gtdin;
    String brandName;

    public CodigoBarras(int id, String description, String gtdin, String brandName) {
        this.id = id;
        this.description = description;
        this.gtdin = gtdin;
        this.brandName = brandName;
    }

    public CodigoBarras(String description, String gtdin, String brandName) {

        this.description = description;
        this.gtdin = gtdin;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGtdin() {
        return gtdin;
    }

    public void setGtdin(String gtdin) {
        this.gtdin = gtdin;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
