package org.hexagonalmagmacube.blockmover;

import net.minecraft.server.network.ServerPlayerEntity;

public class RespawnEvent {
    // TODO: Move configuration parameters to a config file
    private static float DefaultInitialHealth = 10.0f;
    private static int MinimumInitialFoodLevel = 2;

    public static void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (oldPlayer instanceof ServerPlayerEntity == false) {
            BlockMoverMod.LOGGER.info("Old player is not an instance of ServerPlayerEntity.");
            return;
        }
        int foodLevel = oldPlayer.getHungerManager().getFoodLevel();
        foodLevel = Integer.max(foodLevel, MinimumInitialFoodLevel);
        BlockMoverMod.LOGGER.info(String.format("Food level will be reset to: %d", foodLevel));
        newPlayer.getHungerManager().setFoodLevel(foodLevel);

        newPlayer.setHealth(DefaultInitialHealth);
    }
}
