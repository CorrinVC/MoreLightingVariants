package com.github.corrinvc.morelightingvariants.registries;

import com.github.corrinvc.morelightingvariants.Constants;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

public class ModItems {

    public static final ResourceKey<Item> COPPER_JACK_O_LANTERN_KEY =
            blockItemKey(ModBlocks.COPPER_JACK_O_LANTERN_KEY);
    public static final ResourceKey<Item> SOUL_JACK_O_LANTERN_KEY =
            blockItemKey(ModBlocks.SOUL_JACK_O_LANTERN_KEY);
    public static final ResourceKey<Item> COPPER_CAMPFIRE_KEY =
            blockItemKey(ModBlocks.COPPER_CAMPFIRE_KEY);

    public static final ResourceKey<Item> COPPER_CANDLE_KEY =
            blockItemKey(ModBlocks.COPPER_CANDLE_KEY);
    public static final ResourceKey<Item> EXPOSED_COPPER_CANDLE_KEY =
            blockItemKey(ModBlocks.EXPOSED_COPPER_CANDLE_KEY);
    public static final ResourceKey<Item> WEATHERED_COPPER_CANDLE_KEY =
            blockItemKey(ModBlocks.WEATHERED_COPPER_CANDLE_KEY);

    public static final Item COPPER_JACK_O_LANTERN = createBlockItem(
            ModBlocks.COPPER_JACK_O_LANTERN, COPPER_JACK_O_LANTERN_KEY
    );
    public static final Item SOUL_JACK_O_LANTERN = createBlockItem(
            ModBlocks.SOUL_JACK_O_LANTERN, SOUL_JACK_O_LANTERN_KEY
    );
    public static final Item COPPER_CAMPFIRE = createBlockItem(
            ModBlocks.COPPER_CAMPFIRE,
            new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY),
            COPPER_CAMPFIRE_KEY
    );

    public static final Item COPPER_CANDLE = createBlockItem(
            ModBlocks.COPPER_CANDLE, COPPER_CANDLE_KEY
    );
    public static final Item EXPOSED_COPPER_CANDLE = createBlockItem(
            ModBlocks.EXPOSED_COPPER_CANDLE, EXPOSED_COPPER_CANDLE_KEY
    );
    public static final Item WEATHERED_COPPER_CANDLE = createBlockItem(
            ModBlocks.WEATHERED_COPPER_CANDLE, WEATHERED_COPPER_CANDLE_KEY
    );

    private static Item createBlockItem(Block block, ResourceKey<Item> id) {
        return createBlockItem(block, new Item.Properties(), id);
    }

    private static Item createBlockItem(Block block, Item.Properties properties, ResourceKey<Item> id) {
        return new BlockItem(block, properties.setId(id).useBlockDescriptionPrefix());
    }

    public static void register(BiConsumer<Item, ResourceKey<Item>> consumer) {
        consumer.accept(COPPER_JACK_O_LANTERN, COPPER_JACK_O_LANTERN_KEY);
        consumer.accept(SOUL_JACK_O_LANTERN, SOUL_JACK_O_LANTERN_KEY);
        consumer.accept(COPPER_CAMPFIRE, COPPER_CAMPFIRE_KEY);
        consumer.accept(COPPER_CANDLE, COPPER_CANDLE_KEY);
        consumer.accept(EXPOSED_COPPER_CANDLE, EXPOSED_COPPER_CANDLE_KEY);
        consumer.accept(WEATHERED_COPPER_CANDLE, WEATHERED_COPPER_CANDLE_KEY);
    }

    private static ResourceKey<Item> itemKey(String name) {
        return Constants.makeKey(Registries.ITEM, name);
    }

    private static ResourceKey<Item> blockItemKey(ResourceKey<Block> blockKey) {
        return itemKey(blockKey.location().getPath());
    }
}
