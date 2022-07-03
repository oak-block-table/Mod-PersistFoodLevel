package org.hexagonalmagmacube.persistfoodlevel;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

// Question: Use import net.minecraft.server.network.ServerPlayerEntity; instead of
//import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.world.damagesource.DamageSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistFoodLevelMod implements ModInitializer {
	public static final String MOD_NAME = "PersistFoodLevel";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info(MOD_NAME + ": Executing the Initialize method.");

		registerEvents();
	}

	private void registerEvents() {

		ServerPlayerEvents.AFTER_RESPAWN.register((ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) -> {
			RespawnEvent.afterRespawn(oldPlayer, newPlayer, alive);
		});
	}
}
