package burn447.dartcraftreloaded.references;

import burn447.dartcraftreloaded.DartcraftReloaded;
import burn447.dartcraftreloaded.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DartcraftReloaded.MOD_ID);

    public static final RegistryObject<Item> BUCKET_FLUID_FORCE = ITEMS.register(
            "force_bucket",
            () -> new ItemFluidForceBucket(() -> ModFluids.FLUID_FORCE_SOURCE.get())
    );

    private ModItems() {
    }

}