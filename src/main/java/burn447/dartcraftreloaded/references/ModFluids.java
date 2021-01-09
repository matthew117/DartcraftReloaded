package burn447.dartcraftreloaded.references;

import burn447.dartcraftreloaded.DartcraftReloaded;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DartcraftReloaded.MOD_ID);

    public static RegistryObject<FlowingFluid> FLUID_FORCE_SOURCE;
    public static RegistryObject<FlowingFluid> FLUID_FORCE_FLOWING;

    public static ForgeFlowingFluid.Properties FLUID_FORCE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> FLUID_FORCE_SOURCE.get(),
            () -> FLUID_FORCE_FLOWING.get(),
            FluidAttributes.builder(
                    new ResourceLocation(DartcraftReloaded.MOD_ID, "fluid/fluid_force_source"),
                    new ResourceLocation(DartcraftReloaded.MOD_ID, "fluid/fluid_force_flowing")
            )
                    .rarity(Rarity.RARE)
                    .density(2000)
                    .viscosity(1000)
                    .temperature(120)
    ).bucket(ModItems.BUCKET_FLUID_FORCE)
     .block(() -> (FlowingFluidBlock) ModBlocks.FLUID_FORCE_BLOCK.get());

    private ModFluids() {
    }

    public static void registerFluids() {
        FLUID_FORCE_SOURCE = FLUIDS.register(
                "fluid_force_source",
                () -> new ForgeFlowingFluid.Source(FLUID_FORCE_PROPERTIES)
        );

        FLUID_FORCE_FLOWING = FLUIDS.register(
                "fluid_force_flowing",
                () -> new ForgeFlowingFluid.Flowing(FLUID_FORCE_PROPERTIES)
        );
    }

}