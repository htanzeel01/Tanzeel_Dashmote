package CaseStudy.Dashmote.Service;

import CaseStudy.Dashmote.Model.DTO.tripadvisorReview_DTO;
import CaseStudy.Dashmote.Model.tripadvisor_Outlet;
import CaseStudy.Dashmote.Model.tripadvisor_Review;
import CaseStudy.Dashmote.Model.tripadvisor_User;
import CaseStudy.Dashmote.Repository.tripadvisorOutlet_Repository;
import CaseStudy.Dashmote.Repository.tripadvisorReview_Repository;
import CaseStudy.Dashmote.Repository.tripadvisorUser_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tripadvisor_Service {
    @Autowired
    tripadvisorUser_Repository user_repository;
    @Autowired
    tripadvisorReview_Repository review_repository;
    @Autowired
    tripadvisorOutlet_Repository outlet_repository;

    public List<tripadvisor_User> addUsers(List<tripadvisor_User> users){
        return user_repository.saveAll(users);
    }
    public List<tripadvisor_Outlet> addOutlets(List<tripadvisor_Outlet> outlets){
        return outlet_repository.saveAll(outlets);
    }
    public void addReviews(List<tripadvisorReview_DTO> dtoList){
        for (tripadvisorReview_DTO dto:dtoList
             ) {
            tripadvisor_Review review = new tripadvisor_Review(getUser(dto.getUser()),getOutlet(dto.getId_outlet()),dto.getRating(),dto.getBody());
            review_repository.save(review);
        }
    }
    public tripadvisor_User getUser(String username){
        return user_repository.getByUser(username);
    }
    public tripadvisor_Outlet getOutlet(String outlet){
        return outlet_repository.getbyid_outlet(outlet);
    }
    public tripadvisor_Outlet addOutlet(tripadvisor_Outlet outlet){
        return outlet_repository.save(outlet);
    }
    public List<tripadvisor_Outlet> outletList(){
        return outlet_repository.findAll();
    }
}
