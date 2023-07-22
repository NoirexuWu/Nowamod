package net.noirex.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CarnivorePlantEntity;
import net.noirex.tutorialmod.entity.custom.CuteSpiderEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CarnivorePlantRenderer extends GeoEntityRenderer<CarnivorePlantEntity> {
    public CarnivorePlantRenderer(EntityRendererProvider.Context renderManager) {super(renderManager, new CarnivorePlantModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CarnivorePlantEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/cplant.png");
    }

}
