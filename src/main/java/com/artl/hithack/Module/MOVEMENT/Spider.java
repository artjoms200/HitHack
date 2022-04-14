package com.artl.hithack.Module.MOVEMENT;

import com.artl.hithack.ExampleMod;
import com.artl.hithack.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.artl.clickgui.Setting;

import java.util.ArrayList;

public class Spider extends Module {
    public Spider() {
        super("Spider", Keyboard.KEY_NONE, Category.MOVEMENT);

        ArrayList<String> options = new ArrayList<>();
        ExampleMod.instance.settingsManager.rSetting(new Setting("Speed", this, 4.2, 0.25, 10, false));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.collidedHorizontally) {
            mc.player.motionY = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();
        }
    }
}
