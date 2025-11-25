package com.kiztru.mod.datagen;

import com.kiztru.mod.block.ModBlocks;
import com.kiztru.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override   // Generation of Block state json file, Block Model json files, Item json files.
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AETHER_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_AETHER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLOCK_OF_AETHER);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHER_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHER_CLUSTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCHON_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REMEMBER_US_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.MY_PEOPLE_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_SWORD, Models.HANDHELD);

    }
}
