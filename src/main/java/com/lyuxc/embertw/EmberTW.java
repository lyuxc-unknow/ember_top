package com.lyuxc.embertw;

import com.lyuxc.embertw.top.TOPHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(
        modid = EmberTW.MOD_ID,
        name = EmberTW.MOD_NAME,
        version = "0.0.4",
        dependencies = "required-after:embers;after:theoneprobe;after:waila"
)

public class EmberTW {
    public static final String MOD_ID = "ember_top";
    public static final String MOD_NAME = "Ember Top";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if(Loader.isModLoaded("theoneprobe")){
            TOPHandler.registerTips();
        }
    }
}
