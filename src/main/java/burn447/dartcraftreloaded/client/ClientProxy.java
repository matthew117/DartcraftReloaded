package burn447.dartcraftreloaded.client;

import burn447.dartcraftreloaded.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

}
