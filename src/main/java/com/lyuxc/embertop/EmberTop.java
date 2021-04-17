package com.lyuxc.embertop;

import com.lyuxc.embertop.top.TOPHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = EmberTop.MOD_ID,
        name = EmberTop.MOD_NAME,
        version = "0.0.4",
        dependencies = "required-after:embers;required-after:theoneprobe"
)

public class EmberTop {
    public static final String MOD_ID = "ember_top";
    public static final String MOD_NAME = "Ember Top";

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event){ }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        TOPHandler.registerTips();
    }
}
