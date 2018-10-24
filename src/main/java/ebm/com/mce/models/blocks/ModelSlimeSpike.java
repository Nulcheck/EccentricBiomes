package ebm.com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSlimeSpike extends ModelBase {
	ModelRenderer Base;
	ModelRenderer Mid;
	ModelRenderer Tip;

	public ModelSlimeSpike() {
		textureWidth = 64; //x
		textureHeight = 32; //y

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(0f, 0f, 0f, 6, 2, 6);
		Base.setRotationPoint(-3f, 22f, -3f);
		Base.setTextureSize(64, 32);
		Base.mirror = true;
		setRotation(Base, 0f, 0f, 0f);
		
		Mid = new ModelRenderer(this, 0, 9);
		Mid.addBox(0f, 0f, 0f, 4, 4, 4);
		Mid.setRotationPoint(-2f, 18f,-2f);
		Mid.setTextureSize(64, 32);
		Mid.mirror = true;
		setRotation(Mid, 0f, 0f, 0f);
		
		Tip = new ModelRenderer(this, 0, 18);
		Tip.addBox(0f, 0f, 0f, 2, 4, 2);
		Tip.setRotationPoint(-1f, 14f, -1f);
		Tip.setTextureSize(64, 32);
		Tip.mirror = true;
		setRotation(Tip, 0f, 0f, 0f);
	}

	public void render(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(e, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, e);
		Base.render(f5);
		Mid.render(f5);
		Tip.render(f5);
	}

	public void renderModel(float f){
		Base.render(f);
		Mid.render(f);
		Tip.render(f);
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
