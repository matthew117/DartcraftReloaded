package burn447.dartcraftreloaded.common;

import net.minecraft.world.World;

public class CommonProxy {

    public World getClientWorld() {
        throw new IllegalStateException("Only run this on Client");
    }

}
