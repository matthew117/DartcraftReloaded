package burn447.dartcraftreloaded.common.references;

import burn447.dartcraftreloaded.DartcraftReloaded;
import burn447.dartcraftreloaded.common.blocks.BlockFluidForce;
import burn447.dartcraftreloaded.common.fluids.FluidForce;
import burn447.dartcraftreloaded.common.fluids.FluidForce.Flowing;
import burn447.dartcraftreloaded.common.items.ItemFluidForceBucket;
import burn447.dartcraftreloaded.common.util.NameUtil;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModFluids {

    private ModFluids() {
    }

    public static ForgeFlowingFluid FLUID_FORCE_SOURCE;
    public static ForgeFlowingFluid FLUID_FORCE_FLOWING;
    public static ForgeFlowingFluid.Properties FLUID_FORCE_PROPERTIES;

    public static void registerFluids() {
        makeProperties();

        FLUID_FORCE_SOURCE = registerFluid(new FluidForce.Source(FLUID_FORCE_PROPERTIES));
        FLUID_FORCE_FLOWING = registerFluid(new FluidForce.Flowing(FLUID_FORCE_PROPERTIES));

        ModBlocks.FLUID_FORCE_BLOCK = new BlockFluidForce(() -> FLUID_FORCE_SOURCE);
        ModItems.BUCKET_FLUID_FORCE = new ItemFluidForceBucket(() -> FLUID_FORCE_SOURCE);
    }

    private static void makeProperties() {
        FLUID_FORCE_PROPERTIES = makeProperties(FluidForce.class, FluidForce::addAttributes,
                () -> FLUID_FORCE_SOURCE, () -> FLUID_FORCE_FLOWING)
                .block(() -> ModBlocks.FLUID_FORCE_BLOCK)
                .bucket(() -> ModItems.BUCKET_FLUID_FORCE);
    }

    private static ForgeFlowingFluid.Properties makeProperties(Class<? extends ForgeFlowingFluid> fluidClass,
                                                               Function<FluidAttributes.Builder, FluidAttributes.Builder> postProcess,
                                                               Supplier<ForgeFlowingFluid> stillFluidSupplier,
                                                               Supplier<ForgeFlowingFluid> flowingFluidSupplier) {
        String name = NameUtil.fromClass(fluidClass, "Fluid").getPath();
        return new ForgeFlowingFluid.Properties(
                stillFluidSupplier,
                flowingFluidSupplier,
                postProcess.apply(builderFor(name)));
    }

    private static FluidAttributes.Builder builderFor(String fluidName) {
        ResourceLocation still = DartcraftReloaded.key("fluid/" + fluidName + "_still");
        ResourceLocation flowing = DartcraftReloaded.key("fluid/" + fluidName + "_flowing");
        return FluidAttributes.builder(still, flowing);
    }

    private static <T extends Fluid> T registerFluid(T fluid) {
        return registerFluid(fluid, NameUtil.fromClass(fluid, "Fluid", "Source"));
    }

    private static <T extends Fluid> T registerFluid(T fluid, ResourceLocation name) {
        fluid.setRegistryName(name);
//        DartcraftReloaded.getProxy().getRegistryPrimer().register(fluid);
        return fluid;
    }
}
