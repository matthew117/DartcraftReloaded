package burn447.dartcraftReloaded.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

}
