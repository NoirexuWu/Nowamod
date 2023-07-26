package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.BeastEntity;
import net.noirex.tutorialmod.entity.custom.CarnivorePlantEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BeastModel extends GeoModel<BeastEntity> {
    @Override
    public ResourceLocation getModelResource(BeastEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/beast.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BeastEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/beast.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BeastEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/beast.animation.json");
    }

    @Override
    public void setCustomAnimations(BeastEntity animatable, long instanceId, AnimationState<BeastEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
