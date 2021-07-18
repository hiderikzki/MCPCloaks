package me.hideri.capemanager.cape;

import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cape
{
    private String name, displayName, customDisplayName;
    private String location;
    private BufferedImage image;

    public Cape(String name, String location) throws IOException
    {
        this.name = name;
        this.displayName = name.split("\\.")[0];
        this.customDisplayName = this.displayName; // Currently Unused
        this.location = location;
        this.image = ImageIO.read(new File(location));
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getCustomDisplayName()
    {
        return customDisplayName;
    }

    public void setCustomDisplayName(String customDisplayName)
    {
        this.customDisplayName = customDisplayName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }
}
