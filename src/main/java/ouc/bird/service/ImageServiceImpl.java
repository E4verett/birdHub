package ouc.bird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ouc.bird.mapper.ImageMapper;

import java.sql.Date;

public class ImageServiceImpl implements ImageService {

    @Autowired
    @Qualifier(value = "imageMapper")
    private ImageMapper imageMapper;

    public ImageMapper getImageMapper() {
        return imageMapper;
    }

    public void setImageMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public void imageUpload(Date date) {
        imageMapper.imageUpload(date);
    }
}
