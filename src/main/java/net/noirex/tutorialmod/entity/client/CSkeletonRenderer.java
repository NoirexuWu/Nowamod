package net.noirex.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CoralSkeletonEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CSkeletonRenderer extends GeoEntityRenderer<CoralSkeletonEntity> {
    public CSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CSkeletonModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CoralSkeletonEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/skeletonpurple.png");
    }

}
