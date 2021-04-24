package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.*;
import mcjty.theoneprobe.apiimpl.styles.ProgressStyle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityAlchemyPedestal;
import teamroots.embers.tileentity.TileEntityLargeTank;

import java.awt.*;

public class ember_alchemy_pedestal implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityAlchemyPedestal) {
            TileEntityAlchemyPedestal tileEntityAlchemyPedestal = (TileEntityAlchemyPedestal) world.getTileEntity(data.getPos());
            assert tileEntityAlchemyPedestal != null;
            if (!tileEntityAlchemyPedestal.inventory.getStackInSlot(1).isEmpty()) {
                probeInfo.text(I18n.format("random.aspectus") + tileEntityAlchemyPedestal.inventory.getStackInSlot(1).getDisplayName());
            }
            int blackRGB = Color.black.getRGB();
            int darkGrayRGB = Color.darkGray.getRGB();
            int gary = SystemColor.GRAY.getRGB();
            int white = Color.white.getRGB();
            if(!tileEntityAlchemyPedestal.inventory.getStackInSlot(0).isEmpty()){
                probeInfo.progress(tileEntityAlchemyPedestal.inventory.getStackInSlot(0).getCount()-1, 64, new ProgressStyle().prefix(I18n.format("random.ash") + tileEntityAlchemyPedestal.inventory.getStackInSlot(0).getCount()).suffix("/" + "64")
                        .width(101)
                        .numberFormat(NumberFormat.NONE)
                        .borderColor(gary)
                        .backgroundColor(white)
                        .filledColor(darkGrayRGB)
                        .alternateFilledColor(blackRGB));
            }
        }
    }

    public String getID() {
        return "random.ember.alchemy.pedestal";
    }
}
