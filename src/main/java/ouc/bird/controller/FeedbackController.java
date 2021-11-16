package ouc.bird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ouc.bird.pojo.Feedback;
import ouc.bird.service.FeedbackService;

import java.sql.Timestamp;

@RestController
public class FeedbackController {

    @Autowired
    @Qualifier(value = "feedbackServiceImpl")
    FeedbackService feedbackService;


    @PostMapping(value = "/feedback")
    public void fbUpload(@RequestBody Feedback feedback){
//        System.out.println(feedback);
//        System.out.println("------------------------------------");
//        System.out.println(new Feedback(1, new Timestamp(System.currentTimeMillis()), "cow").toString());
        feedbackService.fbUpload(feedback);
        System.out.println("反馈上传成功！");
    }

}
