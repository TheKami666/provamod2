package net.tozzifan6717.provamod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.Item.ModItems;
import java.util.function.Supplier;
import net.tozzifan6717.provamod.ProvaMod;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProvaMod.MOD_ID);

    //crea il Blocco:
    //[...].copy(Blocks.BloccoDaCopiare.[altri parametri, esempio: .sound(IRON_BLOCK)]...)));
    public static final RegistryObject<Block> ZAFFIRO_BLOCCO = registerBlock("zaffiro_blocco",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> ZAFFIRO_GREZZO_BLOCCO = registerBlock("zaffiro_grezzo_blocco",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    //questi indicano che parliamo di un blocco, NON TOCCARE.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
