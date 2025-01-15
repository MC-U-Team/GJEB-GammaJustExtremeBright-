package info.u_team.gjeb.mixin.integration.sodium;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

import info.u_team.gjeb.mixin.GJEBAbstractMixinPlugin;

@Pseudo
@Mixin(targets = { GJEBAbstractMixinPlugin.SODIUM_CLASS, GJEBAbstractMixinPlugin.EMBEDDIUM_CLASS })
abstract class SodiumGameOptionPagesMixin {
	
	@SuppressWarnings("unused")
	private static void gjeb_forceMixinApply() {
		System.out.println();
	}
	
}
