package com.lyuxc.embertw.top;

import mcjty.theoneprobe.api.*;
import mcjty.theoneprobe.apiimpl.styles.ProgressStyle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityCopperCell;

import java.awt.*;

public class ember_coppercell implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityCopperCell) {
            TileEntityCopperCell tileEntityCopperCell = (TileEntityCopperCell) world.getTileEntity(data.getPos());
            final int max = (int) tileEntityCopperCell.capability.getEmberCapacity();
            final int ember = (int) tileEntityCopperCell.capability.getEmber();
            int orange = Color.ORANGE.getRGB();
            int yellow = Color.yellow.getRGB();
            int white = Color.white.getRGB();
            if(tileEntityCopperCell.capability.getEmber()>0){
                probeInfo.progress(ember, max + 5, new ProgressStyle().prefix(I18n.format("random.power") + ":" + ember).suffix("/" + max)
                        .width(110)
                        .numberFormat(NumberFormat.NONE)
                        .borderColor(yellow)
                        .backgroundColor(white)
                        .filledColor(orange));
            }
        }
    }

    public String getID() {
        return "random.ember.power";
    }
}
