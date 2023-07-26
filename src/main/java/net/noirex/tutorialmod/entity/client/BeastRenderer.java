package net.noirex.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.BeastEntity;
import net.noirex.tutorialmod.entity.custom.CarnivorePlantEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BeastRenderer extends GeoEntityRenderer<BeastEntity> {
    public BeastRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new BeastModel());
    }

    @Override
    public ResourceLocation getTextureLocation(BeastEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/beast.png");
    }

}
