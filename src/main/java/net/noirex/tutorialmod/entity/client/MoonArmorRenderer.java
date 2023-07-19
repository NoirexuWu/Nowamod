package net.noirex.tutorialmod.entity.client;

import net.noirex.tutorialmod.item.custom.MoonArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MoonArmorRenderer extends GeoArmorRenderer<MoonArmorItem> {
    public MoonArmorRenderer() {
        super(new MoonArmorModel());
    }
}
