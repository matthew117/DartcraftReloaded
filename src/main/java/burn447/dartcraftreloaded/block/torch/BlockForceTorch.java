//package burn447.dartcraftreloaded.block.torch;
//
//import burn447.dartcraftreloaded.DartcraftReloaded;
//import net.minecraft.block.BlockTorch;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.TorchBlock;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemBlock;
//
//public class BlockForceTorch extends TorchBlock {
//
//    String name;
//
//    public BlockForceTorch(String name) {
//        this.name = name;
//        this.setRegistryName(name);
//        this.setCreativeTab(DartcraftReloaded.creativeTab);
//        this.setLightLevel(0.9375F);
//        this.setSoundType(SoundType.WOOD);
//    }
//
//    public void registerItemModel(Item itemBlock) {
//        DartcraftReloaded.proxy.registerItemRenderer(itemBlock, 0, name);
//    }
//
//    public Item createItemBlock() {
//        return new ItemBlock(this).setRegistryName(getRegistryName());
//    }
//}