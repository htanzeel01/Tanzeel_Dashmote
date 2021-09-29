package CaseStudy.Dashmote.Model.DTO;

import CaseStudy.Dashmote.Model.ubereats_Outlet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class uberMenu_DTO {
    private long menu_id;
    private String  id_outlet;
    private String name;
    private String brand;
    private double price;
    private String volume;
}
