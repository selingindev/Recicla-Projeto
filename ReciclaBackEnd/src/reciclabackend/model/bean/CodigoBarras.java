package reciclabackend.model.bean;

public class CodigoBarras {
    String description;
    int gtdin;
    String brandName;

    public CodigoBarras(String description, int gtdin, String brandName) {
        this.description = description;
        this.gtdin = gtdin;
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGtdin() {
        return gtdin;
    }

    public void setGtdin(int gtdin) {
        this.gtdin = gtdin;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
