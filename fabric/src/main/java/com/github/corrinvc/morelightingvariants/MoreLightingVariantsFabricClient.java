package com.github.corrinvc.morelightingvariants;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MoreLightingVariantsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.COPPER_CAMPFIRE, ChunkSectionLayer.CUTOUT);
    }
}
