package com.kiztru.mod.datagen;

import com.kiztru.mod.block.ModBlocks;
import com.kiztru.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // Smelting List
        List<ItemConvertible> AETHER_SMELTABLES = List.of(ModItems.AETHER_CLUSTER, ModBlocks.AETHER_CRYSTAL_ORE,
                ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE);

        // Smelting Furnace
        offerSmelting(recipeExporter, AETHER_SMELTABLES, RecipeCategory.MISC,ModItems.AETHER_CLUSTER,
                1F,200,"aether_crystal");

        // Blasting Furnace
        offerBlasting(recipeExporter, AETHER_SMELTABLES, RecipeCategory.MISC,ModItems.AETHER_CLUSTER,
                1F,100,"aether_crystal");

        // 9 Aether Crystals = Block of Aether
        // Block of Aether = 9 Aether Crystals
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.AETHER_CRYSTAL,RecipeCategory.DECORATIONS, ModBlocks.BLOCK_OF_AETHER);

        // 9 Aether Clusters = Raw Block of Aether
        // Raw Block of Aether = 9 Aether Crystals
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.AETHER_CLUSTER,RecipeCategory.DECORATIONS, ModBlocks.RAW_BLOCK_OF_AETHER);


        // Aether Rod Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AETHER_ROD)
                .pattern("A")
                .pattern("Q")
                .pattern("S")
                .input('A', ModItems.AETHER_CRYSTAL)
                .input('Q', Items.QUARTZ)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.AETHER_CRYSTAL),conditionsFromItem(ModItems.AETHER_CRYSTAL))
                .criterion(hasItem(Items.QUARTZ),conditionsFromItem(Items.QUARTZ))
                .offerTo(recipeExporter);

        // Archon Bread Made with Cooked cod
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ARCHON_BREAD)
                .input(Items.CARROT)
                .input(Items.COOKED_COD)
                .input(Items.POTATO)
                .input(Items.WHEAT)
                .group("Archon")
                .criterion(hasItem(Items.COOKED_COD), conditionsFromItem(Items.COOKED_COD)) // When item in inventory
                .offerTo(recipeExporter, Identifier.of("archon_bread_cod"));            // Different IDs so no conflicts can happen during data generation

        // Archon Bread Made with Cooked Salmon
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ARCHON_BREAD)
                .input(Items.CARROT)
                .input(Items.COOKED_SALMON)
                .input(Items.POTATO)
                .input(Items.WHEAT)
                .group("Archon")
                .criterion(hasItem(Items.COOKED_COD), conditionsFromItem(Items.COOKED_COD))
                .offerTo(recipeExporter,Identifier.of("archon_bread_salmon"));

        // Aether Crystal Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AETHER_CRYSTAL_SWORD)
                .pattern("A")
                .pattern("G")
                .pattern("R")
                .input('A', ModItems.AETHER_CRYSTAL)
                .input('G', Items.GOLD_INGOT)
                .input('R', ModItems.AETHER_ROD)
                .criterion(hasItem(ModItems.AETHER_CRYSTAL),conditionsFromItem(ModItems.AETHER_CRYSTAL))
                .criterion(hasItem(ModItems.AETHER_ROD),conditionsFromItem(ModItems.AETHER_ROD))
                .criterion(hasItem(Items.GOLD_INGOT),conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter);

    }
}
