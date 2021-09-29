package CaseStudy.Dashmote.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class tripadvisor_Review {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "user")
    private tripadvisor_User user;
    @ManyToOne
    @JoinColumn(name = "id_outlet")
    private tripadvisor_Outlet id_outlet;
    private int rating;
    @Column(length = 300)
    private String body;

    public tripadvisor_Review(tripadvisor_User user, tripadvisor_Outlet id_outlet, int rating, String body) {
        this.user = user;
        this.id_outlet = id_outlet;
        this.rating = rating;
        this.body = body;
    }
}
