import java.io.Serializable;
import java.util.ArrayList;

public class CitiesPD implements Serializable {
    String operation_type;
    ArrayList<Cities> cities;
    Cities city;

    public CitiesPD(){}

    public CitiesPD(String operation_type, ArrayList<Cities> cities, Cities city) {
        this.operation_type = operation_type;
        this.cities = cities == null ? null : (ArrayList<Cities>) cities.clone();
        this.city = city;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public ArrayList<Cities> getCities() {
        if (cities == null){
            return new ArrayList<>();
        }
        return (ArrayList<Cities>) cities.clone();
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = (ArrayList<Cities>) cities.clone();
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CitiesPD{" +
                "operation_type='" + operation_type + '\'' +
                ", cities=" + cities +
                ", city=" + city +
                '}';
    }
}
