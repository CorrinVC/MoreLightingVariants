package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class NeoDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModParticleDescriptionProvider::new);
    }

}
