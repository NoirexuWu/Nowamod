package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.ChubbySharkyEntity;
import net.noirex.tutorialmod.entity.custom.ChubbySharkyEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ChubbySharkyModel extends GeoModel<ChubbySharkyEntity> {
    @Override
    public ResourceLocation getModelResource(ChubbySharkyEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/shark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChubbySharkyEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/shark.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChubbySharkyEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/shark.animation.json");
    }

    @Override
    public void setCustomAnimations(ChubbySharkyEntity animatable, long instanceId, AnimationState<ChubbySharkyEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
