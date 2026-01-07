package com.github.corrinvc.morelightingvariants.registries;

import com.github.corrinvc.morelightingvariants.Constants;
import com.github.corrinvc.morelightingvariants.platform.Services;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

import java.util.function.BiConsumer;

public class ModParticles {

    public static final ResourceKey<ParticleType<?>> COPPER_FLAME_KEY =
            Constants.makeKey(Registries.PARTICLE_TYPE, "copper_flame");

    public static final SimpleParticleType COPPER_FLAME = Services.PLATFORM.getSimpleParticleType(false);

    public static void register(BiConsumer<ParticleType<?>, ResourceKey<ParticleType<?>>> consumer) {
        consumer.accept(COPPER_FLAME, COPPER_FLAME_KEY);
    }

}
