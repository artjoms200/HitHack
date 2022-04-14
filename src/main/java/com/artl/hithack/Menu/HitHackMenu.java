package com.artl.hithack.Menu;

import com.artl.hithack.Menu.Tools.changeUser;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HitHackMenu extends GuiScreen {
    private static final ResourceLocation texture = new ResourceLocation("texture.jpg");

    public HitHackMenu() {
        super();
    }

    @Override
    public void initGui() {
        int i = this.height / 4 + 48;
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, i + 72 + 12, 98,
                20, "Options"));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 2, i + 72 + 12, 98,
                20, "Quit"));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, i + 72 - 12, 98,
                20, "Change User"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, i + 72 - 12, 98,
                20, "Author"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, i + 72 - 35, 200,
                20, "Multiplayer"));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, i + 72 - 58, 200,
                20, "Singleplayer"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        } if (button.id == 1) {
            mc.shutdown();
        } if (button.id == 2) {
            mc.displayGuiScreen(new changeUser());
        } if (button.id == 3) {
            try {
                Desktop desktop = Desktop.getDesktop();
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("https://vk.vom/artlmrx"));
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } if (button.id == 4) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        } if (button.id == 5) {
            mc.displayGuiScreen(new GuiWorldSelection(this));
        }
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.color(1, 1, 1, 1);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(texture);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, this.width, this.height, this.width, this.height, this.width, this.height);

        drawLogo.drawString(5, "HitHackClient", this.width / 10 - this.fontRenderer.getStringWidth("HitHackClient") / 2,
                this.height / 20, new Color(0x00D9FF).hashCode());

        for (GuiButton guiButton : this.buttonList) {
            guiButton.drawButton(this.mc, mouseX, mouseY, partialTicks);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
