package me.hideri.capemanager.loader;

import me.hideri.capemanager.CapeManager;
import me.hideri.capemanager.cape.Cape;
import me.hideri.capemanager.util.Logging;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CapeLoader
{
    /**
     * Loads all capes from set location (folder where the capes are stored)
     * Animated capes currently unsupported
     */
    public void loadCapesFromLocation(String location) throws IOException
    {
        final File resourceLocation = new File(location);

        if(resourceLocation.isFile() || !resourceLocation.isDirectory())
        {
            Logging.addLog("Invalid cape directory!");
            return;
        }

        if(!resourceLocation.exists())
        {
            Logging.addLog("Cape directory was not found!");
            return;
        }

        if(Objects.requireNonNull(resourceLocation.listFiles()).length < 1)
        {
            Logging.addLog("No capes found!");
            return;
        }

        CapeManager.getLoadedCapes().clear();

        for(File file : Objects.requireNonNull(resourceLocation.listFiles()))
        {
            CapeManager.addCape(new Cape(file.getName(), file.getAbsolutePath()));
        }
    }

    public void createCapeDirectoryIfNotExists(String location)
    {
        final File resourceLocation = new File(location);

        if(!resourceLocation.exists())
        {
            if(resourceLocation.mkdirs())
            {
                Logging.addLog("Created cape directory!");
            }
        }
    }
}
