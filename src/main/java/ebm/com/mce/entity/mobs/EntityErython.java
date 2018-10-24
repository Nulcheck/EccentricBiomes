package ebm.com.mce.entity.mobs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityErython extends EntityAnimal {
	public EntityErython(World world) {
		super(world);
		this.setSize(0.5F, 1.5F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	protected void clearAITasks() {
		tasks.taskEntries.clear();
		targetTasks.taskEntries.clear();
	}

	protected String getLivingSound() {
		return mod_ebm.modid + ":" + "esay";
	}

	protected String getHurtSound() {
		return mod_ebm.modid + ":" + "ehurt";
	}

	protected String getDeathSound() {
		return mod_ebm.modid + ":" + "edeath";
	}

	protected boolean isAIEnabled() {
		return true;
	}

	protected boolean canDamagePlayer() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(13, Byte.valueOf((byte) 0)); // Health?
		this.dataWatcher.addObject(14, Byte.valueOf((byte) 0)); // Tamed?
		this.dataWatcher.addObject(15, Byte.valueOf((byte) 0)); // Child?
	}

	public boolean attackEntityFrom(DamageSource dam, float damage) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = dam.getEntity();

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				damage = (damage + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(dam, damage);
		}
	}

	protected void dropFewItems(boolean hit, int lvl) {
		if (hit) {
			int j = this.rand.nextInt(2 + lvl);

			for (int k = 0; k < j; ++k) {
				this.dropItem(mod_ebm.erythonCube, 1);
			}
		}
	}

	public void onLivingUpdate() {
		for (int i = 0; i < 1; ++i) {
			if (this.worldObj.isRemote) {
				mod_ebm.proxy.spawnParticle(this.worldObj,
						this.posX + (this.rand.nextDouble() - .5d) * (double) this.width,
						this.posY + (this.rand.nextDouble() - .5d) * (double) this.height,
						this.posZ + (this.rand.nextDouble() - .5d) * (double) this.width, "erythonFx");

				/*
				 * EntityErythonFX erythonFX = new
				 * EntityErythonFX(this.worldObj, this.posX +
				 * (this.rand.nextDouble() - 0.5d) * (double) this.width,
				 * this.posY + (this.rand.nextDouble() - 0.5d) * (double)
				 * this.height, this.posZ + (this.rand.nextDouble() - 0.5d) *
				 * (double) this.width, this.posX + (this.rand.nextDouble() -
				 * 0.5d) * (double) this.width, this.posY +
				 * (this.rand.nextDouble() - 0.5d) * (double) this.height,
				 * this.posZ + (this.rand.nextDouble() - 0.5d) * (double)
				 * this.width);
				 * Minecraft.getMinecraft().effectRenderer.addEffect(erythonFX);
				 */
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}
}