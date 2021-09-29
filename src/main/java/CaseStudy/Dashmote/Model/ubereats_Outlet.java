package CaseStudy.Dashmote.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ubereats_Outlet {
    @Id
    private String  id_outlet;

    private String country;
    private String name;
    private String address;
    private int reviews_nr;

    @JsonIgnore
    @OneToMany(mappedBy = "id_outlet")
    private Set<ubereats_Menu> menu_id;
}
