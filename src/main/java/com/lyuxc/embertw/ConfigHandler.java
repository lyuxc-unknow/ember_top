package com.lyuxc.embertw;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
    public static boolean top = false;
    public static boolean waila = false;
    public static void ReadConfig(){
        Configuration config = EmberTW.configuration;
        try{
            config.load();
            InitTop(config);
            InitWaila(config);
        }finally {
            if(config.hasChanged()){
                config.save();
            }
        }
    }
    private static void InitTop(Configuration config){
        config.addCustomCategoryComment("top","Top");
        top = config.getBoolean("Enable","top",top,"Enable Top Support","config.enable.top");
    }
    private static void InitWaila(Configuration config){
        config.addCustomCategoryComment("waila","Waila");
        waila = config.getBoolean("Enable","waila",waila,"Enable Waila Support","config.enable.waila");
    }
}
