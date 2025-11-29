package com.kiztru.mod;


import com.kiztru.mod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class KiztrusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ELPIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ELPIS, RenderLayer.getCutout());

    }
}
