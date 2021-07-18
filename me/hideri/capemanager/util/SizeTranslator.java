package me.hideri.capemanager.util;

import java.awt.image.BufferedImage;

public class SizeTranslator
{
    public static String getTrueSize(BufferedImage image)
    {
        int trueWidth = image.getWidth() / 4;
        int trueHeight = image.getHeight() / 2;
        return trueWidth + "x" + trueHeight;
    }
}
