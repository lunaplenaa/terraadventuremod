package net.lunaplenaa.terraadventuremod.datagen;

import net.lunaplenaa.terraadventuremod.register.TerraAdventureBlocks;
import net.lunaplenaa.terraadventuremod.register.TerraAdventureItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class TerraAdventureRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public TerraAdventureRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TerraAdventureBlocks.MANGANESE_BLOCK.get())
                .pattern("MMM")
                .pattern("MWM")
                .pattern("MMM")
                .define('M', TerraAdventureItems.RAW_MANGANESE.get())
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_manganese", has(TerraAdventureItems.RAW_MANGANESE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TerraAdventureItems.RAW_MANGANESE.get(), 8)
                .requires(TerraAdventureBlocks.MANGANESE_BLOCK)
                .unlockedBy("has_manganese_block", has(TerraAdventureBlocks.MANGANESE_BLOCK)).save(recipeOutput);
    }
}
