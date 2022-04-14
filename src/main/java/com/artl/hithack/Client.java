package com.artl.hithack;

import com.artl.hithack.Module.CLIENT.Panic;
import com.artl.hithack.Module.COMBAT.*;
import com.artl.hithack.Module.MOVEMENT.*;
import com.artl.hithack.Module.Module;
import com.artl.hithack.Module.PLAYER.BlockReach;
import com.artl.hithack.Module.RENDER.*;
import com.artl.hithack.Module.COMBAT.*;
import com.artl.hithack.Module.EXPLOIT.HackerDetector;
import com.artl.hithack.Module.MOVEMENT.*;
import com.artl.hithack.Module.EXPLOIT.FakeCreative;
import com.artl.hithack.Module.RENDER.*;
import font.FontUtils;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import yea.artl.clickgui.ClickGuiManager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static String name = "Hithack B0.3 | User: " + Minecraft.getMinecraft().getSession().getUsername();
    public static String cName = "Hithack B0.3";
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();

    public static ClickGuiManager clickGuiManager;

    public static void startup() {
        Display.setTitle(name);

        modules.add(new HackerDetector());
        modules.add(new PlayerEntity());
        modules.add(new FakeCreative());
        modules.add(new AttackTrace());
        modules.add(new BlockReach());
        modules.add(new FakePlayer());
        modules.add(new TriggerBot());
        modules.add(new WaterLeave());
        modules.add(new SpawnerESP());
        modules.add(new FullBright());
        modules.add(new Particles());
        modules.add(new ViewModel());
        modules.add(new HightJump());
        modules.add(new TargetHUD());
        modules.add(new ChestESP());
        modules.add(new KillAura());
        modules.add(new Velocity());
        modules.add(new FastFall());
        modules.add(new ItemsESP());
        modules.add(new NameTags());
        modules.add(new GlowESP());
        modules.add(new Tracers());
        modules.add(new AirJump());
        modules.add(new BoatFly());
        modules.add(new AntiBot());
        modules.add(new InvWalk());
        modules.add(new BoxESP());
        modules.add(new Sprint());
        modules.add(new HitBox());
        modules.add(new Spider());
        modules.add(new Jesus());
        modules.add(new Glide());
        modules.add(new Speed());
        modules.add(new Panic());
        modules.add(new BHOP());
        modules.add(new Fly());

        clickGuiManager = new ClickGuiManager();

        FontUtils.bootstrap();
    }

    public static ArrayList<Module> getModulesInCategory(Module.Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }
}
