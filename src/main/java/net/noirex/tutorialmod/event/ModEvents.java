package net.noirex.tutorialmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.ModEntities;
import net.noirex.tutorialmod.entity.custom.CoralSkeletonEntity;
import net.noirex.tutorialmod.entity.custom.CuteSpiderEntity;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CSKELETON.get(), CoralSkeletonEntity.setAttributes());
        event.put(ModEntities.CSPIDER.get(), CuteSpiderEntity.setAttributes());
    }



}
