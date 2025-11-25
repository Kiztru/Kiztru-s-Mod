package com.kiztru.mod.util;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> NEEDS_AETHER_CRYSTAL_TOOL = createTag("needs_aether_crystal_tool");
        public static final TagKey<Block> INCORRECT_FOR_AETHER_CRYSTAL_TOOL = createTag("incorrect_needs_aether_crystal_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(KiztrusMod.MOD_ID, name));

        }


        public static class Items {


            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(KiztrusMod.MOD_ID, name));
            }
        }
    }
}
