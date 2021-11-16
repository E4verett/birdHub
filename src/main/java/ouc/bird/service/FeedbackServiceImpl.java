package ouc.bird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ouc.bird.mapper.FeedbackMapper;
import ouc.bird.pojo.Feedback;

public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    @Qualifier(value = "feedbackMapper")
    private FeedbackMapper feedbackMapper;


    public void setFeedbackMapper(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public void fbUpload(Feedback feedback) {
        feedbackMapper.fbUpload(feedback);
    }
}
