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
import teamroots.embers.tileentity.TileEntityMixerTop;

import java.util.List;
import java.util.Objects;

public class MixinBottom {
    public static class l implements IWailaDataProvider {
        @Override
        public ItemStack getWailaStack(IWailaDataAccessor arg0, IWailaConfigHandler arg1) { return null; }
        @Override
        public List<String> getWailaHead(ItemStack arg0, List<String> currenttip, IWailaDataAccessor arg2, IWailaConfigHandler arg3) { return currenttip;}
        @Override
        public List<String> getWailaBody(ItemStack stack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

            TileEntityMixerBottom tileEntityMixerBottom = (TileEntityMixerBottom)accessor.getTileEntity();
            assert tileEntityMixerBottom != null;
            if(tileEntityMixerBottom.south.getFluidAmount()>0){
                currenttip.add(I18n.format("random.south.fluid")+ Objects.requireNonNull(tileEntityMixerBottom.south.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.south.getFluidAmount());
            }
            if(tileEntityMixerBottom.west.getFluidAmount()>0){
                currenttip.add(I18n.format("random.west.fluid")+ Objects.requireNonNull(tileEntityMixerBottom.west.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.south.getFluidAmount());
            }
            if(tileEntityMixerBottom.east.getFluidAmount()>0){
                currenttip.add(I18n.format("random.east.fluid")+ Objects.requireNonNull(tileEntityMixerBottom.east.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.south.getFluidAmount());

            }
            if(tileEntityMixerBottom.north.getFluidAmount()>0){
                currenttip.add(I18n.format("random.north.fluid")+ Objects.requireNonNull(tileEntityMixerBottom.south.getFluid()).getLocalizedName()+"*"+tileEntityMixerBottom.north.getFluidAmount());
            }

            return currenttip;
        }
        @Override
        public NBTTagCompound getNBTData(EntityPlayerMP arg0, TileEntity arg1, NBTTagCompound arg2, World arg3, BlockPos arg4) { return null; }
    }
}
