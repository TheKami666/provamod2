package net.tozzifan6717.provamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.Item.ModItems;
import net.tozzifan6717.provamod.ProvaMod;

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

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProvaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
