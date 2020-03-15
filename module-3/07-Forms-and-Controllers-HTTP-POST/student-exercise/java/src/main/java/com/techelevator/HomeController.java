package com.techelevator;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ReviewDao reviewDao;

    @RequestMapping ("/homePage")
    public String showAllReviews(ModelMap modelMap){
        List<Review> allReviews = reviewDao.getAllReviews();
        modelMap.put("reviews", allReviews);
        return "homePage";
    }

//    @RequestMapping(path = "/submitReview", method = RequestMethod.GET)
//    public String showReviewInput() {
//
//        return "submitReview";
//    }
//
//    @RequestMapping(path = "/submitReview", method = RequestMethod.POST)
//    public String processReviewInput(@RequestParam String userName, @RequestParam int rating,
//        @RequestParam String title, @RequestParam String text) {
//
//        Review review = new Review(userName, rating, title, text, LocalDateTime.now());
//        reviewDao.save(review);
//
//        return "redirect: /homePage";
//    }

    @RequestMapping(path = "/submitReview", method = RequestMethod.GET)
    public String showReviewForm(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("review")) {
            modelHolder.put("review", new Review());
        }
        return "submitReview";
    }

    @RequestMapping(path = "/submitReview", method = RequestMethod.POST)
    public String processReviewForm(@Valid @ModelAttribute Review review, BindingResult result,
                                         RedirectAttributes flash) {

        flash.addFlashAttribute("review", review);

        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "review", result);
            return "redirect:/submitReview";
        }

        review.setDateSubmitted(LocalDateTime.now());
        reviewDao.save(review);
        return "redirect:/homePage";
    }


}
