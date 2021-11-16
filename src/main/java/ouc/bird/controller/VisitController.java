package ouc.bird.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ouc.bird.service.VisitService;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class VisitController {

    @Autowired
    @Qualifier(value = "visitServiceImpl")
    private VisitService visitService;


    @GetMapping(value = "/visit")
    public void updateVisitCount(HttpSession session){
        System.out.println("进入该方法中！");
        if(session.isNew()){
            //获取当前日期
            Date today = new Date(System.currentTimeMillis());
            visitService.updateVisitCount(today);
            System.out.println("更新访问人数");
        }
    }


}
