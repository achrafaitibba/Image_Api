package com.onexshield.repository;

import com.onexshield.model.image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IImageRepository extends JpaRepository<image, Long> {

    Optional<image> findByImageName(String name);
}
