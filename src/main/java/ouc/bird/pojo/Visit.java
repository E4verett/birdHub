package ouc.bird.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;


@Data
@AllArgsConstructor
public class Visit {


    private Date time;
    private int count;
}
