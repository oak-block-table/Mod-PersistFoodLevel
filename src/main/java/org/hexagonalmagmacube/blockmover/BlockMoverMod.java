package org.hexagonalmagmacube.blockmover;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

// Question: Use import net.minecraft.server.network.ServerPlayerEntity; instead of
// import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.world.damagesource.DamageSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockMoverMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("PersistFoodLevel");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Executing Block Mover Initialize method.");

		registerEvents();
	}

	private void registerEvents() {
//		ServerPlayerEvents.ALLOW_DEATH.register((ServerPlayer player, DamageSource damageSource, float damageAmount) -> {
//			return RespawnEvent.onPlayerDeath(player, damageSource, damageAmount);
//		});

		ServerPlayerEvents.AFTER_RESPAWN.register((ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) -> {
			RespawnEvent.afterRespawn(oldPlayer, newPlayer, alive);
		});
	}
}
