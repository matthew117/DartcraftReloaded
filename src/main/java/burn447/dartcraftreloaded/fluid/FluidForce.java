package burn447.dartcraftreloaded.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Rarity;
import net.minecraft.state.StateContainer;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

/**
 * Created by BURN447 on 6/22/2018.
 */
public abstract class FluidForce extends ForgeFlowingFluid {

    private FluidForce(Properties properties) {
        super(properties);
    }

    public static FluidAttributes.Builder addAttributes(FluidAttributes.Builder builder) {
        return builder
                .rarity(Rarity.RARE)
                .density(2000)
                .viscosity(1000)
                .temperature(120);
    }

    public static class Flowing extends FluidForce {

        public Flowing(Properties properties) {
            super(properties);
            setDefaultState(getStateContainer().getBaseState().with(LEVEL_1_8, 7));
        }

        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL_1_8);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends FluidForce {

        public Source(Properties properties) {
            super(properties);
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }

    }
}
