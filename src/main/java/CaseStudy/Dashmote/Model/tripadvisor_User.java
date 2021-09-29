package CaseStudy.Dashmote.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class tripadvisor_User {
    @Id
    @GeneratedValue
    private long id;

    private String user;
    private String address;
    private String reviews;
    private double likes;
    @JsonIgnore
    @OneToMany (mappedBy = "user")
    private Set<tripadvisor_Review> reviewSet;
}
