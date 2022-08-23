package com.zwc.tank.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {
    @Test
    void test(){
        //把一张图片从硬盘读到内存
        try {
            BufferedImage image = ImageIO.read(new File(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
