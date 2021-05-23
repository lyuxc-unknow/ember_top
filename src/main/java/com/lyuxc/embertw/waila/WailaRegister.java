package com.lyuxc.embertw.waila;

import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraftforge.fml.common.Loader;
import teamroots.embers.block.*;

@WailaPlugin
public class WailaRegister implements IWailaPlugin {
    public void register(IWailaRegistrar registrar){
        if(Loader.isModLoaded("waila")){
            
            registrar.registerBodyProvider(new CopperCell.ember(), BlockCopperCell.class);

            registrar.registerBodyProvider(new Activator.ember(), BlockActivator.class);

            registrar.registerBodyProvider(new AutoHammer.ember(), BlockAutoHammer.class);

            registrar.registerBodyProvider(new BeamCannon.ember(), BlockBeamCannon.class);

            registrar.registerBodyProvider(new BeamSplitter.ember(), BlockBeamSplitter.class);

            registrar.registerBodyProvider(new CinderPlinth.ember(),BlockCinderPlinth.class);

            registrar.registerBodyProvider(new CrystalCell.ember(),BlockCrystalCell.class);

            registrar.registerBodyProvider(new EmberInjector.ember(),BlockEmberInjector.class);

            registrar.registerBodyProvider(new Emitter.ember(),BlockEmberEmitter.class);

            registrar.registerBodyProvider(new EmberFunnel.ember(),BlockEmberFunnel.class);

            registrar.registerBodyProvider(new Furnace.ember(),BlockFurnace.class);

            registrar.registerBodyProvider(new Mixer.ember(),BlockMixer.class);

            registrar.registerBodyProvider(new MixinBottom.l(),BlockMixer.class);

            registrar.registerBodyProvider(new Pulser.ember(),BlockEmberPulser.class);

            registrar.registerBodyProvider(new Reactor.ember(),BlockReactor.class);

            registrar.registerBodyProvider(new Receiver.ember(),BlockEmberReceiver.class);

            registrar.registerBodyProvider(new Stampr.ember(),BlockStamper.class);

            registrar.registerNBTProvider(new CopperCell.ember(),BlockCopperCell.class);

        }
    }
}
