package burn447.dartcraftreloaded.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BlockFluidForce extends FlowingFluidBlock {

    public BlockFluidForce(Supplier<? extends FlowingFluid> fluidSupplier) {
        super(fluidSupplier,
                Block.Properties.create(Material.WATER)
                        .doesNotBlockMovement()
                        .setLightLevel(state -> 15)
                        .noDrops());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, 10, 10));
        }
        entity.setMotionMultiplier(state, new Vector3d(-2, -20F, -2));
    }
}
