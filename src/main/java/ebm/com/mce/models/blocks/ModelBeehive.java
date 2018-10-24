package ebm.com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBeehive extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape5;
	ModelRenderer Shape6;

	public ModelBeehive() {
		textureWidth = 256;
		textureHeight = 256;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 6, 1, 6);
		Shape1.setRotationPoint(-3F, 23F, -3F);
		Shape1.setTextureSize(256, 256);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 10);
		Shape2.addBox(0F, 0F, 0F, 8, 2, 8);
		Shape2.setRotationPoint(-4F, 21F, -4F);
		Shape2.setTextureSize(256, 256);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 25);
		Shape3.addBox(0F, 0F, 0F, 6, 2, 6);
		Shape3.setRotationPoint(-3F, 19F, -3F);
		Shape3.setTextureSize(256, 256);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 35);
		Shape5.addBox(0F, 0F, 0F, 4, 1, 4);
		Shape5.setRotationPoint(-2F, 18F, -2F);
		Shape5.setTextureSize(256, 256);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 43);
		Shape6.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape6.setRotationPoint(-1F, 17F, -1F);
		Shape6.setTextureSize(256, 256);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
	}

	public void render(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(e, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, e);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
