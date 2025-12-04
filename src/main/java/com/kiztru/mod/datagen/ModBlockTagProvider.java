package com.kiztru.mod.datagen;

import com.kiztru.mod.block.ModBlocks;
import com.kiztru.mod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);

    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.AETHER_CRYSTAL_ORE)
                .add(ModBlocks.BLOCK_OF_AETHER)
                .add(ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE)
                .add(ModBlocks.RAW_BLOCK_OF_AETHER)

                .add(ModBlocks.BLOCK_OF_FIRE)
                .add(ModBlocks.RAW_BLOCK_OF_FIRE)
                .add(ModBlocks.NETHER_FIRE_CRYSTAL_ORE)

                .add(ModBlocks.BLOCK_OF_CHAOS)
                .add(ModBlocks.RAW_BLOCK_OF_CHAOS)
                .add(ModBlocks.END_CHAOS_CRYSTAL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AETHER_CRYSTAL_ORE)
                .add(ModBlocks.BLOCK_OF_AETHER)
                .add(ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE)
                .add(ModBlocks.RAW_BLOCK_OF_AETHER)

                .add(ModBlocks.NETHER_FIRE_CRYSTAL_ORE)
                .add(ModBlocks.BLOCK_OF_FIRE)
                .add(ModBlocks.RAW_BLOCK_OF_FIRE)

                .add(ModBlocks.END_CHAOS_CRYSTAL_ORE)
                .add(ModBlocks.BLOCK_OF_CHAOS)
                .add(ModBlocks.RAW_BLOCK_OF_CHAOS);

        // Aether Crystal tools can mine Diamond items
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_AETHER_CRYSTAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

    }
}
