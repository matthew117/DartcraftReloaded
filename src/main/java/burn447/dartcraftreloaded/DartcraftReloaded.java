package burn447.dartcraftreloaded;

import burn447.dartcraftreloaded.client.ClientProxy;
import burn447.dartcraftreloaded.common.CommonProxy;
import burn447.dartcraftreloaded.common.references.*;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Constants.MOD_ID)
public class DartcraftReloaded {

    public static Logger LOG = LogManager.getLogger(Constants.MOD_ID);

    private static DartcraftReloaded instance;
    private static ModContainer modContainer;

    public final CommonProxy proxy;

    public DartcraftReloaded() {
        instance = this;
        modContainer = ModList.get().getModContainerById(Constants.MOD_ID).get();

        this.proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

        IEventBus fmlEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        fmlEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);


    }

    public static DartcraftReloaded getInstance() {
        return instance;
    }

    public static ModContainer getModContainer() {
        return modContainer;
    }

    public static CommonProxy getProxy() {
        return getInstance().proxy;
    }

    public static ResourceLocation key(String path) {
        return new ResourceLocation(Constants.MOD_ID, path);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {

        }
    }

}