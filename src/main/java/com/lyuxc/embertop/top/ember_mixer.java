package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityMixerTop;

public class ember_mixer implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityMixerTop) {
            TileEntityMixerTop tileEntityMixerTop = (TileEntityMixerTop) world.getTileEntity(data.getPos());
            assert tileEntityMixerTop != null;
            probeInfo.text(I18n.format("random.power") + tileEntityMixerTop.capability.getEmber() + "/" + tileEntityMixerTop.capability.getEmberCapacity());
        }
    }

    public String getID() {
        return "random.ember.mixer";
    }
}
