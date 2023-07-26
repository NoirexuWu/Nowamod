package net.noirex.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.BeastEntity;
import net.noirex.tutorialmod.entity.custom.ChubbySharkyEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChubbySharkyRenderer extends GeoEntityRenderer<ChubbySharkyEntity> {
    public ChubbySharkyRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new ChubbySharkyModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ChubbySharkyEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/shark.png");
    }

    @Override
    public void render(ChubbySharkyEntity entity, float entityYaw,float partialTick, PoseStack poseStack,
                          MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.6f,0.6f,0.6f);
        }

        super.render(entity,entityYaw,partialTick,poseStack,bufferSource,packedLight);
    }

}
