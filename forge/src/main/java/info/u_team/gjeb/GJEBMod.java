package info.u_team.gjeb;

import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(GJEBMod.MODID)
public class GJEBMod {
	
	public static final String MODID = GJEBReference.MODID;
	
	public GJEBMod() {
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () -> new DisplayTest(() -> DisplayTest.IGNORESERVERONLY, (remoteVersion, network) -> true));
	}
	
}
