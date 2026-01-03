package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Blocks;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createPumpkinVariant(ModBlocks.COPPER_JACK_O_LANTERN, TextureMapping.column(Blocks.PUMPKIN));
        blockStateModelGenerator.createPumpkinVariant(ModBlocks.SOUL_JACK_O_LANTERN, TextureMapping.column(Blocks.PUMPKIN));

        // TEMPORARY -- NEEDS TESTING
        blockStateModelGenerator.createCampfires(ModBlocks.COPPER_CAMPFIRE);

        blockStateModelGenerator.createCandleAndCandleCake(ModBlocks.COPPER_CANDLE, ModBlocks.COPPER_CANDLE_CAKE);
        blockStateModelGenerator.createCandleAndCandleCake(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE_CAKE);
        blockStateModelGenerator.createCandleAndCandleCake(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.WEATHERED_COPPER_CANDLE_CAKE);
        blockStateModelGenerator.createCandleAndCandleCake(ModBlocks.OXIDIZED_COPPER_CANDLE, ModBlocks.OXIDIZED_COPPER_CANDLE_CAKE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {  }

}
