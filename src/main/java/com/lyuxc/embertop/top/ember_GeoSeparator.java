package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityGeoSeparator;

public class ember_GeoSeparator implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityGeoSeparator) {
            TileEntityGeoSeparator tileEntityGeoSeparator = (TileEntityGeoSeparator) world.getTileEntity(data.getPos());
            assert tileEntityGeoSeparator != null;
            probeInfo.text("\u5B58\u6709:" + tileEntityGeoSeparator.getFluidStack().getLocalizedName());
        }
    }

    public String getID() {
        return "random.ember.geoseparator";
    }
}
