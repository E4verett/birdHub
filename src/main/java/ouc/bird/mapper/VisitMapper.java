package ouc.bird.mapper;

import ouc.bird.pojo.Visit;

import java.sql.Date;

public interface VisitMapper {

    //更新网站访问数量
    void updateVisitCount(Date date);
}
