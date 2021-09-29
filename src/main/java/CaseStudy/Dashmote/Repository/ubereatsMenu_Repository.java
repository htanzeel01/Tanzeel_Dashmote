package CaseStudy.Dashmote.Repository;

import CaseStudy.Dashmote.Model.ubereats_Menu;
import CaseStudy.Dashmote.Model.ubereats_Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ubereatsMenu_Repository extends JpaRepository<ubereats_Menu, Long> {
    @Query("SELECT u from ubereats_Menu u where brand like %?1%")
    List<ubereats_Menu> getAllbyBrandName(String brand);

    @Query("SELECT u from ubereats_Menu u where price > ?1")
    List<ubereats_Menu> getByPriceComparison(double price);
}
