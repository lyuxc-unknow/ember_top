package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityAlchemyPedestal;

public class ember_alchemy_pedestal implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityAlchemyPedestal) {
            TileEntityAlchemyPedestal tileEntityAlchemyPedestal = (TileEntityAlchemyPedestal) world.getTileEntity(data.getPos());
            assert tileEntityAlchemyPedestal != null;
            probeInfo.text("\u8C61\u5F81:" + tileEntityAlchemyPedestal.inventory.getStackInSlot(1).getDisplayName());
            probeInfo.text("\u7070\u70EC\u50A8\u5B58:" + tileEntityAlchemyPedestal.inventory.getStackInSlot(0).getCount());
        }
    }

    public String getID() {
        return "random.ember.alchemy.pedestal";
    }
}
