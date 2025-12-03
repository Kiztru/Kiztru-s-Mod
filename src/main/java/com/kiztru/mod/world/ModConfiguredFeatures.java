package com.kiztru.mod.world;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {
    // Configured Feature --> Placed Feature --> World Generation / Biome Modification
    // What does it look like? --> How is it going to be placed? --> Where is it going to place?

    // Register any configured feature
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

    }


    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(KiztrusMod.MOD_ID, name));
}

    private static <FC extends FeatureConfig, F extends Feature<FC>>
    void register(Registerable<ConfiguredFeature<?,?>> context,
                  RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration){
     context.register(key,new ConfiguredFeature<>(feature,configuration));
    }
}
