package net.noirex.tutorialmod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.noirex.tutorialmod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class ChubbySharkyEntity extends ShoulderRidingEntity implements GeoEntity {
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.SALMON, Items.COD, Items.TROPICAL_FISH);


    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public ChubbySharkyEntity(EntityType<? extends ShoulderRidingEntity> p_33786_, Level p_33787_) {
        super(p_33786_, p_33787_);
                    }


    public static AttributeSupplier setAttributes() {
        return ShoulderRidingEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.ATTACK_DAMAGE, 4f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();


    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new NewAttackGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.SALMON, Items.COD, Items.TROPICAL_FISH), false));

    }
//    public static boolean canCoralSkeletonSpawn(EntityType<CoralSkeletonEntity> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
//        return reason == MobSpawnType.SPAWNER || pos.getY() <= AMConfig.blobfishSpawnHeight && iServerWorld.getBlockState(pos).getMaterial() == Material.WATER && iServerWorld.getBlockState(pos.above()).getMaterial() == Material.WATER;
//    }

        @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController<>(this,"attackcontroller",0,this::attackPredicate));
            controllerRegistrar.add(new AnimationController<>(this,"watercontroller",0,this::waterPredicate));


    }

    public  <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("shark.animation.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }


        tAnimationState.getController().setAnimation(RawAnimation.begin().then("shark.animation.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;



    }
    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState) {
        if(this.swinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("shark.animation.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;

        }


        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState waterPredicate(AnimationState<T> tAnimationState) {
        if(this.wasTouchingWater && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("shark.animation.wasonwater", Animation.LoopType.PLAY_ONCE));
            this.wasTouchingWater = false;

        }


        return PlayState.CONTINUE;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;

    }


    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    public boolean isFood(ItemStack p_29508_) {
        return FOOD_ITEMS.test(p_29508_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntities.SHARK.get().create(level);
    }



    static class NewAttackGoal extends MeleeAttackGoal {
        public NewAttackGoal(ChubbySharkyEntity p_33822_) {
            super(p_33822_, 1.0D, true);
        }

        @Override
        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(18);
        }
        @Override
        protected double getAttackReachSqr(LivingEntity p_25556_) {
            return (double)(3);
        }
    }

}
