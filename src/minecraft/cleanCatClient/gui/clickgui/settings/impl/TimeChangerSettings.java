package cleanCatClient.gui.clickgui.settings.impl;

import cleanCatClient.gui.clickgui.components.Slider;
import cleanCatClient.gui.clickgui.settings.ModSettings;
import cleanCatClient.mods.ModInstances;
import net.minecraft.client.Minecraft;

import java.io.IOException;

public class TimeChangerSettings extends ModSettings {
    private Slider timeSlider;

    public TimeChangerSettings() {
        super(ModInstances.getTimeChangerMod());
        timeSlider = new Slider(Minecraft.centerX - 100, Minecraft.centerY + 20, 150, 20, 1, 15000, 1, 100);
    }

    @Override
    public void initGui() {
        super.initGui();
        timeSlider.reloadPosition(Minecraft.centerX - 100, Minecraft.centerY + 20);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        timeSlider.drawSlider(Minecraft.getMinecraft(), mouseX, mouseY);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        timeSlider.mouseClicked(mouseX, mouseY, mouseButton);
        ModInstances.getTimeChangerMod().setTime((long) timeSlider.getCurrentValue());
    }


    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        timeSlider.mouseReleased(mouseX, mouseY, state);
    }
}