package me.hideri.capemanager;

import me.hideri.capemanager.cape.Cape;
import me.hideri.capemanager.util.Logging;

import java.util.ArrayList;
import java.util.List;

public class CapeManager
{
    private static List<Cape> loadedCapes = new ArrayList<>();
    public static Cape currentCape;

    public static void addCape(Cape cape)
    {
        loadedCapes.add(cape);
    }

    public static void setCurrentCape(String name)
    {
        for(Cape cape : loadedCapes)
        {
            if(cape.getDisplayName().equals(name))
            {
                currentCape = cape;
                return;
            }
        }

        Logging.addLog("Could not find specified cape!");
    }

    public static Cape getCurrentCape()
    {
        return currentCape;
    }

    public static List<Cape> getLoadedCapes()
    {
        return loadedCapes;
    }

    public static void setLoadedCapes(List<Cape> capes)
    {
        loadedCapes = capes;
    }
}
