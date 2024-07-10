package net.tozzifan6717.provamod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.Item.ModItems;
import net.tozzifan6717.provamod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ZAFFIRO_BLOCCO.get());
        this.dropSelf(ModBlocks.ZAFFIRO_GREZZO_BLOCCO.get());
        this.dropSelf(ModBlocks.SOUNDBLOCK.get());

        this.dropSelf(ModBlocks.ZAFFIRO_SCALE.get());
        this.dropSelf(ModBlocks.ZAFFIRO_BOTTONE.get());
        this.dropSelf(ModBlocks.ZAFFIRO_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ZAFFIRO_BOTOLA.get());
        this.dropSelf(ModBlocks.ZAFFIRO_FENCE.get());
        this.dropSelf(ModBlocks.ZAFFIRO_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ZAFFIRO_MURO.get());

        this.add(ModBlocks.ZAFFIRO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ZAFFIRO_SLAB.get()));
        this.add(ModBlocks.ZAFFIRO_PORTA.get(),
                block -> createDoorTable(ModBlocks.ZAFFIRO_PORTA.get()));

        this.add(ModBlocks.ZAFFIRO_MINERALE.get(),
                block -> createOreDrop(ModBlocks.ZAFFIRO_MINERALE.get(), ModItems.ZAFFIRO_PURO.get()));

        this.add(ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get(), ModItems.ZAFFIRO_PURO.get()));

        this.add(ModBlocks.ZAFFIRO_MINERALE_NETHER.get(),
                block -> createOreDrop(ModBlocks.ZAFFIRO_MINERALE_NETHER.get(), ModItems.ZAFFIRO_PURO.get()));

        this.add(ModBlocks.ZAFFIRO_MINERALE_END.get(),
                block -> createOreDrop(ModBlocks.ZAFFIRO_MINERALE_END.get(), ModItems.ZAFFIRO_PURO.get()));
    }
    //per creare un metodo custom, click centrale su createOreDrop() e puoi fare copy-paste dalla classe.



    @Override
    protected Iterable<Block> getKnownBlocks() {
        //in pratica, controlla i blocchi che hanno o non hanno la Loot Table, per non avere una Loot Table usare il metodo .noLootTable() alla creazione.
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
