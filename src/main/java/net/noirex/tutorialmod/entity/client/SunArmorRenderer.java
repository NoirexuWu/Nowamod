package net.noirex.tutorialmod.entity.client;

import net.noirex.tutorialmod.item.custom.MoonArmorItem;
import net.noirex.tutorialmod.item.custom.SunArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SunArmorRenderer extends GeoArmorRenderer<SunArmorItem> {
    public SunArmorRenderer() {
        super(new SunArmorModel());
    }
}
