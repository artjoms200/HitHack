package com.artl.hithack.Module.MOVEMENT;

import com.artl.hithack.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class BHOP extends Module {
    public BHOP() {
        super("BunnyHop", Keyboard.KEY_NONE, Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent e) {
        if (mc.player.onGround) {
            mc.player.jump();
        }
    }
}
