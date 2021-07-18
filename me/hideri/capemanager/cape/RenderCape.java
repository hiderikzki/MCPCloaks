package me.hideri.capemanager.cape;

import me.hideri.capemanager.CapeManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class RenderCape
{
    public static boolean renderCurrentCape(AbstractClientPlayer player, RenderPlayer playerRenderer)
    {
        if(player == Minecraft.getMinecraft().thePlayer)
        {
            if(CapeManager.currentCape != null)
            {
                YourMainClass.cape.bindTexture(CapeManager.getCurrentCape().getImage());
                return true;
            }
            else if(player.getLocationCape() != null)
            {
                playerRenderer.bindTexture(player.getLocationCape());
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(player.getLocationCape() != null)
            {
                playerRenderer.bindTexture(player.getLocationCape());
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
