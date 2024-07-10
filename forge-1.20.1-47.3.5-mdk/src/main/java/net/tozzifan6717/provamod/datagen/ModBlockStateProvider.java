package net.tozzifan6717.provamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProvaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ZAFFIRO_BLOCCO);
        blockWithItem(ModBlocks.ZAFFIRO_GREZZO_BLOCCO);

        blockWithItem(ModBlocks.ZAFFIRO_MINERALE);
        blockWithItem(ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE);
        blockWithItem(ModBlocks.ZAFFIRO_MINERALE_NETHER);
        blockWithItem(ModBlocks.ZAFFIRO_MINERALE_END);

        blockWithItem(ModBlocks.SOUNDBLOCK);

        stairsBlock(((StairBlock) ModBlocks.ZAFFIRO_SCALE.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        slabBlock(((SlabBlock) ModBlocks.ZAFFIRO_SLAB.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        buttonBlock(((ButtonBlock) ModBlocks.ZAFFIRO_BOTTONE.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ZAFFIRO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        fenceBlock(((FenceBlock) ModBlocks.ZAFFIRO_FENCE.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ZAFFIRO_FENCE_GATE.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));
        wallBlock(((WallBlock) ModBlocks.ZAFFIRO_MURO.get()), blockTexture(ModBlocks.ZAFFIRO_BLOCCO.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.ZAFFIRO_PORTA.get()), modLoc("block/zaffiro_porta_bottom"), modLoc("block/zaffiro_porta_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ZAFFIRO_BOTOLA.get()), modLoc("block/zaffiro_botola"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
