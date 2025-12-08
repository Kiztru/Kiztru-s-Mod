package com.kiztru.mod.datagen;

import com.kiztru.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        // For full tools enchantables
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.AETHER_CRYSTAL_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.AETHER_CRYSTAL_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.AETHER_CRYSTAL_HOE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.AETHER_CRYSTAL_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.AETHER_CRYSTAL_SHOVEL);

        // For full Armor enchantables
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.AETHER_CRYSTAL_HELMET)
                .add(ModItems.AETHER_CRYSTAL_CHESTPLATE)
                .add(ModItems.AETHER_CRYSTAL_LEGGINGS)
                .add(ModItems.AETHER_CRYSTAL_BOOTS);

        // For Trimming features
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AETHER_CRYSTAL_HELMET)
                .add(ModItems.AETHER_CRYSTAL_CHESTPLATE)
                .add(ModItems.AETHER_CRYSTAL_LEGGINGS)
                .add(ModItems.AETHER_CRYSTAL_BOOTS);
    }
}
