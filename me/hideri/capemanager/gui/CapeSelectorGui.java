package me.hideri.capemanager.gui;

import me.hideri.capemanager.CapeManager;
import me.hideri.capemanager.util.SizeTranslator;
import me.hideri.capemanager.util.SimpleTextureBinder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;

public class CapeSelectorGui extends GuiScreen
{
    private GuiScreen parent;
    public SlotList list;

    public CapeSelectorGui(GuiScreen parent)
    {
        this.parent = parent;
    }

    @Override
    public void initGui()
    {
        super.initGui();

        try
        {
            YourMainClass.capeLoader.loadCapesFromLocation(YourMainClass.CAPE_LOC);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        buttonList.add(new GuiButton(1, width / 2 - 100, height - 27, 200, 20, "Back"));
        list = new SlotList(mc, width, height, 32, height - 32, 10);
    }

    @Override
    protected void actionPerformed(GuiButton p_actionPerformed_1_) throws IOException
    {
        list.actionPerformed(p_actionPerformed_1_);

        if (p_actionPerformed_1_.id == 1)
        {
            mc.displayGuiScreen(parent);
        }
    }

    @Override
    public void handleMouseInput() throws IOException
    {
        list.handleMouseInput();
        super.handleMouseInput();
    }

    @Override
    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_)
    {
        list.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
        super.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
    }

    @Override
    public void onGuiClosed()
    {
        YourMainClass.cape.resetTexID();
        super.onGuiClosed();
    }

    class SlotList extends GuiSlot
    {
        public SlotList(Minecraft p_i1052_1_, int p_i1052_2_, int p_i1052_3_, int p_i1052_4_, int p_i1052_5_, int p_i1052_6_)
        {
            super(p_i1052_1_, p_i1052_2_, p_i1052_3_, p_i1052_4_, p_i1052_5_, p_i1052_6_);
        }

        @Override
        protected int getSize()
        {
            return CapeManager.getLoadedCapes().size();
        }

        @Override
        protected void elementClicked(int i, boolean b, int i1, int i2)
        {
            CapeManager.setCurrentCape(CapeManager.getLoadedCapes().get(i).getDisplayName());
        }

        @Override
        protected boolean isSelected(int i)
        {
            return false;
        }

        @Override
        protected void drawBackground()
        {
            drawDefaultBackground();
        }

        @Override
        protected void drawSlot(int i, int i1, int i2, int i3, int i4, int i5)
        {
            // drawCenteredString(mc.fontRendererObj, "You do not have any capes! :(", width / 2, height / 2, -1);
            drawCenteredString(mc.fontRendererObj, CapeManager.getCurrentCape() != null ? (CapeManager.getLoadedCapes().get(i).getCustomDisplayName().equals(CapeManager.getCurrentCape().getDisplayName()) ? EnumChatFormatting.GREEN + (EnumChatFormatting.BOLD + CapeManager.getLoadedCapes().get(i).getDisplayName() + " (Size: " + SizeTranslator.getTrueSize(CapeManager.getLoadedCapes().get(i).getImage()) + ")") : EnumChatFormatting.GRAY + CapeManager.getLoadedCapes().get(i).getDisplayName() + " (Size: " + SizeTranslator.getTrueSize(CapeManager.getLoadedCapes().get(i).getImage()) + ")") : EnumChatFormatting.GRAY + CapeManager.getLoadedCapes().get(i).getDisplayName() + " (Size: " + SizeTranslator.getTrueSize(CapeManager.getLoadedCapes().get(i).getImage()) + ")", width / 2, i2 + 2, -1);
        }
    }
}
