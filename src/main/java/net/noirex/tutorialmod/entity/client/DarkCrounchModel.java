package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.DarkCrounchEntity;
import net.noirex.tutorialmod.entity.custom.DarkCrounchEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DarkCrounchModel extends GeoModel<DarkCrounchEntity> {
    @Override
    public ResourceLocation getModelResource(DarkCrounchEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/crounch.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DarkCrounchEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/crounch.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DarkCrounchEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/crounch.animation.json");
    }

    @Override
    public void setCustomAnimations(DarkCrounchEntity animatable, long instanceId, AnimationState<DarkCrounchEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
