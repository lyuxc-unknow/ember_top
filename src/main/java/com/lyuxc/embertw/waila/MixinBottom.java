package com.lyuxc.embertw.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityMixerBottom;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class MixinBottom {
    public static class l implements IWailaDataProvider {
        @Override
        public ItemStack getWailaStack(IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) { return null; }
        @Override
        public List<String> getWailaHead(ItemStack itemStack, List<String> tips, IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler wailaConfigHandler) { return tips;}
        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack itemStack, List<String> tips, IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler wailaConfigHandler) {
            TileEntityMixerBottom tileEntityMixerBottom = (TileEntityMixerBottom)wailaDataAccessor.getTileEntity();
            assert tileEntityMixerBottom != null;
            if(tileEntityMixerBottom.east.getFluidAmount()>0){
                tips.add(I18n.format("random.east.fluid") + ":" + Objects.requireNonNull(tileEntityMixerBottom.east.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.east.getFluidAmount()+"mB");
            }
            if(tileEntityMixerBottom.south.getFluidAmount()>0){
                tips.add(I18n.format("random.south.fluid") + ":" + Objects.requireNonNull(tileEntityMixerBottom.south.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.south.getFluidAmount()+"mB");
            }
            if(tileEntityMixerBottom.west.getFluidAmount()>0){
                tips.add(I18n.format("random.west.fluid") + ":" + Objects.requireNonNull(tileEntityMixerBottom.west.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.west.getFluidAmount()+"mB");
            }
            if(tileEntityMixerBottom.north.getFluidAmount()>0){
                tips.add(I18n.format("random.north.fluid") + ":" + Objects.requireNonNull(tileEntityMixerBottom.north.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.north.getFluidAmount()+"mB");
            }
            return tips;
        }
        @Nonnull
        @Override
        public NBTTagCompound getNBTData(EntityPlayerMP entityPlayerMP, TileEntity tileEntity, NBTTagCompound nbtTagCompound, World world, BlockPos blockPos) { return null; }
    }
}
