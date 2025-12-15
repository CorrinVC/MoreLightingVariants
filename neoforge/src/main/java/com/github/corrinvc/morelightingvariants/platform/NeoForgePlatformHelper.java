package com.github.corrinvc.morelightingvariants.platform;

import com.github.corrinvc.morelightingvariants.Constants;
import com.github.corrinvc.morelightingvariants.MoreLightingVariantsNeo;
import com.github.corrinvc.morelightingvariants.platform.services.IPlatformHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.util.function.Function;

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