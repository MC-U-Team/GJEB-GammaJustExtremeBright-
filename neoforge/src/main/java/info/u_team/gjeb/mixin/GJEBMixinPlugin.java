package info.u_team.gjeb.mixin;

import java.util.stream.Stream;

import net.neoforged.fml.loading.LoadingModList;

public class GJEBMixinPlugin extends GJEBAbstractMixinPlugin {
	
	@Override
	protected boolean modLoaded(String... mods) {
		return Stream.of(mods).anyMatch(mod -> LoadingModList.get().getModFileById(mod) != null);
	}
	
}
