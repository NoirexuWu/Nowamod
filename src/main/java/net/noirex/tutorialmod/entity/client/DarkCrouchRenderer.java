package net.noirex.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CyclopsCrawlerEntity;
import net.noirex.tutorialmod.entity.custom.DarkCrounchEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DarkCrouchRenderer extends GeoEntityRenderer<DarkCrounchEntity> {
    public DarkCrouchRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new DarkCrounchModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DarkCrounchEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/crounch.png");
    }

}
