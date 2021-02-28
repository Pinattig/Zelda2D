package com.zeros.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerSprites {

    private static BufferedImage spritesheet;

    static {
        try {
            spritesheet = ImageIO.read(PlayerSprites.class.getResource("/spritesheet-player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage standingInFront = spritesheet.getSubimage(0,0,16,20);
    public static BufferedImage walkLeftToFront = spritesheet.getSubimage(16,0,16,20);
    public static BufferedImage walkRightToFront = spritesheet.getSubimage(32,0,16,20);
    public static BufferedImage standingInLeft = spritesheet.getSubimage(48,0,16,20);
    public static BufferedImage walkLeftToLeft =  spritesheet.getSubimage(80,0,16,20);
    public static BufferedImage walkRightToLeft =spritesheet.getSubimage(64,0,16,20);

}
