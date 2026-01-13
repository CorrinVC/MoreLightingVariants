package com.github.corrinvc.morelightingvariants.platform;

import com.github.corrinvc.morelightingvariants.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public CarvedPumpkinBlock getCarvedPumpkinBlock(BlockBehaviour.Properties properties) {
        return new CarvedPumpkinBlock(properties);
    }

}
