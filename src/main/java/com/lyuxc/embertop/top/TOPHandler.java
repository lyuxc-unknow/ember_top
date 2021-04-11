package com.lyuxc.embertop.top;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.apiimpl.TheOneProbeImp;

public class TOPHandler  {
    public static void registerTips(){
        TheOneProbeImp theOneProbeImp = TheOneProbe.theOneProbeImp;
        theOneProbeImp.registerProvider(new ember_power());
        theOneProbeImp.registerProvider(new ember_auto_hummer());
        theOneProbeImp.registerProvider(new ember_beam_cannon());
        theOneProbeImp.registerProvider(new ember_cinder_plinth());
        theOneProbeImp.registerProvider(new ember_furnace());
        theOneProbeImp.registerProvider(new ember_mixer());
        theOneProbeImp.registerProvider(new ember_stamper());
    }
}

