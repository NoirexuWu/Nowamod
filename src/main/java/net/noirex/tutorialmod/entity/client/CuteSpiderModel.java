package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CuteSpiderEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CuteSpiderModel extends GeoModel<CuteSpiderEntity> {
    @Override
    public ResourceLocation getModelResource(CuteSpiderEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/cspider.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CuteSpiderEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/cspider.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CuteSpiderEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/cspider.animation.json");
    }

    @Override
    public void setCustomAnimations(CuteSpiderEntity animatable, long instanceId, AnimationState<CuteSpiderEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
