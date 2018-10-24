package ebm.com.mce.models.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelErythonCube extends ModelBase {
	// fields
	ModelRenderer Head;

	public ModelErythonCube() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 3, 3, 3);
		Head.setRotationPoint(5F, 20F, -7F);
		Head.setTextureSize(128, 128);
		Head.mirror = true;
		//setRotation(Head, -0.2974289F, -0.4461433F, 0F);
		setRotation(Head, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
	}

	public void renderModel(float f5) {
		Head.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
