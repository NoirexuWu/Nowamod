package net.noirex.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.BeastEntity;
import net.noirex.tutorialmod.entity.custom.CyclopsCrawlerEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CyclopsCrawlerRenderer extends GeoEntityRenderer<CyclopsCrawlerEntity> {
    public CyclopsCrawlerRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new CyclopsCrawlerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CyclopsCrawlerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/ccrawler.png");
    }

}
