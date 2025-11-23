package com.kiztru.mod.item;

import com.kiztru.mod.KiztrusMod;
import com.kiztru.mod.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    // Registering Items
    public static final Item AETHER_CRYSTAL =
            registerItem("aether_crystal", new Item(new Item.Settings()));

    public static final Item AETHER_ROD =
            registerItem("aether_rod", new Item(new Item.Settings()));

    public static final Item AETHER_CLUSTER =
            registerItem("aether_cluster", new Item(new Item.Settings()));

    public static final Item ARCHON_BREAD =
            registerItem("archon_bread", new  Item(new Item.Settings().food(ModFoodComponents.ARCHON_BREAD)){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasShiftDown()){
                        tooltip.add(Text.translatable("tooltip.kiztrusmod.archon_bread.shift_down"));
                        tooltip.add(Text.translatable("tooltip.kiztrusmod.archon_bread.shift_down.1"));
                        tooltip.add(Text.translatable("tooltip.kiztrusmod.archon_bread.shift_down.2"));
                    }
                    else {
                        tooltip.add(Text.translatable("tooltip.kiztrusmod.archon_bread"));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item REMEMBER_US_MUSIC_DISC = registerItem("remember_us_music_disc",
        new Item(new Item.Settings().jukeboxPlayable(ModSounds.REMEMBER_US_KEY).maxCount(1)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(KiztrusMod.MOD_ID, name),item);
    }

    // Adding Items onto the Creative Tab
    public static void registerModItems() {
        KiztrusMod.LOGGER.info("Registering Mod Items for " + KiztrusMod.MOD_ID);


        }
    }

