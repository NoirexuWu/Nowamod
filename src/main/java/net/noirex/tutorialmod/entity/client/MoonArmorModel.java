package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CoralSkeletonEntity;
import net.noirex.tutorialmod.item.custom.MoonArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MoonArmorModel extends GeoModel<MoonArmorItem> {
    @Override
    public ResourceLocation getModelResource(MoonArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/moon_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MoonArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/armor/moon.armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MoonArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/moon_armor.animation.json");
    }
}
