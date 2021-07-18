package me.hideri.capemanager.util;

import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

public class SimpleTextureBinder
{
    private int LTXID;
    private int TXID;
    private ByteBuffer currentBuffer;

    public SimpleTextureBinder()
    {
        LTXID = Integer.MAX_VALUE;
        TXID = Integer.MAX_VALUE - 1;
        currentBuffer = null;
    }

    public void bindTexture(BufferedImage image)
    {
        if(TXID != 0 && TXID != LTXID)
        {
            final int pixelSize = image.getWidth() * image.getHeight();
            int[] pixels = new int[pixelSize];
            image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

            ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4); // 4 for RGBA, 3 for RGB

            for(int y = 0; y < image.getHeight(); y++)
            {
                for(int x = 0; x < image.getWidth(); x++)
                {
                    int pixel = pixels[y * image.getWidth() + x];
                    buffer.put((byte) ((pixel >> 16) & 0xFF)); // Red component
                    buffer.put((byte) ((pixel >> 8) & 0xFF));  // Green component
                    buffer.put((byte) (pixel & 0xFF));         // Blue component
                    buffer.put((byte) ((pixel >> 24) & 0xFF)); // Alpha component. Only for RGBA
                }
            }

            buffer.flip();

            currentBuffer = buffer;
            TXID = GL11.glGenTextures();
        }

        GlStateManager.bindTexture(TXID);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, currentBuffer);
        LTXID = TXID;
    }

    public void resetTexID()
    {
        LTXID = Integer.MAX_VALUE;
        TXID = Integer.MAX_VALUE - 1;
        currentBuffer = null;
    }
}
