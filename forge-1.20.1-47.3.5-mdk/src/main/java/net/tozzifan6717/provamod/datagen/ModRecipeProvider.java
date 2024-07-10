package net.tozzifan6717.provamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tozzifan6717.provamod.Item.ModItems;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.ModBlocks;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    //lista di zaffiri smeltabili:
    private static final List<ItemLike> ZAFFIRO_SMELTABILI = List.of(
            ModItems.ZAFFIRO_PURO.get(),
            ModBlocks.ZAFFIRO_MINERALE.get(),
            ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get(),
            ModBlocks.ZAFFIRO_MINERALE_NETHER.get(),
            ModBlocks.ZAFFIRO_MINERALE_END.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //ricette di Smelting e di Blasting:
        oreSmelting(pWriter, ZAFFIRO_SMELTABILI, RecipeCategory.MISC, ModItems.ZAFFIRO.get(), 0.25f, 200, "zaffiro");
        oreBlasting(pWriter, ZAFFIRO_SMELTABILI, RecipeCategory.MISC, ModItems.ZAFFIRO.get(), 0.25f, 100, "zaffiro");

        //ricette di Crafting:
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZAFFIRO_BLOCCO.get())
                //pattern sulla Crafting Table:
                .pattern("ZZZ")
                .pattern("ZZZ")
                .pattern("ZZZ")
                //cosa vogliono dire i Simboli: (le Key)
                .define('Z', ModItems.ZAFFIRO.get())
                //quando viene sbloccata la ricetta:
                .unlockedBy(getHasName(ModItems.ZAFFIRO.get()), has(ModItems.ZAFFIRO.get()))
                //da mettere sempre:
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR.get())
                //pattern sulla Crafting Table:
                .pattern("  i")
                .pattern(" i/")
                .pattern("cR ")
                //cosa vogliono dire i Simboli: (le Key)
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .define('c', Items.COPPER_INGOT)
                .define('R', Items.REDSTONE)
                //quando viene sbloccata la ricetta:
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                //da mettere sempre:
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZAFFIRO.get(), 9)
                .requires(ModBlocks.ZAFFIRO_BLOCCO.get())
                .unlockedBy(getHasName(ModBlocks.ZAFFIRO_BLOCCO.get()), has(ModBlocks.ZAFFIRO_BLOCCO.get()))
                .save(pWriter);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, ProvaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
