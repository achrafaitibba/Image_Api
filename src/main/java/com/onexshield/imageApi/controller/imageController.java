package com.onexshield.imageApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class imageController {

    private final com.onexshield.service.imageService imageService;


    @PostMapping("/add")
    public ResponseEntity<?> upload(@RequestParam("image")MultipartFile image) throws Exception{
        return ResponseEntity.ok().body(imageService.uploadImage(image));
    }


    @GetMapping("/get/{imageName}")
    public ResponseEntity<?> download(@PathVariable String imageName){
        return ResponseEntity.ok().contentType(MediaType.valueOf("image/png"))
                .body(imageService.downlaodImage(imageName));
    }
}
