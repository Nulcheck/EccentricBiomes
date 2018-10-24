package ebm.com.mce.entity.fx;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityErythonFX extends EntityFX {
	float dustParticleScale;

	public EntityErythonFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
		this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
	}

	public EntityErythonFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
			float size) {
		super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
		this.motionX *= 0.10000000149011612D;
		this.motionY *= 0.25000000149011612D;
		this.motionZ *= 0.10000000149011612D;

		if (y == 0.0F) {
			y = 1.0F;
		}

		float f4 = (float) Math.random() * 0.2F + 0.6F;
		this.particleRed = (float) (((Math.random() * 0d) + 0f) * y * f4);
		this.particleGreen = (float) (((Math.random() * 0d) + 0f) * y * f4);
		this.particleBlue = (float) (((Math.random() * 0d) + 0f) * y * f4);
		this.particleScale *= 0.5F;
		this.particleScale *= x;
		this.dustParticleScale = this.particleScale;
		this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + .2D));
		this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
		this.noClip = false;
	}

	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6,
			float par7) {
		float f6 = ((float) this.particleAge + par2) / (float) this.particleMaxAge * 32.0F;

		if (f6 < 0.0F) {
			f6 = 0.0F;
		}

		if (f6 > 1.0F) {
			f6 = 1.0F;
		}

		this.particleScale = this.dustParticleScale * f6;
		super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}

		this.setParticleTextureIndex(1000 - this.particleAge * 8 / this.particleMaxAge);
		if (this.worldObj.isRemote) {
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		}

		if (this.posY == this.prevPosY) {
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}

		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}
}
