package CaseStudy.Dashmote.Repository;

import CaseStudy.Dashmote.Model.tripadvisor_Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tripadvisorReview_Repository extends JpaRepository<tripadvisor_Review, Long> {
}
