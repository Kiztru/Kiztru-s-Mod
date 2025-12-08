package com.kiztru.mod.datagen;

import com.kiztru.mod.block.ModBlocks;
import com.kiztru.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLOCK_OF_FIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_FIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FIRE_CRYSTAL_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLOCK_OF_CHAOS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_CHAOS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_CHAOS_CRYSTAL_ORE);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ELPIS,ModBlocks.POTTED_ELPIS, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override   // Generation of Item Models json files, GENERATED means normal item, Handheld used as a tool.
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHER_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHER_CLUSTER, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_CLUSTER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHAOS_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAOS_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAOS_CLUSTER, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARCHON_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REMEMBER_US_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.MY_PEOPLE_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AETHER_CRYSTAL_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AETHER_CRYSTAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AETHER_CRYSTAL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AETHER_CRYSTAL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AETHER_CRYSTAL_BOOTS));

    }
}
