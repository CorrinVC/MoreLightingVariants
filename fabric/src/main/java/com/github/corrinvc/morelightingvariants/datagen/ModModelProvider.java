package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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

        copyCandleAndCandleCakeModels(blockStateModelGenerator,
                ModBlocks.COPPER_CANDLE, ModBlocks.WAXED_COPPER_CANDLE,
                ModBlocks.COPPER_CANDLE_CAKE, ModBlocks.WAXED_COPPER_CANDLE_CAKE
        );
        copyCandleAndCandleCakeModels(blockStateModelGenerator,
                ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.WAXED_EXPOSED_COPPER_CANDLE,
                ModBlocks.EXPOSED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_EXPOSED_COPPER_CANDLE_CAKE
        );
        copyCandleAndCandleCakeModels(blockStateModelGenerator,
                ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.WAXED_WEATHERED_COPPER_CANDLE,
                ModBlocks.WEATHERED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_WEATHERED_COPPER_CANDLE_CAKE
        );
        copyCandleAndCandleCakeModels(blockStateModelGenerator,
                ModBlocks.OXIDIZED_COPPER_CANDLE, ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE,
                ModBlocks.OXIDIZED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE_CAKE
        );
    }

    private void copyCandleAndCandleCakeModels(BlockModelGenerators generator,
            Block sourceCandle, Block targetCandle, Block sourceCandleCake, Block targetCandleCake) {
        MultiVariant variant1 = BlockModelGenerators.plainVariant(
                ModelTemplates.CANDLE.getDefaultModelLocation(sourceCandle).withSuffix("_one_candle"));
        MultiVariant variant2 = BlockModelGenerators.plainVariant(
                ModelTemplates.TWO_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_two_candles"));
        MultiVariant variant3 = BlockModelGenerators.plainVariant(
                ModelTemplates.THREE_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_three_candles"));
        MultiVariant variant4 = BlockModelGenerators.plainVariant(
                ModelTemplates.FOUR_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_four_candles"));
        MultiVariant variant5 = BlockModelGenerators.plainVariant(
                ModelTemplates.CANDLE.getDefaultModelLocation(sourceCandle).withSuffix("_one_candle_lit"));
        MultiVariant variant6 = BlockModelGenerators.plainVariant(
                ModelTemplates.TWO_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_two_candles_lit"));
        MultiVariant variant7 = BlockModelGenerators.plainVariant(
                ModelTemplates.THREE_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_three_candles_lit"));
        MultiVariant variant8 = BlockModelGenerators.plainVariant(
                ModelTemplates.FOUR_CANDLES.getDefaultModelLocation(sourceCandle).withSuffix("_four_candles_lit"));
        generator.itemModelOutput.copy(sourceCandle.asItem(), targetCandle.asItem());
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(targetCandle).with(
                PropertyDispatch.initial(BlockStateProperties.CANDLES, BlockStateProperties.LIT).select(
                        1, false, variant1).select(
                        2, false, variant2).select(
                        3, false, variant3).select(
                        4, false, variant4).select(
                        1, true, variant5).select(
                        2, true, variant6).select(
                        3, true, variant7).select(
                        4, true, variant8)));
        MultiVariant variant9 = BlockModelGenerators.plainVariant(
                ModelTemplates.CANDLE_CAKE.getDefaultModelLocation(sourceCandleCake));
        MultiVariant variant10 = BlockModelGenerators.plainVariant(
                ModelTemplates.CANDLE_CAKE.getDefaultModelLocation(sourceCandleCake).withSuffix("_lit"));
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(targetCandleCake).with(
                BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, variant10, variant9)));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {  }

}
