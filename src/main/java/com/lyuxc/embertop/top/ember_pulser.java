package com.lyuxc.embertop.top;

import mcjty.theoneprobe.api.*;
import mcjty.theoneprobe.apiimpl.styles.ProgressStyle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityPulser;

import java.awt.*;

public class ember_pulser implements IProbeInfoProvider {
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (world.getTileEntity(data.getPos()) instanceof TileEntityPulser) {
            TileEntityPulser tileEntityPulser = (TileEntityPulser) world.getTileEntity(data.getPos());
            assert tileEntityPulser != null;
            final int max = (int) tileEntityPulser.capability.getEmberCapacity();
            final int ember = (int) tileEntityPulser.capability.getEmber();
            int orange = Color.ORANGE.getRGB();
            int yellow = Color.yellow.getRGB();
            int white = Color.white.getRGB();
            probeInfo.progress(ember, max + 5, new ProgressStyle().prefix(I18n.format("random.power") + ember).suffix("/" + max)
                    .width(110)
                    .numberFormat(NumberFormat.NONE)
                    .borderColor(yellow)
                    .backgroundColor(white)
                    .filledColor(orange));
        }
    }

    public String getID() {
        return "random.ember.pulser";
    }
}
