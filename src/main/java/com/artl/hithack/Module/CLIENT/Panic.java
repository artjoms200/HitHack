package com.artl.hithack.Module.CLIENT;

import com.artl.hithack.Module.Module;
import com.artl.hithack.Client;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Panic extends Module {
    public static boolean isPanic = false;

    public Panic() {
        super("Panic", Keyboard.KEY_INSERT, Category.CLIENT);
    }

    @Override
    public void onEnable() {
        isPanic = true;

        Display.setTitle("Minecraft 1.12.2");

        for (Module m : Client.modules) {
            if (m != this) {
                m.setToggled(false);
            }
        }
    }

    @Override
    public void onDisable() {
        isPanic = false;

        Display.setTitle(Client.name);
    }
}
