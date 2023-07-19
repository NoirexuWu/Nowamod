package net.noirex.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CuteSpiderEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CuteSpiderRenderer extends GeoEntityRenderer<CuteSpiderEntity> {
    public CuteSpiderRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new CuteSpiderModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CuteSpiderEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/cspider.png");
    }

}
