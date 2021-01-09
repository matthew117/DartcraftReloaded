package burn447.dartcraftreloaded.references;

import burn447.dartcraftreloaded.DartcraftReloaded;
import burn447.dartcraftreloaded.block.BlockFluidForce;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DartcraftReloaded.MOD_ID);

    public static final RegistryObject<Block> FLUID_FORCE_BLOCK = BLOCKS.register(
            "fluid_force",
            () -> new BlockFluidForce(ModFluids.FLUID_FORCE_SOURCE,
                                      Block.Properties.create(Material.WATER)
                                                      .doesNotBlockMovement()
                                                      .setLightLevel(state -> 15)
                                                      .noDrops())
    );

    private ModBlocks() {
    }

}
