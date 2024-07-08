import java.io.Serializable;

public class Aircrafts implements Serializable {
    Long id;
    String name;
    String model;
    Long business_class_capacity;
    Long econom_class_capacity;

    public Aircrafts(){}

    public Aircrafts(Long id, String name, String model, Long business_class_capacity, Long econom_class_capacity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.business_class_capacity = business_class_capacity;
        this.econom_class_capacity = econom_class_capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getBusiness_class_capacity() {
        return business_class_capacity;
    }

    public void setBusiness_class_capacity(Long business_class_capacity) {
        this.business_class_capacity = business_class_capacity;
    }

    public Long getEconom_class_capacity() {
        return econom_class_capacity;
    }

    public void setEconom_class_capacity(Long econom_class_capacity) {
        this.econom_class_capacity = econom_class_capacity;
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", business_class_capacity=" + business_class_capacity +
                ", econom_class_capacity=" + econom_class_capacity +
                '}';
    }
}
