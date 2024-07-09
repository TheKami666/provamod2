package net.tozzifan6717.provamod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tozzifan6717.provamod.ProvaMod;


public class ModTags {
    public static class Blocks {
        //creazione del Tag:
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");


        //questo è un metodo helper, insomma crea il Tag
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ProvaMod.MOD_ID, name));
        }
    }

    public static class Items {
        //creazione del Tag:


        //questo è un metodo helper, insomma crea il Tag
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ProvaMod.MOD_ID, name));
        }

    }
}
