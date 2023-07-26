package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.BeastEntity;
import net.noirex.tutorialmod.entity.custom.CyclopsCrawlerEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CyclopsCrawlerModel extends GeoModel<CyclopsCrawlerEntity> {
    @Override
    public ResourceLocation getModelResource(CyclopsCrawlerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/ccrawler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CyclopsCrawlerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/ccrawler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CyclopsCrawlerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/ccrawler.animation.json");
    }

    @Override
    public void setCustomAnimations(CyclopsCrawlerEntity animatable, long instanceId, AnimationState<CyclopsCrawlerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
