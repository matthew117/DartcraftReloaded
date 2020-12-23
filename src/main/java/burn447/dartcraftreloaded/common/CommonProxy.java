package burn447.dartcraftReloaded.proxy;

import net.minecraft.world.World;

public class CommonProxy {

    public World getClientWorld() {
        throw new IllegalStateException("Only run this on Client");
    }

}
