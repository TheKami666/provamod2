package net.tozzifan6717.provamod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.Item.ModItems;
import java.util.function.Supplier;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.custom.SoundBlock;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProvaMod.MOD_ID);

    //crea il Blocco:
    //[...].copy(Blocks.BloccoDaCopiare.[altri parametri, esempio: .sound(IRON_BLOCK)]...)));
    public static final RegistryObject<Block> ZAFFIRO_BLOCCO = registerBlock("zaffiro_blocco",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ZAFFIRO_GREZZO_BLOCCO = registerBlock("zaffiro_grezzo_blocco",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    //crea un blocco ORE (minerale).
    public static final RegistryObject<Block> ZAFFIRO_MINERALE = registerBlock("zaffiro_minerale",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> ZAFFIRO_MINERALE_DEEPSLATE = registerBlock("zaffiro_minerale_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ZAFFIRO_MINERALE_NETHER = registerBlock("zaffiro_minerale_nether",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ZAFFIRO_MINERALE_END = registerBlock("zaffiro_minerale_end",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> SOUNDBLOCK = registerBlock("soundblock",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //blocchi "speciali" come scale, trapdoor, porte ecc...
    public static final RegistryObject<Block> ZAFFIRO_SCALE = registerBlock("zaffiro_scale",
            () -> new StairBlock(()-> ModBlocks.ZAFFIRO_BLOCCO.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ZAFFIRO_SLAB = registerBlock("zaffiro_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ZAFFIRO_BOTTONE = registerBlock("zaffiro_bottone",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> ZAFFIRO_PRESSURE_PLATE = registerBlock("zaffiro_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final RegistryObject<Block> ZAFFIRO_FENCE = registerBlock("zaffiro_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ZAFFIRO_FENCE_GATE = registerBlock("zaffiro_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ZAFFIRO_MURO = registerBlock("zaffiro_muro",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ZAFFIRO_PORTA = registerBlock("zaffiro_porta",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> ZAFFIRO_BOTOLA = registerBlock("zaffiro_botola",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));




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
