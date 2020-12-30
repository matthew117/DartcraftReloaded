package burn447.dartcraftreloaded;

import burn447.dartcraftreloaded.common.references.ModBlocks;
import burn447.dartcraftreloaded.common.references.ModFluids;
import burn447.dartcraftreloaded.common.references.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DartcraftReloaded.MOD_ID)
public class DartcraftReloaded {

    public static final String MOD_ID = "dartcraftreloaded";
    public static final String MOD_NAME = "Dartcraft Reloaded";

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.APPLE);
        }
    };

    public static Logger LOG = LogManager.getLogger(MOD_ID);

    public DartcraftReloaded() {

        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        event.addListener(this::setup);
        event.addListener(this::setupClient);

        ModItems.ITEMS.register(event);
        ModBlocks.BLOCKS.register(event);
        ModFluids.FLUIDS.register(event);

        ModFluids.registerFluids();
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void setupClient(final FMLClientSetupEvent event) {

    }

}