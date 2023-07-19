package net.noirex.tutorialmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.fluids.FluidType;
import software.bernie.geckolib.core.animation.RawAnimation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.noirex.tutorialmod.entity.ModEntities;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;


import javax.annotation.Nullable;

public class CoralSkeletonEntity extends Monster implements GeoEntity {
    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public CoralSkeletonEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }


    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.ATTACK_KNOCKBACK, 5D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100D)
                .add(Attributes.MAX_HEALTH, 25D)
                .add(Attributes.ATTACK_DAMAGE, 15.0f)
                .add(Attributes.ATTACK_SPEED, 0.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();


    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new RestrictSunGoal(this));
        this.goalSelector.addGoal(1, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new AttackRangeGoal(this, 1.2D, false));
        this.goalSelector.addGoal(3, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Dolphin.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Drowned.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Axolotl.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }
//    public static boolean canCoralSkeletonSpawn(EntityType<CoralSkeletonEntity> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
//        return reason == MobSpawnType.SPAWNER || pos.getY() <= AMConfig.blobfishSpawnHeight && iServerWorld.getBlockState(pos).getMaterial() == Material.WATER && iServerWorld.getBlockState(pos.above()).getMaterial() == Material.WATER;
//    }

    @Nullable
    public CoralSkeletonEntity getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntities.CSKELETON.get().create(level);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController<>(this,"attackcontroller",0,this::attackPredicate));

        
    }

    public  <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }


        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;



    }
    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState) {
        if(this.swinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;

        }


        return PlayState.CONTINUE;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;

    }


}
