package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityCrystalCell;


public class ember_crystal_cell implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityCrystalCell) {
            TileEntityCrystalCell tileEntityCrystalCell = (TileEntityCrystalCell) world.getTileEntity(data.getPos());
            assert tileEntityCrystalCell != null;
            probeInfo.text("\u7070\u70EC\u80FD\u91CF\u50A8\u5B58:" + tileEntityCrystalCell.capability.getEmber() + "/" + tileEntityCrystalCell.capability.getEmberCapacity());
        }
    }

    public String getID() {
        return "random.crystal.cell";
    }
}
