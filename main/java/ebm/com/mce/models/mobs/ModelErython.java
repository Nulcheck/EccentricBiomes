package ebm.com.mce.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelErython extends ModelBase {
	// fields
	ModelRenderer Head;
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;

	public ModelErython() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 3, 3, 3);
		Head.setRotationPoint(-1F, 13F, -2F);
		Head.setTextureSize(128, 128);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 13, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape1.setRotationPoint(2F, 12F, 1F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 13, 0);
		Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape2.setRotationPoint(-2F, 12F, 1F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 13, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape3.setRotationPoint(2F, 13F, -3F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 13, 0);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape4.setRotationPoint(-2F, 13F, -3F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 13, 0);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape5.setRotationPoint(0F, 16F, 0F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 13, 0);
		Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape6.setRotationPoint(-1F, 18F, -1F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 13, 0);
		Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape7.setRotationPoint(1F, 19F, 1F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/*
	 * public void setRotationAngles(float f, float f1, float f2, float f3,
	 * float f4, float f5, Entity entity) { super.setRotationAngles(f, f1, f2,
	 * f3, f4, f5, entity); }
	 */

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		float f6 = f2 * (float) Math.PI * -0.1F;
		int i;

		for (i = 0; i < 4; ++i) {
			this.Shape1.rotationPointY = 11.0F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape1.rotationPointX = MathHelper.cos(f6) * 5.0F;
			this.Shape1.rotationPointZ = MathHelper.cos(f6) * 5.0F;

			this.Shape2.rotationPointY = 5.0F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape2.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape2.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape3.rotationPointY = 1F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape3.rotationPointX = MathHelper.sin(f6) * 5.0F;
			this.Shape3.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape4.rotationPointY = -5F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape4.rotationPointX = MathHelper.cos(f6) * 2.0F;
			this.Shape4.rotationPointZ = MathHelper.sin(f6) * -2.0F;

			this.Shape5.rotationPointY = 2.5F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape5.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape5.rotationPointZ = MathHelper.abs(f6) * 5.0F;

			this.Shape6.rotationPointY = -8F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape6.rotationPointX = MathHelper.abs(f6) * 5.0F;
			this.Shape6.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape7.rotationPointY = -6F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape7.rotationPointX = MathHelper.sin(f6) * -5.0F;
			this.Shape7.rotationPointZ = MathHelper.sin(f6) * 5.0F;
			++f6;
		}

		f6 = ((float) Math.PI / 4F) + f2 * (float) Math.PI * 0.03F;

		for (i = 4; i < 8; ++i) {
			this.Shape1.rotationPointY = 11.0F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape1.rotationPointX = MathHelper.cos(f6) * 5.0F;
			this.Shape1.rotationPointZ = MathHelper.cos(f6) * 5.0F;

			this.Shape2.rotationPointY = 5.0F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape2.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape2.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape3.rotationPointY = 1F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape3.rotationPointX = MathHelper.sin(f6) * 5.0F;
			this.Shape3.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape4.rotationPointY = -5F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape4.rotationPointX = MathHelper.cos(f6) * 2.0F;
			this.Shape4.rotationPointZ = MathHelper.sin(f6) * -2.0F;

			this.Shape5.rotationPointY = 2.5F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape5.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape5.rotationPointZ = MathHelper.abs(f6) * 5.0F;

			this.Shape6.rotationPointY = -8F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape6.rotationPointX = MathHelper.abs(f6) * 5.0F;
			this.Shape6.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape7.rotationPointY = -6F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape7.rotationPointX = MathHelper.sin(f6) * -5.0F;
			this.Shape7.rotationPointZ = MathHelper.sin(f6) * 5.0F;
			++f6;
		}

		f6 = 0.47123894F + f2 * (float) Math.PI * -0.05F;

		for (i = 8; i < 12; ++i) {
			this.Shape1.rotationPointY = 11.0F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape1.rotationPointX = MathHelper.cos(f6) * 5.0F;
			this.Shape1.rotationPointZ = MathHelper.cos(f6) * 5.0F;

			this.Shape2.rotationPointY = 5.0F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape2.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape2.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape3.rotationPointY = 1F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape3.rotationPointX = MathHelper.sin(f6) * 5.0F;
			this.Shape3.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape4.rotationPointY = -5F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape4.rotationPointX = MathHelper.cos(f6) * 2.0F;
			this.Shape4.rotationPointZ = MathHelper.sin(f6) * -2.0F;

			this.Shape5.rotationPointY = 2.5F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape5.rotationPointX = MathHelper.cos(f6) * -5.0F;
			this.Shape5.rotationPointZ = MathHelper.abs(f6) * 5.0F;

			this.Shape6.rotationPointY = -8F + MathHelper.cos(((float) i * 1.5F + f2) * 0.5F);
			this.Shape6.rotationPointX = MathHelper.abs(f6) * 5.0F;
			this.Shape6.rotationPointZ = MathHelper.sin(f6) * -5.0F;

			this.Shape7.rotationPointY = -6F + MathHelper.cos(((float) i * 1.5F - f2) * 0.5F);
			this.Shape7.rotationPointX = MathHelper.sin(f6) * -5.0F;
			this.Shape7.rotationPointZ = MathHelper.sin(f6) * 5.0F;
			++f6;
		}

		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Head.offsetY = -.75f;
		this.Shape5.isHidden = true;
		this.Shape6.isHidden = true;
	}
}
