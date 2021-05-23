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
import teamroots.embers.tileentity.TileEntityActivatorTop;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class Activator {
    public static class ember implements IWailaDataProvider {
        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack stack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

            double ember = ((TileEntityActivatorTop) Objects.requireNonNull(accessor.getTileEntity())).capability.getEmber();
            double maxember = ((TileEntityActivatorTop) accessor.getTileEntity()).capability.getEmberCapacity();
            currenttip.add(I18n.format("random.power") + ":" + ember + "/" + maxember);

            return currenttip;
        }
    }
}
