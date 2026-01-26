package com.embarkxJobApp.myJobApp.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    List<Review> getAllReviews(Long companyId){
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return null;
    }
}
