package com.lyuxc.embertw;

import com.lyuxc.embertw.top.TOPHandler;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;


@Mod(
        modid = EmberTW.MOD_ID,
        name = EmberTW.MOD_NAME,
        version = "0.0.11",
        dependencies = "required-after:embers;after:theoneprobe;after:waila"
)

public class EmberTW {
    public static final String MOD_ID = "ember_top_and_waila";
    public static final String MOD_NAME = "Ember Top and Waila";
    public static Configuration configuration;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event){
        File dir = event.getModConfigurationDirectory();
        configuration = new Configuration(new File(dir.getPath(), "embertw.cfg"));
        ConfigHandler.ReadConfig();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if((Loader.isModLoaded("theoneprobe") & ConfigHandler.top == true)){
            TOPHandler.registerTips();
        }
    }
}
