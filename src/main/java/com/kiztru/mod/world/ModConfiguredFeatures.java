package com.kiztru.mod.world;

import com.kiztru.mod.KiztrusMod;
import com.kiztru.mod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    // Configured Feature --> Placed Feature --> World Generation / Biome Modification
    // What does it look like? --> How is it going to be placed? --> Where is it going to place?

    public static final RegistryKey<ConfiguredFeature<?, ?>> AETHER_CRYSTAL_ORE_KEY = registryKey("aether_crystal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FIRE_CRYSTAL_ORE_KEY = registryKey("nether_fire_crystal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_CHAOS_CRYSTAL_ORE_KEY = registryKey("end_chaos_crystal_ore");

    // Register any configured feature
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        // Replaces blocks within the these tags or specified block
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldAetherCrystalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.AETHER_CRYSTAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_AETHER_CRYSTAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherAetherCrystalOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_FIRE_CRYSTAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endAetherCrystalOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_CHAOS_CRYSTAL_ORE.getDefaultState()));

        register(context, AETHER_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAetherCrystalOres, 10,0.8F));
        register(context, NETHER_FIRE_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherAetherCrystalOres, 8,0.5F));
        register(context, END_CHAOS_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(endAetherCrystalOres, 6,0.6F));
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
