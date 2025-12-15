package com.github.corrinvc.morelightingvariants.mixin.block;

import net.minecraft.advancements.critereon.FishingRodHookedTrigger;
import net.minecraft.client.model.TadpoleModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.fog.environment.WaterFogEnvironment;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockEntityType.class)
public class MixinBlockEntityType {


//    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BlockEntityType;register(Ljava/lang/String;Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier;[Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/world/level/block/entity/BlockEntityType;", ordinal = ))
//    private static BlockEntityType adjustCampfireBlockEntityType(BlockEntityType campfireBlockEntity) {
//        ServerLevel
//        return null;
//    }

}
