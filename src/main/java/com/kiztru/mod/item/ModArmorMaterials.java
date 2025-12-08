package com.kiztru.mod.item;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> AETHER_CRYSTAL_ARMOR_MATERIAL = registerArmorMaterial("aether_crystal",
            () -> new ArmorMaterial
            (Util.make(new EnumMap<>(ArmorItem.Type.class), map ->{
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 12);
            }),
            25, // Enchantability
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.AETHER_CRYSTAL),
                    List.of(new ArmorMaterial.Layer(Identifier.of(KiztrusMod.MOD_ID,"aether_crystal"))),
                    2.0F, // toughness
                      0.2F)); // knock back Resistance


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial (String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL,
                Identifier.of(KiztrusMod.MOD_ID,name), material.get());
    }






}
