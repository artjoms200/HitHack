package com.artl.hithack.Module.MOVEMENT;

import com.artl.hithack.ExampleMod;
import com.artl.hithack.Module.Module;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.artl.clickgui.Setting;

import java.util.ArrayList;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_NONE, Category.MOVEMENT);

        ArrayList<String> options = new ArrayList<>();
        ExampleMod.instance.settingsManager.rSetting(new Setting("Speed", this, 4.2, 1, 10, false));


    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.onGround && mc.player.moveForward > 0 && !mc.player.isInWater() && !mc.player.isInLava()) {
            double speed = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();

            mc.player.setSprinting(true);
            mc.player.motionY = 0.1;

            float yaw = mc.player.rotationYaw * 0.0174532920F;

            mc.player.motionX -= MathHelper.sin(yaw) * (speed / 5);
            mc.player.motionZ += MathHelper.cos(yaw) * (speed / 5);
        }

        /*
        Legit:

        if (mc.player.onGround && mc.player.moveForward > 0 && !mc.player.isInWater() && !mc.player.isInLava()) {
            mc.player.jump();
        }

         */
    }
}
