package net.noirex.tutorialmod.entity.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CloseAttackRangeGoal extends MeleeAttackGoal {

    public CloseAttackRangeGoal(PathfinderMob p_25552_, double p_25553_, boolean p_25554_) {
        super(p_25552_, p_25553_, p_25554_);
    }
    @Override
    protected double getAttackReachSqr(LivingEntity p_25556_) {
        return (double)(0.4);
    }
}
