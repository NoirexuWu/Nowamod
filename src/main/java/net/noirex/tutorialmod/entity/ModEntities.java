package net.noirex.tutorialmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.CoralSkeletonEntity;
import net.noirex.tutorialmod.entity.custom.CuteSpiderEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<CoralSkeletonEntity>> CSKELETON =
            ENTITY_TYPES.register("cskeleton",
                    () -> EntityType.Builder.of(CoralSkeletonEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.99f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "cskeleton").toString()));
    public static final RegistryObject<EntityType<CuteSpiderEntity>> CSPIDER =
            ENTITY_TYPES.register("cspider",
                    () -> EntityType.Builder.of(CuteSpiderEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 0.5f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "cspider").toString()));
     public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
