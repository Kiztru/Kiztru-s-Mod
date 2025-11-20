package com.kiztru.mod.item;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Registering Items
    public static final Item AETHER_CRYSTAL =
            registerItem("aether_crystal", new Item(new Item.Settings()));

    public static final Item AETHER_ROD =
            registerItem("aether_rod", new Item(new Item.Settings()));

    public static final Item AETHER_CLUSTER =
            registerItem("aether_cluster", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(KiztrusMod.MOD_ID, name),item);
    }

    // Adding Items onto the Creative Tab
    public static void registerModItems() {
        KiztrusMod.LOGGER.info("Registering Mod Items for " + KiztrusMod.MOD_ID);


        }
    }

