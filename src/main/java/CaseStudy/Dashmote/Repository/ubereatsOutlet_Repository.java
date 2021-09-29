package CaseStudy.Dashmote.Repository;

import CaseStudy.Dashmote.Model.ubereats_Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ubereatsOutlet_Repository extends JpaRepository<ubereats_Outlet,String> {
    //ubereats_Outlet findById_outlet(String id);
}
