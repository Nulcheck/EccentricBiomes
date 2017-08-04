package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.EntityRegistry;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.mobs.EntityErython;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;

public class MobRegistry {
	// public static BiomeGenBase[] erythonBiomes = { BiomeRegistry.AutilField
	// };
	private static int entityID = 0;

	public static void preInit() {
		registerEntity(EntityErython.class, "Erython", 13, 4, 1, 20, 20, 20);
		spawnEntities();
	}

	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int bgRed, int bgGreen,
			int bgBlue, int fgRed, int fgGreen, int fgBlue) {
		EntityRegistry.registerGlobalEntityID(entityClass, "mod_ebm." + entityName,
				EntityRegistry.findGlobalUniqueEntityId(), getRGBInt(bgRed, bgGreen, bgBlue),
				getRGBInt(fgRed, fgGreen, fgBlue));
		registerEntity(entityClass, entityName);
	}

	private static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, mod_ebm.instance, 64, 3, true);
	}

	private static int getRGBInt(int rInt, int gInt, int bInt) {
		return (rInt << 16) + (gInt << 8) + bInt;
	}

	public static void spawnEntities() {
		EntityRegistry.addSpawn(EntityErython.class, 10, 2, 5, EnumCreatureType.creature, BiomeRegistry.AutilField);
	}
}
