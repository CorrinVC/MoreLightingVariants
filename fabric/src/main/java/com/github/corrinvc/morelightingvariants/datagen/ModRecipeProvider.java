package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
//                VanillaRecipeProvider

                // COPPER JACK O'LANTERN
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_JACK_O_LANTERN)
                        .pattern("P").pattern("t")
                        .define('P', Blocks.CARVED_PUMPKIN)
                        .define('t', Items.COPPER_TORCH)
                        .unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.COPPER_TORCH), has(Items.COPPER_TORCH))
                        .save(this.output);

                // SOUL JACK O'LANTERN
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_JACK_O_LANTERN)
                        .pattern("P").pattern("t")
                        .define('P', Blocks.CARVED_PUMPKIN)
                        .define('t', Items.SOUL_TORCH)
                        .unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.SOUL_TORCH), has(Items.SOUL_TORCH))
                        .save(this.output);

                // COPPER CAMPFIRE
                shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_CAMPFIRE)
                        .pattern(" s ")
                        .pattern("scs")
                        .pattern("LLL")
                        .define('c', Items.COPPER_INGOT)
                        .define('L', ItemTags.LOGS)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(this.output);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
