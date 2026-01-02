package com.github.corrinvc.morelightingvariants;


import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.github.corrinvc.morelightingvariants.registries.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class MoreLightingVariantsNeo {

    public static IEventBus modEventBus;

    public MoreLightingVariantsNeo(IEventBus eventBus) {

        modEventBus = eventBus;

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        bind(Registries.BLOCK, ModBlocks::register);
        bind(Registries.ITEM, ModItems::register);

        modEventBus.addListener(this::addToCreativeTabs);

        //CarvedPumpkinBlock.
    }

    /** Adapted from <a href="https://github.com/VazkiiMods/Botania">Botania</a> */
    private static <T> void bind(
            ResourceKey<? extends Registry<T>> registry,
            Consumer<BiConsumer<T, ResourceKey<T>>> source) {
        modEventBus.addListener((RegisterEvent event) -> {
            if(registry.equals(event.getRegistryKey())) {
                source.accept((t, key) ->
                        event.register(registry, key.location(), () -> t));
            }
        });
    }

    private void addToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.COPPER_JACK_O_LANTERN);
            event.accept(ModBlocks.SOUL_JACK_O_LANTERN);
        } else if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.COPPER_CAMPFIRE);
        }
    }

    @EventBusSubscriber(modid = Constants.MOD_ID)
    static class EventHandler {

        @SubscribeEvent
        public static void onBlockEntityTypeAddBlocksEvent(BlockEntityTypeAddBlocksEvent event) {
            event.modify(BlockEntityType.CAMPFIRE, ModBlocks.COPPER_CAMPFIRE);
        }

    }

    @EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
    static class ClientEventHandler {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_CAMPFIRE, ChunkSectionLayer.CUTOUT);
        }

    }

}