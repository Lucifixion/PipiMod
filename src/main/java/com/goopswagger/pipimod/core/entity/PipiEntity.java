package com.goopswagger.pipimod.core.entity;

import com.goopswagger.pipimod.core.PipiModBlocks;
import com.goopswagger.pipimod.core.PipiModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class PipiEntity extends AnimalEntity {

    private static final TrackedData<Boolean> FROLICING = DataTracker.registerData(PipiEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> FLOWER = DataTracker.registerData(PipiEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private int jumpTicks;
    private int jumpDuration;
    private boolean lastOnGround;
    private int ticksUntilJump;

    public PipiEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setSpeed(0.0);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.world));
        this.goalSelector.add(2, new AnimalMateGoal(this, 0.6));
        this.goalSelector.add(3, new PipiTemptGoal(this, 0.65, Ingredient.fromTag(ItemTags.FLOWERS), false));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.6));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.FLOWERS);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FROLICING, false);
        this.dataTracker.startTracking(FLOWER, true);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("flower", this.dataTracker.get(FLOWER));
        nbt.putInt("flowerTick", this.flowerTick);
        nbt.putBoolean("isFrolicing", this.getFrolicing());
        nbt.putShort("frolicTicks", this.frolicTick);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(FLOWER, nbt.getBoolean("flower"));
        this.flowerTick = (nbt.getInt("flowerTick"));
        this.setFrolicing(nbt.getBoolean("isFrolicing"));
        this.frolicTick = nbt.getByte("frolicTicks");
    }

    public static DefaultAttributeContainer.Builder createPipiAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5);
    }

    @Override
    public AttributeContainer getAttributes() {
        return new AttributeContainer(createPipiAttributes().build());
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        PipiEntity pipiEntity = PipiModEntities.PIPI.create(world);
        pipiEntity.setBaby(true);
        return pipiEntity;
    }

    public boolean hasFlower() {
        return (!this.isBaby() && this.dataTracker.get(FLOWER));
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        if (player.isSneaking() && player.getStackInHand(hand) == ItemStack.EMPTY) { // pet the pipi
            player.swingHand(hand);
            this.world.sendEntityStatus(this, (byte)18);
            return ActionResult.SUCCESS;
        }

        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) { // cut off all your hair
            if (!this.world.isClient && this.hasFlower()) {
                this.sheared(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;
            }
        }
        return super.interactMob(player, hand);
    }

    public void sheared(SoundCategory shearedSoundCategory) {
        this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        this.dataTracker.set(FLOWER, false);
        ItemEntity itemEntity = this.dropItem(PipiModBlocks.PINK_DAISY.asItem());
        if (itemEntity != null) {
            itemEntity.setVelocity(itemEntity.getVelocity().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));
        }

    }

    protected void jump() {
        super.jump();
        double d = this.moveControl.getSpeed();
        if (d > 0.0) {
            double e = this.getVelocity().horizontalLengthSquared();
            if (e < 0.01) {
                this.updateVelocity(0.1F, new Vec3d(0.0, 0.0, 1.0));
            }
        }

        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)1);
        }

    }

    public void setJumping(boolean jumping) {
        super.setJumping(jumping);
        if (jumping) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
        }
    }

    protected SoundEvent getJumpSound() {
        return SoundEvents.ENTITY_RABBIT_JUMP;
    }

    public void setSpeed(double speed) {
        this.getNavigation().setSpeed(speed);
        this.moveControl.moveTo(this.moveControl.getTargetX(), this.moveControl.getTargetY(), this.moveControl.getTargetZ(), speed);
    }

    public void setFrolicing(boolean frolicing) {
        this.dataTracker.set(FROLICING, frolicing);

        if (this.getFrolicing()) {
            this.jumpControl = new PipiJumpControl(this);
            this.moveControl = new PipiMoveControl(this);
        } else {
            this.jumpControl = new JumpControl(this);
            this.moveControl = new MoveControl(this);
        }

    }

    public boolean getFrolicing() {
        return this.dataTracker.get(FROLICING);
    }

    private short frolicTick = 0;
    private int flowerTick = 0;

    @Override
    public void tick() {
        super.tick();
        frolicTick++;

        int frolicLimit = getFrolicing() ? 200 : 350;

        if (frolicTick > frolicLimit) {
            setFrolicing(!getFrolicing());
            frolicTick = 0;
        }

        if (!this.dataTracker.get(FLOWER)) {
            flowerTick++;
            if (flowerTick > 6000) {
                flowerTick = 0;
                this.dataTracker.set(FLOWER, true);
            }
        }

    }

    public void mobTick() {
        if (getFrolicing()) {
            if (this.ticksUntilJump > 0) {
                --this.ticksUntilJump;
            }

            if (this.onGround) {
                if (!this.lastOnGround) {
                    this.setJumping(false);
                    this.scheduleJump();
                }

                PipiJumpControl pipiJumpControl = (PipiJumpControl) this.jumpControl;
                if (!pipiJumpControl.isActive()) {
                    if (this.moveControl.isMoving() && this.ticksUntilJump == 0) {
                        Path path = this.navigation.getCurrentPath();
                        Vec3d vec3d = new Vec3d(this.moveControl.getTargetX(), this.moveControl.getTargetY(), this.moveControl.getTargetZ());
                        if (path != null && !path.isFinished()) {
                            vec3d = path.getNodePosition(this);
                        }

                        this.lookTowards(vec3d.x, vec3d.z);
                        this.startJump();
                    }
                } else if (!pipiJumpControl.canJump()) {
                    this.enableJump();
                }
            }

            this.lastOnGround = this.onGround;
        } else {
            super.mobTick();
        }
    }

    private void enableJump() {
        if (getFrolicing()) ((PipiJumpControl)this.jumpControl).setCanJump(true);
    }

    private void disableJump() {
        if (getFrolicing()) ((PipiJumpControl)this.jumpControl).setCanJump(false);
    }

    private void doScheduleJump() {
        this.ticksUntilJump = 1;
    }

    private void scheduleJump() {
        this.doScheduleJump();
        this.disableJump();
    }

    public float getJumpProgress(float delta) { // keep this for the frolic animation
        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + delta) / (float)this.jumpDuration;
    }

    private void lookTowards(double x, double z) {
        this.setYaw((float)(MathHelper.atan2(z - this.getZ(), x - this.getX()) * 57.2957763671875) - 90.0F);
    }

    public void tickMovement() {
        super.tickMovement();
        if (getFrolicing()) {
            if (this.jumpTicks != this.jumpDuration) {
                ++this.jumpTicks;
            } else if (this.jumpDuration != 0) {
                this.jumpTicks = 0;
                this.jumpDuration = 0;
                this.setJumping(false);
            }
        }
    }

    public void startJump() {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }

    public void handleStatus(byte status) {
        if (status == 1) {
            this.spawnSprintingParticles();
            this.jumpDuration = 10;
            this.jumpTicks = 0;
        } else {
            super.handleStatus(status);
        }

    }

    public static class PipiJumpControl extends JumpControl {
        private final PipiEntity pipi;
        private boolean canJump;

        public PipiJumpControl(PipiEntity pipi) {
            super(pipi);
            this.pipi = pipi;
        }

        public boolean isActive() {
            return this.active;
        }

        public boolean canJump() {
            return this.canJump;
        }

        public void setCanJump(boolean canJump) {
            this.canJump = canJump;
        }

        public void tick() {
            if (this.active) {
                this.pipi.startJump();
                this.active = false;
            }

        }
    }

    public static class PipiMoveControl extends MoveControl {
        private final PipiEntity pipi;
        private double pipiSpeed;

        public PipiMoveControl(PipiEntity owner) {
            super(owner);
            this.pipi = owner;
        }

        public void tick() {
            if (this.pipi.onGround && !this.pipi.jumping && !((PipiJumpControl)this.pipi.jumpControl).isActive()) {
                this.pipi.setSpeed(0.0);
            } else if (this.isMoving()) {
                this.pipi.setSpeed(this.pipiSpeed);
            }

            super.tick();
        }

        public void moveTo(double x, double y, double z, double speed) {
            if (this.pipi.isTouchingWater()) {
                speed = 1.5;
            }

            super.moveTo(x, y, z, speed);
            if (speed > 0.0) {
                this.pipiSpeed = speed;
            }

        }
    }

    private static class PipiTemptGoal extends TemptGoal {

        private final PipiEntity pipi;
        public PipiTemptGoal(PipiEntity entity, double speed, Ingredient food, boolean canBeScared) {
            super(entity, speed, food, canBeScared);
            this.pipi = entity;
        }

        @Override
        public void tick() {
            super.tick();
            this.pipi.setFrolicing(isActive());
        }
    }

}
