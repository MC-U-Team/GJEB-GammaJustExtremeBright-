package info.u_team.gjeb.asm.integration.sodium;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

public class SodiumGameOptionPagesAsm {
	
	private static Logger LOGGER = LogUtils.getLogger();
	
	private static final String SODIUM_CONTROLL_PACKAGE = "net/caffeinemc/mods/sodium/client/gui/options/control/";
	private static final String EMBEDDIUM_CONTROLL_PACKAGE = "org/embeddedt/embeddium/api/options/control/";
	
	public static void asm(ClassNode targetClass) {
		for (final MethodNode method : targetClass.methods) {
			for (final AbstractInsnNode ins : method.instructions) {
				if (ins instanceof final MethodInsnNode methodIns) {
					if (isBrightnessCall(methodIns, SODIUM_CONTROLL_PACKAGE) || isBrightnessCall(methodIns, EMBEDDIUM_CONTROLL_PACKAGE)) {
						final AbstractInsnNode node = ins.getPrevious().getPrevious(); // Find IntInsNode with 100 value
						
						if (node instanceof final IntInsnNode intInsNode) {
							intInsNode.setOpcode(Opcodes.SIPUSH);
							intInsNode.operand = 1000;
							LOGGER.debug("Inject gjeb into sodium guis");
						} else {
							LOGGER.warn("Cannot make sodium compatible with gjeb");
						}
					}
				}
			}
		}
	}
	
	private static boolean isBrightnessCall(MethodInsnNode methodIns, String basePackage) {
		return methodIns.getOpcode() == Opcodes.INVOKESTATIC && //
				methodIns.owner.equals(basePackage + "ControlValueFormatter") && //
				methodIns.name.equals("brightness") && //
				methodIns.desc.equals("()L" + basePackage + "ControlValueFormatter;");
	}
	
}
