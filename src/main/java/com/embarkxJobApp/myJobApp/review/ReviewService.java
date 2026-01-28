package com.embarkxJobApp.myJobApp.review;

import com.embarkxJobApp.myJobApp.company.Company;
import com.embarkxJobApp.myJobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewService(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService =  companyService;
    }

    List<Review> getAllReviews(Long companyId){
        return reviewRepository.findByCompanyId(companyId);

    }


    boolean addReview(Long companyId, Review review){
        try {
            Company company = companyService.getCompanyById(companyId);
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    Review getReview(Long companyId, Long reviewId){
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }


    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview){
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }else{
            return false;
        }
    }


    public boolean deleteReview(Long companyId, Long reviewId){
        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }



}
