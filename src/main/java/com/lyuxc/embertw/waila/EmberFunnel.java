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
import teamroots.embers.tileentity.TileEntityEmberFunnel;

import java.util.List;
import java.util.Objects;

public class EmberFunnel {
    public static class ember implements IWailaDataProvider {
        @Override
        public ItemStack getWailaStack(IWailaDataAccessor arg0, IWailaConfigHandler arg1) { return null; }
        @Override
        public List<String> getWailaHead(ItemStack arg0, List<String> currenttip, IWailaDataAccessor arg2, IWailaConfigHandler arg3) { return currenttip;}
        @Override
        public List<String> getWailaBody(ItemStack stack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

            double ember = ((TileEntityEmberFunnel) Objects.requireNonNull(accessor.getTileEntity())).capability.getEmber();
            double maxember = ((TileEntityEmberFunnel) Objects.requireNonNull(accessor.getTileEntity())).capability.getEmberCapacity();
            currenttip.add(I18n.format("random.power")+":"+ember+"/"+maxember);

            return currenttip;
        }
        @Override
        public NBTTagCompound getNBTData(EntityPlayerMP arg0, TileEntity arg1, NBTTagCompound arg2, World arg3, BlockPos arg4) { return null; }
    }
}
