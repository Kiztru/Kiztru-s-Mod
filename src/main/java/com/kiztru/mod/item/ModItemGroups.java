package com.kiztru.mod.item;

import com.kiztru.mod.KiztrusMod;
import com.kiztru.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
public static final ItemGroup AETHER_CRYSTAL = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(KiztrusMod.MOD_ID, "aether_crystal"),
        FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AETHER_CRYSTAL))
                .displayName(Text.translatable("itemgroup.kiztrusmod.aether_crystal_items"))
                .entries((displayContext, entries) -> {

                    // Adding items/blocks to a custom creative tab
                    entries.add(ModBlocks.AETHER_CRYSTAL_ORE);
                    entries.add(ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE);
                    entries.add(ModBlocks.NETHER_FIRE_CRYSTAL_ORE);
                    entries.add(ModBlocks.END_CHAOS_CRYSTAL_ORE);

                    entries.add(ModItems.AETHER_CLUSTER);
                    entries.add(ModItems.FIRE_CLUSTER);
                    entries.add(ModItems.CHAOS_CLUSTER);

                    entries.add(ModBlocks.RAW_BLOCK_OF_AETHER);
                    entries.add(ModBlocks.RAW_BLOCK_OF_FIRE);
                    entries.add(ModBlocks.RAW_BLOCK_OF_CHAOS);

                    entries.add(ModItems.AETHER_CRYSTAL);
                    entries.add(ModItems.FIRE_CRYSTAL);
                    entries.add(ModItems.CHAOS_CRYSTAL);

                    entries.add(ModBlocks.BLOCK_OF_AETHER);
                    entries.add(ModBlocks.BLOCK_OF_FIRE);
                    entries.add(ModBlocks.BLOCK_OF_CHAOS);

                    entries.add(ModItems.AETHER_ROD);
                    entries.add(ModItems.FIRE_ROD);
                    entries.add(ModItems.CHAOS_ROD);

                    entries.add(ModItems.AETHER_CRYSTAL_SWORD);

                    entries.add(ModItems.REMEMBER_US_MUSIC_DISC);
                    entries.add(ModItems.MY_PEOPLE_MUSIC_DISC);

                    entries.add(ModItems.ARCHON_BREAD);

                    entries.add(ModBlocks.ELPIS);
                }).build());

    public static void registerItemGroups(){
        KiztrusMod.LOGGER.info("Registering Item Groups for " + KiztrusMod.MOD_ID + AETHER_CRYSTAL);
    }
}
