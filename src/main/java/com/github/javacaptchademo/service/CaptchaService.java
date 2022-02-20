package com.github.javacaptchademo.service;

import com.github.cage.Cage;
import com.github.javacaptchademo.captcha.MyCustomizedCaptchaGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CaptchaService {

    private static final Cage cage = new MyCustomizedCaptchaGenerator();

    @Cacheable(value = "captchaToken:id", key = "#captchaId", unless = "#result == null")
    public String getCaptchaById(String captchaId) {
        log.info("Generating captcha for id " + captchaId);
        return cage.getTokenGenerator().next();
    }

    @CacheEvict(value = "captchaToken:id", key = "#captchaId")
    public void deleteCaptchaById(String captchaId) {
        log.info("Removing token with id " + captchaId);
    }

}
