package CaseStudy.Dashmote.Repository;

import CaseStudy.Dashmote.Model.tripadvisor_Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface tripadvisorOutlet_Repository extends JpaRepository<tripadvisor_Outlet, Long> {
    //tripadvisor_Outlet getById_outlet(Long id);
    @Query("SELECT o from tripadvisor_Outlet o where id_outlet = ?1")
    tripadvisor_Outlet getbyid_outlet(String outlet);
}
