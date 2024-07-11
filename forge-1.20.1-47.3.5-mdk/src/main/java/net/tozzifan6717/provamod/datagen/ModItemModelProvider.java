package net.tozzifan6717.provamod.datagen;


import net.tozzifan6717.provamod.Item.ModItems;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProvaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //qui dentro si aggiungono gli oggetti.
        simpleItem(ModItems.ZAFFIRO);
        simpleItem(ModItems.ZAFFIRO_PURO);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.FRAGOLA);
        simpleItem(ModItems.PIGNA);

        evenSimplerBlockItem(ModBlocks.ZAFFIRO_SCALE);
        evenSimplerBlockItem(ModBlocks.ZAFFIRO_SLAB);
        evenSimplerBlockItem(ModBlocks.ZAFFIRO_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.ZAFFIRO_FENCE_GATE);


        simpleBlockItem(ModBlocks.ZAFFIRO_PORTA);
        fenceItem(ModBlocks.ZAFFIRO_FENCE, ModBlocks.ZAFFIRO_BLOCCO);
        buttonItem(ModBlocks.ZAFFIRO_BOTTONE, ModBlocks.ZAFFIRO_BLOCCO);
        wallItem(ModBlocks.ZAFFIRO_MURO, ModBlocks.ZAFFIRO_BLOCCO);
        trapdoorItem(ModBlocks.ZAFFIRO_BOTOLA);
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ProvaMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProvaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ProvaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ProvaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ProvaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProvaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
