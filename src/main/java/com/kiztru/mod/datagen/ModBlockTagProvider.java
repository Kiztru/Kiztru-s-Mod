package com.kiztru.mod.datagen;

import com.kiztru.mod.block.ModBlocks;
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
                .add(ModBlocks.RAW_BLOCK_OF_AETHER);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AETHER_CRYSTAL_ORE)
                .add(ModBlocks.BLOCK_OF_AETHER)
                .add(ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE)
                .add(ModBlocks.RAW_BLOCK_OF_AETHER);

    }
}
