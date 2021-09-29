package CaseStudy.Dashmote.Model.DTO;

import CaseStudy.Dashmote.Model.tripadvisor_Outlet;
import CaseStudy.Dashmote.Model.tripadvisor_User;
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
@JsonIgnoreProperties({"date","traveler_type","url"})
public class tripadvisorReview_DTO {
    private String user;
    private String id_outlet;
    private int rating;
    private String body;
}
