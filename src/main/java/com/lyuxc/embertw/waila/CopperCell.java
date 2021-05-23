package com.lyuxc.embertw.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.tileentity.TileEntityCopperCell;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class CopperCell {
    public static class ember implements IWailaDataProvider {
        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack stack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
            TileEntityCopperCell tileEntityCopperCell = (TileEntityCopperCell)accessor.getTileEntity();
            double ember = ((TileEntityCopperCell) Objects.requireNonNull(accessor.getTileEntity())).capability.getEmber();
            double maxember = ((TileEntityCopperCell)accessor.getTileEntity()).capability.getEmberCapacity();
            assert tileEntityCopperCell != null;
            if(tileEntityCopperCell.capability.getEmber()>0){
                currenttip.add(I18n.format("random.power")+":"+ember+"/"+maxember);
            }
            return currenttip;
        }
        @Override
        public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
            return currenttip;
        }
        @Override
        public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos)
        {
            if ( te instanceof TileEntityCopperCell)
            {
                TileEntityCopperCell cell = (TileEntityCopperCell) te;
                NBTTagCompound compound = new NBTTagCompound();
                int ember = (int)cell.capability.getEmber();
                int max = (int)cell.capability.getEmberCapacity();
                compound.setInteger("ember", ember);
                compound.setInteger("embercapacity", max);
                tag.setTag("Ember", compound);
            }
            return tag;
        }
    }
}
