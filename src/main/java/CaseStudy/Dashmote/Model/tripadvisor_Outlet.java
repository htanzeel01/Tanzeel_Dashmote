package CaseStudy.Dashmote.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//ignore all other properties no required
@JsonIgnoreProperties({"city","cuisines","features","lat","lon","menu","opening_hours","postal_code","price_level","price_range","rating","region","special_diets","street","tags","url","website"})
public class tripadvisor_Outlet {
    @Id
    @GeneratedValue
    private long id;

    private String id_outlet;
    private String name;
    private String address;
    private String country;
    private double reviews_nr;
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "id_outlet")
    private Set<tripadvisor_Review> reviewSet;
}
