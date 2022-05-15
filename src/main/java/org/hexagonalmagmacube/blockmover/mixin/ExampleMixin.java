package org.hexagonalmagmacube.blockmover.mixin;

import net.minecraft.block.Block;
import org.hexagonalmagmacube.blockmover.BlockMoverMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		BlockMoverMod.LOGGER.info("This line is printed by the block mover mixin!");
	}
}
