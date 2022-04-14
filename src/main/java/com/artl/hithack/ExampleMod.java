package com.artl.hithack;

import com.artl.hithack.Menu.onGuiOpenEvent;
import com.artl.hithack.UI.ui;
import com.artl.hithack.keys.key;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.Session;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import yea.artl.clickgui.ClickGuiManager;
import yea.artl.clickgui.SettingsManager;
import com.artl.hithack.Chat.ChatEvent;

import java.lang.reflect.Field;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "hithack";
    public static final String NAME = "HitHackClient";
    public static final String VERSION = "0.3";

    public static ExampleMod instance;
    public SettingsManager settingsManager;
    public ClickGuiManager clickGui;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ExampleMod.logger = event.getModLog();
        Display.setTitle("Loading " + Client.name);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ChatEvent());
        clickGui = new ClickGuiManager();
        instance = this;
        settingsManager = new SettingsManager();

        Client.startup();

        MinecraftForge.EVENT_BUS.register(new key());
        MinecraftForge.EVENT_BUS.register(new ui());
        MinecraftForge.EVENT_BUS.register(new onGuiOpenEvent());
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    public static void setSession(Session s) {
        Class<? extends Minecraft> mc = Minecraft.getMinecraft().getClass();

        try {
            Field session = null;

            for (Field f : mc.getDeclaredFields()) {
                if (f.getType().isInstance(s)) {
                    session = f;
                }
            }

            if (session == null) {
                throw new IllegalStateException("Session Null");
            }

            session.setAccessible(true);
            session.set(Minecraft.getMinecraft(), s);
            session.setAccessible(false);

            Client.name = "HitHack B0.3 | User: " + Minecraft.getMinecraft().getSession().getUsername();
            Display.setTitle(Client.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
