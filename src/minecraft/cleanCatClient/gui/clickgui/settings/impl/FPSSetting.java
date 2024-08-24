package cleanCatClient.gui.clickgui.settings.impl;

import cleanCatClient.gui.clickgui.components.CheckBox;
import cleanCatClient.gui.clickgui.components.colorpicker.ColorPicker;
import cleanCatClient.gui.clickgui.settings.ModSettings;
import cleanCatClient.gui.font.FontUtil;
import cleanCatClient.mods.ModInstances;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.io.IOException;

public class FPSSetting extends ModSettings {
    private ColorPicker colorPicker;
    private int colorPickerX;
    private int colorPickerY;
    public FPSSetting() {
        super(ModInstances.getFPS());
        colorPickerX = Minecraft.centerX - 20;
        colorPickerY = Minecraft.centerY - 50;
        this.colorPicker = new ColorPicker(colorPickerX, colorPickerY, 150, 100);
    }

    @Override
    public void initGui() {
        super.initGui();
        colorPickerX = Minecraft.centerX - 20;
        colorPickerY = Minecraft.centerY - 50;
        colorPicker.reloadPosition(colorPickerX, colorPickerY);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        mc.fontRendererObj.drawString("FPS Color: ", Minecraft.centerX - 180, Minecraft.centerY - 30 , 0xFFFFFF);
        colorPicker.drawPicker(Minecraft.getMinecraft(), mouseX, mouseY);

    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        colorPicker.mouseClicked(mouseX, mouseY, mouseButton);
    }
    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        colorPicker.mouseReleased(mouseX, mouseY, state);
        ModInstances.getFPS().setColor(colorPicker.getColor());
    }
}