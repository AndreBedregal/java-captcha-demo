package com.github.javacaptchademo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaptchaResult {

    private String captchaId;
    private String captchaEncodedImage;

}
