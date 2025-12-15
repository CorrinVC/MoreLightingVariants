package com.github.corrinvc.morelightingvariants;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "morelightingvariants";
	public static final String MOD_NAME = "MoreLightingVariants";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static <T> ResourceKey<T> makeKey(ResourceKey<? extends Registry<T>> registry, String name) {
		return ResourceKey.create(registry, make(name));
	}

	public static ResourceLocation make(String name) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
	}
}