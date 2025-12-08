package com.kiztru.mod.world;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures{
    public static final RegistryKey<PlacedFeature> AETHER_CRYSTAL_ORE_PLACED_KEY = registryKey("aether_crystal_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_FIRE_CRYSTAL_ORE_PLACED_KEY = registryKey("nether_fire_crystal_ore_placed");
    public static final RegistryKey<PlacedFeature> END_CHAOS_CRYSTAL_ORE_PLACED_KEY = registryKey("end_chaos_crystal_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,AETHER_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AETHER_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // For Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60 /*Minimum*/ ),YOffset.fixed(20 /*Maximum*/ ))));

        register(context,NETHER_FIRE_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_FIRE_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(5),YOffset.fixed(120))));

        register(context,END_CHAOS_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_CHAOS_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(20),YOffset.fixed(80))));

    }

    public static RegistryKey<PlacedFeature> registryKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(KiztrusMod.MOD_ID,name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature>key,
                                                                                   RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                                                                   PlacementModifier...modifiers){
        register(context,key,configuration,List.of(modifiers));
    }
}