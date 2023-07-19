package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CoralSkeletonEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CSkeletonModel extends GeoModel<CoralSkeletonEntity> {
    @Override
    public ResourceLocation getModelResource(CoralSkeletonEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoralSkeletonEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/skeletonpurple.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoralSkeletonEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/skeleton.animation.json");
    }

    @Override
    public void setCustomAnimations(CoralSkeletonEntity animatable, long instanceId, AnimationState<CoralSkeletonEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
