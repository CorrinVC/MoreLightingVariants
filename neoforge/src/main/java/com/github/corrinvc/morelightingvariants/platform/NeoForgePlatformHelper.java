package com.github.corrinvc.morelightingvariants.platform;

import com.github.corrinvc.morelightingvariants.platform.services.IPlatformHelper;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public CarvedPumpkinBlock getCarvedPumpkinBlock(BlockBehaviour.Properties properties) {
        return new CarvedPumpkinBlock(properties);
    }
}