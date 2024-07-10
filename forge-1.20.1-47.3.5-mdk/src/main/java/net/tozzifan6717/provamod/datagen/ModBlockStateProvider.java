package net.tozzifan6717.provamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
