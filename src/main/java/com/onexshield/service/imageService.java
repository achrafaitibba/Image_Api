package com.onexshield.service;

import com.onexshield.model.image;
import com.onexshield.repository.IImageRepository;
import com.onexshield.util.imageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class imageService {

    private final IImageRepository imageRepository;


    public String uploadImage(MultipartFile file)throws Exception{
        image image_ = imageRepository.save(
                image.builder()
                        .imageName(file.getOriginalFilename())
                        .type(file.getContentType())
                        .image(imageUtils.compressImage(file.getBytes()))
                        .build());
        if(image_ != null){
            return "File uploaded successfully "+file.getOriginalFilename();
        }else {
            return null;
        }
    }

    public byte[] downlaodImage(String imageName){
        Optional<image> image = imageRepository.findByImageName(imageName);

        byte[] imageFile = imageUtils.decompressImage(image.get().getImage());
        return imageFile;
    }

}
