package me.hideri.capemanager.cape;

import me.hideri.capemanager.CapeManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class RenderCape
{
    public static void renderCurrentCape(AbstractClientPlayer player, RenderPlayer playerRenderer)
    {
        if(player == Minecraft.getMinecraft().thePlayer)
        {
            if(CapeManager.currentCape != null)
            {
                YourMainClass.cape.bindTexture(CapeManager.getCurrentCape().getImage());
            }
            else if(player.getLocationCape() != null)
            {
                playerRenderer.bindTexture(player.getLocationCape());
            }
        }
        else
        {
            if(player.getLocationCape() != null)
            {
                playerRenderer.bindTexture(player.getLocationCape());
            }
        }
    }
}
