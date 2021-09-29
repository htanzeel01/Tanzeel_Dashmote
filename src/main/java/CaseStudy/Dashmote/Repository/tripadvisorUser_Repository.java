package CaseStudy.Dashmote.Repository;

import CaseStudy.Dashmote.Model.tripadvisor_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tripadvisorUser_Repository extends JpaRepository<tripadvisor_User,Long> {
    tripadvisor_User getByUser(String username);
}
