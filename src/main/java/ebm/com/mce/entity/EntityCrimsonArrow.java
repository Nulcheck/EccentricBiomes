package ebm.com.mce.entity;

import java.util.List;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCrimsonArrow extends EntityArrow {
	private int targetX = -1;
	private int targetY = -1;
	private int targetZ = -1;
	private Block targetBlock;
	private int inData;
	private boolean inGround;
	private int ticksInGround;
	private int ticksInAir;
	private double damage = 2.0D;
	private int knockbackStrength;

	public EntityCrimsonArrow(World world) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
	}

	public EntityCrimsonArrow(World world, double x, double y, double z) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(x, y, z);
		this.yOffset = 0.0F;
	}

	public EntityCrimsonArrow(World world, EntityLivingBase entity, EntityLivingBase entity1, float dir, float motion) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = entity;

		if (entity instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}

		this.posY = entity.posY + (double) entity.getEyeHeight() - 0.10000000149011612D;
		double d0 = entity1.posX - entity.posX;
		double d1 = entity1.boundingBox.minY + (double) (entity1.height / 3.0F) - this.posY;
		double d2 = entity1.posZ - entity.posZ;
		double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);

		if (d3 >= 1.0E-7D) {
			float f2 = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			float f3 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(entity.posX + d4, this.posY, entity.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			float f4 = (float) d3 * 0.2F;
			this.setThrowableHeading(d0, d1 + (double) f4, d2, dir, motion);
		}
	}

	public EntityCrimsonArrow(World world, EntityLivingBase entity, float dir) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = entity;

		if (entity instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}

		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(entity.posX, entity.posY + (double) entity.getEyeHeight(), entity.posZ,
				entity.rotationYaw, entity.rotationPitch);
		this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI)
				* MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI)
				* MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, dir * 1.5F, 1.0F);
	}

	public void onUpdate() {
		super.onUpdate();

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D
					/ Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f) * 180.0D
					/ Math.PI);
		}

		Block block = this.worldObj.getBlock(this.targetX, this.targetY, this.targetZ);

		if (block.getMaterial() != Material.air) {
			block.setBlockBoundsBasedOnState(this.worldObj, this.targetX, this.targetY, this.targetZ);
			AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.targetX,
					this.targetY, this.targetZ);

			if (axisalignedbb != null
					&& axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
				this.inGround = true;
			}
		}

		if (this.arrowShake > 0) {
			--this.arrowShake;
		}

		if (this.inGround) {
			int j = this.worldObj.getBlockMetadata(this.targetX, this.targetY, this.targetZ);

			if (block == this.targetBlock && j == this.inData) {
				++this.ticksInGround;

				if (this.ticksInGround == 1200) {
					this.setDead();
				}
			} else {
				this.inGround = false;
				this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
		} else {
			++this.ticksInAir;
			Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);
			MovingObjectPosition obj = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
			vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);

			if (obj != null) {
				vec3 = Vec3.createVectorHelper(obj.hitVec.xCoord, obj.hitVec.yCoord, obj.hitVec.zCoord);
			}

			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
					this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			int i;
			float f1;

			for (i = 0; i < list.size(); ++i) {
				Entity entity1 = (Entity) list.get(i);

				if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
					f1 = 0.3F;
					AxisAlignedBB bb1 = entity1.boundingBox.expand((double) f1, (double) f1, (double) f1);
					MovingObjectPosition obj1 = bb1.calculateIntercept(vec31, vec3);

					if (obj1 != null) {
						double d1 = vec31.distanceTo(obj1.hitVec);

						if (d1 < d0 || d0 == 0.0D) {
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}

			if (entity != null) {
				obj = new MovingObjectPosition(entity);
			}

			if (obj != null && obj.entityHit != null && obj.entityHit instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) obj.entityHit;

				if (player.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer
						&& !((EntityPlayer) this.shootingEntity).canAttackPlayer(player)) {
					obj = null;
				}
			}

			float f2;
			float f4;

			if (obj != null) {
				if (obj.entityHit != null) {
					f2 = MathHelper.sqrt_double(
							this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					int k = MathHelper.ceiling_double_int((double) f2 * this.damage);

					if (this.getIsCritical()) {
						k += this.rand.nextInt(k / 2 + 2);
					}

					DamageSource dam = null;
					EntityLivingBase elb = (EntityLivingBase) obj.entityHit;

					if (this.shootingEntity == null) {
						dam = DamageSource.causeArrowDamage(this, this);
						elb.addPotionEffect(new PotionEffect(mod_ebm.carminicPoison.id, 40, 0, false));
					} else {
						dam = DamageSource.causeArrowDamage(this, this.shootingEntity);
						elb.addPotionEffect(new PotionEffect(mod_ebm.carminicPoison.id, 40, 0, false));
					}

					if (this.isBurning() && !(obj.entityHit instanceof EntityEnderman)) {
						obj.entityHit.setFire(5);
						elb.addPotionEffect(new PotionEffect(mod_ebm.carminicPoison.id, 40, 0, false));
					}

					if (obj.entityHit.attackEntityFrom(dam, (float) k)) {
						if (obj.entityHit instanceof EntityLivingBase) {
							EntityLivingBase entitylivingbase = (EntityLivingBase) obj.entityHit;

							if (!this.worldObj.isRemote) {
								entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
							}

							if (this.knockbackStrength > 0) {
								f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

								if (f4 > 0.0F) {
									obj.entityHit.addVelocity(
											this.motionX * (double) this.knockbackStrength * 0.6000000238418579D
													/ (double) f4,
											0.1D, this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D
													/ (double) f4);
								}
							}

							if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
								EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
								EnchantmentHelper.func_151385_b((EntityLivingBase) this.shootingEntity,
										entitylivingbase);
							}

							if (this.shootingEntity != null && obj.entityHit != this.shootingEntity
									&& obj.entityHit instanceof EntityPlayer
									&& this.shootingEntity instanceof EntityPlayerMP) {
								((EntityPlayerMP) this.shootingEntity).playerNetServerHandler
										.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
							}
						}

						this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

						if (!(obj.entityHit instanceof EntityEnderman)) {
							this.setDead();
						}
					} else {
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.rotationYaw += 180.0F;
						this.prevRotationYaw += 180.0F;
						this.ticksInAir = 0;
					}
				} else {
					this.targetX = obj.blockX;
					this.targetY = obj.blockY;
					this.targetZ = obj.blockZ;
					this.targetBlock = this.worldObj.getBlock(this.targetX, this.targetY, this.targetZ);
					this.inData = this.worldObj.getBlockMetadata(this.targetX, this.targetY, this.targetZ);
					this.motionX = (double) ((float) (obj.hitVec.xCoord - this.posX));
					this.motionY = (double) ((float) (obj.hitVec.yCoord - this.posY));
					this.motionZ = (double) ((float) (obj.hitVec.zCoord - this.posZ));
					f2 = MathHelper.sqrt_double(
							this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					this.posX -= this.motionX / (double) f2 * 0.05000000074505806D;
					this.posY -= this.motionY / (double) f2 * 0.05000000074505806D;
					this.posZ -= this.motionZ / (double) f2 * 0.05000000074505806D;
					this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
					this.inGround = true;
					this.arrowShake = 7;
					this.setIsCritical(false);

					if (this.targetBlock.getMaterial() != Material.air) {
						this.targetBlock.onEntityCollidedWithBlock(this.worldObj, this.targetX, this.targetY,
								this.targetZ, this);
					}
				}
			}

			if (this.getIsCritical()) {
				for (i = 0; i < 4; ++i) {
					this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double) i / 4.0D,
							this.posY + this.motionY * (double) i / 4.0D, this.posZ + this.motionZ * (double) i / 4.0D,
							-this.motionX, -this.motionY + 0.2D, -this.motionZ);
				}
			}

			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

			for (this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f2) * 180.0D
					/ Math.PI); this.rotationPitch
							- this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}

			while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}

			this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
			this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
			float f3 = 0.99F;
			f1 = 0.05F;

			if (this.isInWater()) {
				for (int l = 0; l < 4; ++l) {
					f4 = 0.25F;
					this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double) f4,
							this.posY - this.motionY * (double) f4, this.posZ - this.motionZ * (double) f4,
							this.motionX, this.motionY, this.motionZ);
				}

				f3 = 0.8F;
			}

			if (this.isWet()) {
				this.extinguish();
			}

			this.motionX *= (double) f3;
			this.motionY *= (double) f3;
			this.motionZ *= (double) f3;
			this.motionY -= (double) f1;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.func_145775_I();
		}
	}
}
