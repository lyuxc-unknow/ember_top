package com.lyuxc.embertw.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import teamroots.embers.tileentity.TileEntityActivatorTop;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class Activator {
    public static class ember implements IWailaDataProvider {
        @Nonnull
        @Override
        public ItemStack getWailaStack(IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler wailaConfigHandler) { return null; }
        @Nonnull
        @Override
        public List<String> getWailaHead(ItemStack itemStack, List<String> tips, IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler wailaConfigHandler) { return tips;}
        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack itemStack, List<String> tips, IWailaDataAccessor wailaDataAccessor, IWailaConfigHandler wailaConfigHandler) {

            double ember = ((TileEntityActivatorTop) Objects.requireNonNull(wailaDataAccessor.getTileEntity())).capability.getEmber();
            double maxember = ((TileEntityActivatorTop) accessor.getTileEntity()).capability.getEmberCapacity();
            tips.add(I18n.format("random.power") + ":" + ember + "/" + maxember);

            return tips;
        }
        @Override
        public NBTTagCompound getNBTData(EntityPlayerMP entityPlayerMP, TileEntity tileEntity, NBTTagCompound nbtTagCompound, World world, BlockPos blockPos) { return null; }
    }
}
