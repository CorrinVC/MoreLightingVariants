package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModParticles;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider {

    protected ModParticleDescriptionProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void addDescriptions() {
        spriteSet(ModParticles.COPPER_FLAME, ModParticles.COPPER_FLAME_KEY.location());
    }
}
