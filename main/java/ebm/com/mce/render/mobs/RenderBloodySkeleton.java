package ebm.com.mce.render.mobs;

import ebm.com.mce.entity.mobs.EntityBloodySkeleton;
import ebm.com.mce.entity.mobs.EntityErython;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBloodySkeleton extends RenderLiving {
	private static final ResourceLocation mobTexture = new ResourceLocation("mod_ebm",
			"/textures/entity/mob/skeleton_bloody.png".substring(1));

	public RenderBloodySkeleton(ModelBase base, float shadow) {
		super(base, shadow);
	}

	protected ResourceLocation getEntityTexture(EntityBloodySkeleton entity) {
		return mobTexture;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityBloodySkeleton) entity);
	}
}
