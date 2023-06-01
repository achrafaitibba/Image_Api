package com.onexshield.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class image {
    @Id
    @GeneratedValue
    private Long imageId;
    private String imageName;
    private String type;
    @Lob
    @Column(length = 1000)
    private byte[] image;

}
