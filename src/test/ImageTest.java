package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {
    @Test
    void test() {
        //把一张图片从硬盘读到内存
        try {
//            BufferedImage image = ImageIO.read(new File(""));
            BufferedImage images = ImageIO.read(
                    //this.getClass()
                    ImageTest.class.getClassLoader().getResourceAsStream("images/1.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
