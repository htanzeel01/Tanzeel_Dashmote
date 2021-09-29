package CaseStudy.Dashmote.Controller;

import CaseStudy.Dashmote.Model.ubereats_Menu;
import CaseStudy.Dashmote.Service.menu_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping(value = "ubereats")
public class uber_Controller {
    @Autowired
    menu_Service menuService;

    @RequestMapping(value = "/brand", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ubereats_Menu>> GetbyBrand(@RequestParam String brand){
        List<ubereats_Menu> menuList = menuService.getByBrand(brand);
        return new ResponseEntity<List<ubereats_Menu>>(menuList, HttpStatus.OK);
    }
    @RequestMapping(value = "/price", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ubereats_Menu>>GetbyPriceCompare(@RequestParam Double price){
        List<ubereats_Menu> priceList = menuService.priceCompare(price);
        return new ResponseEntity<List<ubereats_Menu>>(priceList,HttpStatus.OK);
    }
}
