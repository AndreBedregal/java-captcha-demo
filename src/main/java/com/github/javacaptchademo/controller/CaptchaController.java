package com.github.javacaptchademo.controller;

import com.github.cage.Cage;
import com.github.javacaptchademo.captcha.MyCustomizedCaptchaGenerator;
import com.github.javacaptchademo.service.CaptchaService;
import com.github.javacaptchademo.dto.CaptchaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Base64;
import java.util.UUID;

@RestController
@Validated
@Slf4j
public class CaptchaController {

    private static final Cage CaptchaGenerator = new MyCustomizedCaptchaGenerator();
    private final CaptchaService captchaService;

    @Autowired
    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @GetMapping("captcha")
    protected ResponseEntity<CaptchaResult> getCaptcha() {
        // Generate a random id for the new captcha
        String captchaId = UUID.randomUUID().toString();

        // remove (if any) captcha with id = captchaId
        captchaService.deleteCaptchaById(captchaId);

        // get the new captcha
        String captcha = captchaService.getCaptchaById(captchaId);
        byte[] draw = CaptchaGenerator.draw(captcha);

        // encode the image
        String imageInBase64 = Base64.getEncoder().encodeToString(draw);

        return new ResponseEntity<>(new CaptchaResult(captchaId, imageInBase64), HttpStatus.OK);
    }

    @PostMapping(value = "protected")
    public ResponseEntity<String> doRequestCode(@RequestParam(value = "username") @NotBlank String username,
                                                @RequestParam(value = "captcha") @NotBlank String providedCaptcha,
                                                @RequestParam(value = "captchaId") @NotBlank String captchaId) {
        // Get the captcha from the cache
        String captchaInCache = captchaService.getCaptchaById(captchaId);

        // Whether the captcha is correct or not, we remove it to prevent automated tries
        captchaService.deleteCaptchaById(captchaId);

        // Validating captcha
        if (captchaInCache.equals(providedCaptcha)) {
            log.info("Captcha verified");
            // captcha is OK, continue with business logic
            return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
        } else {
            log.info("Wrong captcha");
            return new ResponseEntity<>("Wrong captcha", HttpStatus.BAD_REQUEST);
        }
    }

}
