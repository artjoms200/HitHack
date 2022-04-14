package com.artl.hithack.Module.MOVEMENT;

import com.artl.hithack.ExampleMod;
import com.artl.hithack.Module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.artl.clickgui.Setting;

import java.util.ArrayList;

public class WaterLeave extends Module {
    public WaterLeave() {
        super("WaterLeave", Keyboard.KEY_NONE, Category.MOVEMENT);

        ArrayList<String> options = new ArrayList<>();
        ExampleMod.instance.settingsManager.rSetting(new Setting("Power", this, 4.2, 1, 10, false));
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent e) {
        int motion = (int) ExampleMod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();

        final BlockPos blockPos = new BlockPos(mc.player.posX, mc.player.posY - 0.1, mc.player.posZ);
        final Block block = mc.world.getBlockState(blockPos).getBlock();

        if (block instanceof BlockLiquid) {
            if (mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY + 0.01, mc.player.posZ)).getBlock() == Block.getBlockById(9) && mc.player.isInsideOfMaterial(Material.AIR)) {
                mc.player.motionY = 0.08;
            } if (mc.player.fallDistance > 0.0f && mc.player.motionY < 0.01) {
                mc.player.motionY = motion;
            }
        }
    }
}
