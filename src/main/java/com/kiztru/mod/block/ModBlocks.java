package com.kiztru.mod.block;

import com.kiztru.mod.KiztrusMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BLOCK_OF_AETHER = registerBlock("block_of_aether",
        new Block(AbstractBlock.Settings.
        create().strength(5.0F,6.0F).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_BLOCK_OF_AETHER = registerBlock("raw_block_of_aether",
        new Block(AbstractBlock.Settings.
        create().strength(5.0F,6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block AETHER_CRYSTAL_ORE = registerBlock("aether_crystal_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create().strength(3.0F,3.0F).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_AETHER_CRYSTAL_ORE = registerBlock("deepslate_aether_crystal_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                AbstractBlock.Settings.create().strength(4.5F,3.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block ELPIS = registerBlock("elpis",
            new FlowerBlock(StatusEffects.GLOWING,5.0F,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM)));

    public static final Block POTTED_ELPIS = registerBlock("potted_elpis",
            new FlowerPotBlock(ELPIS,
                    FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KiztrusMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(KiztrusMod.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        KiztrusMod.LOGGER.info("Registering Mod Blocks for " + KiztrusMod.MOD_ID);


    }
}
