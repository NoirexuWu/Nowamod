package net.noirex.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.item.custom.MoonArmorItem;
import net.noirex.tutorialmod.item.custom.SunArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SunArmorModel extends GeoModel<SunArmorItem> {
    @Override
    public ResourceLocation getModelResource(SunArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/sun_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SunArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/armor/sun.armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SunArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/sun_armor.animation.json");
    }
}
