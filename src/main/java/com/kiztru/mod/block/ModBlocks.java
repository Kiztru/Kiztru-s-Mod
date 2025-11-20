package com.kiztru.mod.block;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLOCK_OF_AETHER = registerBlock("block_of_aether",
        new Block(AbstractBlock.Settings.
        create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_BLOCK_OF_AETHER = registerBlock("raw_block_of_aether",
        new Block(AbstractBlock.Settings.
        create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

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
