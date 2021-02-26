package com.zeros.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    private BufferedImage spritesheet;

    public Spritesheet(String path) throws IOException {
        spritesheet = ImageIO.read(getClass().getResource(path));
    }

    public BufferedImage getSpritsheet(int x, int y, int width, int height){
        return spritesheet.getSubimage(x, y, width, height);
    }

}
