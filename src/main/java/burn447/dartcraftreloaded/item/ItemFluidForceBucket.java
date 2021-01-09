package burn447.dartcraftreloaded.item;

import burn447.dartcraftreloaded.DartcraftReloaded;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ItemFluidForceBucket extends BucketItem {

    public ItemFluidForceBucket(Supplier<? extends Fluid> fluidSupplier) {
        super(fluidSupplier, new Item.Properties()
                .containerItem(Items.BUCKET)
                .maxStackSize(1)
                .group(DartcraftReloaded.ITEM_GROUP));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return new FluidBucketWrapper(stack);
    }
}

