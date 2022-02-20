package com.github.javacaptchademo.captcha;

import com.github.cage.Cage;
import com.github.cage.IGenerator;
import com.github.cage.IGeneratorFactory;
import com.github.cage.ObjectRoulette;
import com.github.cage.image.Painter;
import com.github.cage.token.RandomCharacterGeneratorFactory;
import com.github.cage.token.RandomTokenGenerator;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

import static com.github.cage.token.RandomCharacterGeneratorFactory.*;
import static com.github.cage.token.RandomCharacterGeneratorFactory.DEFAULT_SPECIAL_CHARACTER_SETS;

public class MyCustomizedCaptchaGenerator extends Cage {

    private static final Random rnd = new Random();
    private static final Painter painter = new Painter(rnd);
    private static final int DEFAULT_FONT_HEIGHT = painter.getHeight() / 2;
    private static final int MIN_LENGTH = 5;
    private static final int DELTA = 0;
    private static final IGenerator<Font> FONTS = new ObjectRoulette<>(rnd,
            MyCustomizedCaptchaGenerator.getMonospacedFont()
    );
    private static final IGenerator<Color> FOREGROUND_COLORS = new ObjectRoulette<>(rnd,
            new Color(0, 0, 0),
            new Color(0, 0, 255),
            new Color(0, 0, 128),
            new Color(25, 25, 112),
            new Color(0, 0, 139),
            new Color(0, 0, 205),
            new Color(75, 0, 130),
            new Color(72, 61, 139),
            new Color(138, 43, 226),
            new Color(30, 144, 255),
            new Color(65, 105, 225),
            new Color(128, 0, 128)
    );
    public static final char[] DEFAULT_DEFAULT_CHARACTER_SET
            = (new String(ENGLISH_VOWELS) + new String(ENGLISH_CONSONANTS) + new String(ARABIC_NUMERALS)).toCharArray();
    private static final IGeneratorFactory<Character> RANDOM_CHARACTER_GENERATOR_FACTORY
            = new RandomCharacterGeneratorFactory(DEFAULT_DEFAULT_CHARACTER_SET, DEFAULT_SPECIAL_CHARACTER_SETS, rnd);
    private static final IGenerator<String> RANDOM_TOKEN_GENERATOR
            = new RandomTokenGenerator(rnd, RANDOM_CHARACTER_GENERATOR_FACTORY, MIN_LENGTH, DELTA);

    public MyCustomizedCaptchaGenerator() {
        super(painter, FONTS, FOREGROUND_COLORS, "jpeg", 0.5F, RANDOM_TOKEN_GENERATOR, rnd);
    }

    private static Font getMonospacedFont() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(
                    Font.TRUETYPE_FONT,
                    Objects.requireNonNull(new ClassPathResource("fonts/RobotoSerif-Regular.ttf").getInputStream())));
            return new Font("RobotoSerif", Font.PLAIN, DEFAULT_FONT_HEIGHT);
        } catch (Exception e) {
            return new Font("SansSerif", Font.PLAIN, DEFAULT_FONT_HEIGHT);
        }
    }

}
