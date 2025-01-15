package info.u_team.gjeb.mixin;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import info.u_team.gjeb.asm.integration.sodium.SodiumGameOptionPagesAsm;

public abstract class GJEBAbstractMixinPlugin implements IMixinConfigPlugin {
	
	public static final String SODIUM_CLASS = "net.caffeinemc.mods.sodium.client.gui.SodiumGameOptionPages";
	
	@Override
	public void onLoad(String mixinPackage) {
	}
	
	@Override
	public String getRefMapperConfig() {
		return null;
	}
	
	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		return true;
	}
	
	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
	}
	
	@Override
	public List<String> getMixins() {
		if (modLoaded("sodium", "rubidium", "embeddium")) {
			return List.of("integration.sodium.SodiumGameOptionPagesMixin");
		}
		return null;
	}
	
	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		if (targetClassName.equals(SODIUM_CLASS)) {
			SodiumGameOptionPagesAsm.asm(targetClass);
		}
	}
	
	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}
	
	protected abstract boolean modLoaded(String... mods);
	
}
