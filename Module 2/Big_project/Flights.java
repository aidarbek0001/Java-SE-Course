import java.io.Serializable;

public class Flights implements Serializable {
    Long id;
    Long aircraft_id;
    Long departure_city_id;
    Long arrival_city_id;
    String departure_time;
    Long econom_place_price;
    Long business_place_price;

    public Flights(){}

    public Flights(Long id, Long aircraft_id, Long departure_city_id, Long arrival_city_id, String departure_time, Long econom_place_price, Long business_place_price) {
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.econom_place_price = econom_place_price;
        this.business_place_price = business_place_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Long aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public Long getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(Long departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public Long getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(Long arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public Long getEconom_place_price() {
        return econom_place_price;
    }

    public void setEconom_place_price(Long econom_place_price) {
        this.econom_place_price = econom_place_price;
    }

    public Long getBusiness_place_price() {
        return business_place_price;
    }

    public void setBusiness_place_price(Long business_place_price) {
        this.business_place_price = business_place_price;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", aircraft_id=" + aircraft_id +
                ", departure_city_id=" + departure_city_id +
                ", arrival_city_id=" + arrival_city_id +
                ", departure_time='" + departure_time + '\'' +
                ", econom_place_price=" + econom_place_price +
                ", business_place_price=" + business_place_price +
                '}';
    }
}
