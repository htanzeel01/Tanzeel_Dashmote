package CaseStudy.Dashmote.Controller;

import CaseStudy.Dashmote.Model.tripadvisor_Outlet;
import CaseStudy.Dashmote.Service.tripadvisor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping(value = "tripadvisor")
public class tripadvisor_Controller {
    @Autowired
    tripadvisor_Service tripService;
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<tripadvisor_Outlet> addOutlet(@RequestBody tripadvisor_Outlet outlet){
        tripadvisor_Outlet savOutlet = tripService.addOutlet(outlet);
        return new ResponseEntity<tripadvisor_Outlet>(savOutlet, HttpStatus.ACCEPTED);
    }
    @RequestMapping( method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<tripadvisor_Outlet> getbyid_Outlet(@RequestParam String source){
        return new ResponseEntity<tripadvisor_Outlet>(tripService.getOutlet(source),HttpStatus.OK);
    }
    @RequestMapping(value = "/source",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<tripadvisor_Outlet>> getOutletList(){
        return new ResponseEntity<List<tripadvisor_Outlet>>(tripService.outletList(),HttpStatus.OK);
    }
}
