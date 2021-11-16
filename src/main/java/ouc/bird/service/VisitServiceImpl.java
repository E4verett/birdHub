package ouc.bird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ouc.bird.mapper.VisitMapper;

import java.sql.Date;

public class VisitServiceImpl implements VisitService{

    @Autowired
    @Qualifier(value = "visitMapper")
    private VisitMapper visitMapper;

    public void setVisitMapper(VisitMapper visitMapper) {
        this.visitMapper = visitMapper;
    }


    @Override
    public void updateVisitCount(Date date) {
        visitMapper.updateVisitCount(date);
    }
}
