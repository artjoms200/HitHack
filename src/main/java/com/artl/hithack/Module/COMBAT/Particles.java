package com.artl.hithack.Module.COMBAT;

import com.artl.hithack.Module.Module;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Particles extends Module {
    public Particles() {
        super("Particles", Keyboard.KEY_NONE, Category.COMBAT);
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent e) {
        for (int i = 16; i >= 0; i = i - 1) {
            mc.player.onCriticalHit(e.getTarget());
        }
    }
}
