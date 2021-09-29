package CaseStudy.Dashmote;

import CaseStudy.Dashmote.Model.DTO.tripadvisorReview_DTO;
import CaseStudy.Dashmote.Model.DTO.uberMenu_DTO;
import CaseStudy.Dashmote.Model.tripadvisor_Outlet;
import CaseStudy.Dashmote.Model.tripadvisor_User;
import CaseStudy.Dashmote.Model.ubereats_Menu;
import CaseStudy.Dashmote.Model.ubereats_Outlet;
import CaseStudy.Dashmote.Service.menu_Service;

import CaseStudy.Dashmote.Service.tripadvisor_Service;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@Transactional
@Log
public class AppRunner implements ApplicationRunner {
    @Autowired
    menu_Service menuService;
    @Autowired
    tripadvisor_Service tripadvisor_service;
    @Override
    public void run(ApplicationArguments args) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            //adding uber eats outlets file to db
        log.info("Uber Eats:");
            TypeReference<List<ubereats_Outlet>> typeReference = new TypeReference<List<ubereats_Outlet>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/ubereats_outlet.json");
            List<ubereats_Outlet> outlets = mapper.readValue(inputStream,typeReference);
            menuService.saveOutlet(outlets);
            log.info("saved");
            //adding uber eats menu to db
            TypeReference<List<uberMenu_DTO>> typeReference1 = new TypeReference<List<uberMenu_DTO>>(){};
            InputStream inputStream1 = TypeReference.class.getResourceAsStream("/json/ubereats_menu.json");
            List<uberMenu_DTO> menus = mapper.readValue(inputStream1,typeReference1);
            menuService.saveMenu(menus);
            log.info("menu saved");
            //adding trip advisor users to db
        log.info("Trip Advisor:");
            mapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);//for adding of non-numeric numbers  e.g NaN
            TypeReference<List<tripadvisor_User>> typeReference2 = new TypeReference<List<tripadvisor_User>>() {};
            InputStream inputStream2 = TypeReference.class.getResourceAsStream("/json/tripadvisor_user.json");
            List<tripadvisor_User> users = mapper.readValue(inputStream2,typeReference2);
            tripadvisor_service.addUsers(users);
            log.info("users added");
            //adding trip advisor Outlets to db
            TypeReference<List<tripadvisor_Outlet>> typeReference3 = new TypeReference<List<tripadvisor_Outlet>>() {};
            InputStream inputStream3 = TypeReference.class.getResourceAsStream("/json/tripadvisor_outlet.json");
            List<tripadvisor_Outlet> tripOutlets = mapper.readValue(inputStream3,typeReference3);
            tripadvisor_service.addOutlets(tripOutlets);
            log.info("trip outlets added");
            //adding trip advisor Reviews
            TypeReference<List<tripadvisorReview_DTO>> typeReference4 = new TypeReference<List<tripadvisorReview_DTO>>() {};
            InputStream inputStream4 = TypeReference.class.getResourceAsStream("/json/tripadvisor_reviews.json");
            List<tripadvisorReview_DTO> reviewDtoList = mapper.readValue(inputStream4,typeReference4);
            tripadvisor_service.addReviews(reviewDtoList);
            log.info("reviews added");
        }
        }
