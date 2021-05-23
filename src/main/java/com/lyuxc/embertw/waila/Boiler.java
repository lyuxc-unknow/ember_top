package com.lyuxc.embertw.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import teamroots.embers.tileentity.TileEntityBoilerTop;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class Boiler {
    public static class ember implements IWailaDataProvider {
        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack stack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

            double ember = ((TileEntityBoilerTop) Objects.requireNonNull(accessor.getTileEntity())).capability.getEmber();
            double maxember = ((TileEntityBoilerTop) accessor.getTileEntity()).capability.getEmberCapacity();
            currenttip.add(I18n.format("random.power") + ":" + ember + "/" + maxember);

            return currenttip;
        }
    }
}
