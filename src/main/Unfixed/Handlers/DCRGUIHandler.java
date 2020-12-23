package burn447.dartcraftreloaded.Handlers;

import burn447.dartcraftreloaded.Items.ItemForcePack;
import burn447.dartcraftreloaded.client.gui.belt.GUIForceBelt;
import burn447.dartcraftreloaded.client.gui.furnace.GUIFurnace;
import burn447.dartcraftreloaded.client.gui.infuser.GUIInfuser;
import burn447.dartcraftreloaded.client.gui.pack.GUIForcePack;
import burn447.dartcraftreloaded.container.ContainerBlockFurnace;
import burn447.dartcraftreloaded.container.ContainerBlockInfuser;
import burn447.dartcraftreloaded.container.ContainerItemForceBelt;
import burn447.dartcraftreloaded.container.ContainerItemForcePack;
import burn447.dartcraftreloaded.tileEntity.TileEntityForceFurnace;
import burn447.dartcraftreloaded.tileEntity.TileEntityInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by BURN447 on 3/31/2018.
 */
public class DCRGUIHandler implements IGuiHandler {

    public static final int INFUSER = 0;
    public static final int FURNACE = 1;
    public static final int PACK = 2;
    public static final int BELT = 3;


    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == INFUSER){
            return new GUIInfuser(player.inventory, (TileEntityInfuser)world.getTileEntity(new BlockPos(x, y, z)));
        }
        else if(ID == FURNACE) {
            return new GUIFurnace(player.inventory, (TileEntityForceFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        }
        else if (ID == PACK) {
            return new GUIForcePack(player.inventory, player.getHeldItemMainhand());
        }
        else if(ID == BELT) {
            return new GUIForceBelt(player.inventory, player.getHeldItemMainhand());
        }
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == INFUSER) {
            return new ContainerBlockInfuser(player.inventory, (TileEntityInfuser) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == FURNACE) {
            return new ContainerBlockFurnace(player.inventory, (TileEntityForceFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == PACK) {
            return new ContainerItemForcePack(player.inventory, player.getHeldItemMainhand());
        } else if (ID == BELT) {
            return new ContainerItemForceBelt(player.inventory, player.getHeldItemMainhand());
        }
        return null;
    }
}
