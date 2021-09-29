package CaseStudy.Dashmote.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ubereats_Menu {
    @Id
    @GeneratedValue
    private long menu_id;

    @ManyToOne
    @JoinColumn(name = "id_outlet",nullable = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    private ubereats_Outlet  id_outlet;



    private String name;
    private String brand;
    private double price;
    private String volume;

    public ubereats_Menu(ubereats_Outlet id_outlet, String name, String brand, double price, String volume) {
        this.id_outlet = id_outlet;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.volume = volume;
    }
}
