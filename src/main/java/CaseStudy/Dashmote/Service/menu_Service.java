package CaseStudy.Dashmote.Service;

import CaseStudy.Dashmote.Model.DTO.uberMenu_DTO;
import CaseStudy.Dashmote.Model.ubereats_Menu;
import CaseStudy.Dashmote.Model.ubereats_Outlet;
import CaseStudy.Dashmote.Repository.ubereatsMenu_Repository;
import CaseStudy.Dashmote.Repository.ubereatsOutlet_Repository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Log
@Service
public class menu_Service {
    @Autowired
    ubereatsMenu_Repository ubereatsMenu_repository;
    @Autowired
    ubereatsOutlet_Repository ubereatsOutlet_repository;

    public void saveMenu(List<uberMenu_DTO> menu){
        for (uberMenu_DTO dto: menu
             ) {
            ubereats_Menu uberMenu = new ubereats_Menu(getbyOutletId(dto.getId_outlet()),dto.getName(),dto.getBrand(),dto.getPrice(),dto.getVolume());
            addMenu(uberMenu);
        }
    }
    public List<ubereats_Outlet> saveOutlet(List<ubereats_Outlet> outlet){
        return ubereatsOutlet_repository.saveAll(outlet);
    }
    public ubereats_Outlet getbyOutletId(String id){
        return ubereatsOutlet_repository.getById(id);
    }
    public ubereats_Menu addMenu(ubereats_Menu menu){
       return ubereatsMenu_repository.save(menu);
    }
    public List<ubereats_Menu> getByBrand(String brand){
        return ubereatsMenu_repository.getAllbyBrandName(brand);
    }
    public List<ubereats_Menu>priceCompare(double price){
        return ubereatsMenu_repository.getByPriceComparison(price);
    }
}
