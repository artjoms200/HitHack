package com.artl.hithack.Module.MOVEMENT;

import com.artl.hithack.ExampleMod;
import com.artl.hithack.Module.Module;
import com.artl.hithack.Utils.ChatUtils;
import org.lwjgl.input.Keyboard;
import yea.artl.clickgui.Setting;

import java.util.ArrayList;

public class HightJump extends Module {
    public HightJump() {
        super("HightJump", Keyboard.KEY_J, Category.MOVEMENT);

        ArrayList<String> options = new ArrayList<>();

        ExampleMod.instance.settingsManager.rSetting(new Setting("Power", this, 4.2, 1, 10, false));
    }

    @Override
    public void onEnable() {
        mc.player.motionY = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Power").getValDouble();
        ChatUtils.sendMessage("LET'S GOOO!");
        toggle();
    }
}
