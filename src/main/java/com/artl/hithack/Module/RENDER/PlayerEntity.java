package com.artl.hithack.Module.RENDER;

import com.artl.hithack.Module.Module;
import com.artl.hithack.Utils.RenderUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class PlayerEntity extends Module {
    public PlayerEntity() {
        super("PlayerEntity", Keyboard.KEY_NONE, Category.RENDER);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        switch (event.getType()) {
            case TEXT:
                RenderUtils.renderEntity(mc.player, 30, 40, 100);
                break;
            default:
                break;
        }
    }
}
