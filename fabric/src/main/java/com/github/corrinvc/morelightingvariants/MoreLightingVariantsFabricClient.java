package com.github.corrinvc.morelightingvariants;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.github.corrinvc.morelightingvariants.registries.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MoreLightingVariantsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.COPPER_CAMPFIRE, ChunkSectionLayer.CUTOUT);
        ParticleFactoryRegistry.getInstance().register(ModParticles.COPPER_FLAME, FlameParticle.SmallFlameProvider::new);
    }
}
