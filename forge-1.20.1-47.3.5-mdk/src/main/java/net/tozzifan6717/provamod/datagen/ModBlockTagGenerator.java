package net.tozzifan6717.provamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.ModBlocks;
import net.tozzifan6717.provamod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProvaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //dentro le parentesi, va inserito in quale file .json verranno inseriti i tag:
        //qui si inseriscono tutti i blocchi detectabili del metal_detector.
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .addTag(Tags.Blocks.ORES_IRON)
                .addTag(Tags.Blocks.ORES_COPPER)
                .addTag(Tags.Blocks.ORES_GOLD)
                .addTag(Tags.Blocks.ORES_REDSTONE);

        //qui si inseriscono tutti i blocchi minabili con un utensile di Ferro.
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ZAFFIRO_BLOCCO.get(),
                        ModBlocks.ZAFFIRO_GREZZO_BLOCCO.get(),
                        ModBlocks.ZAFFIRO_MINERALE.get(),
                        ModBlocks.ZAFFIRO_MINERALE.get(),
                        ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get(),
                        ModBlocks.ZAFFIRO_MINERALE_NETHER.get(),
                        ModBlocks.ZAFFIRO_MINERALE_END.get()
                );

        //qui si inseriscono tutti i blocchi minabili con un piccone.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ZAFFIRO_BLOCCO.get(),
                        ModBlocks.ZAFFIRO_GREZZO_BLOCCO.get(),
                        ModBlocks.ZAFFIRO_MINERALE.get(),
                        ModBlocks.ZAFFIRO_MINERALE.get(),
                        ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get(),
                        ModBlocks.ZAFFIRO_MINERALE_NETHER.get(),
                        ModBlocks.ZAFFIRO_MINERALE_END.get()
                );

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ZAFFIRO_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ZAFFIRO_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.ZAFFIRO_MURO.get());

    }
}
