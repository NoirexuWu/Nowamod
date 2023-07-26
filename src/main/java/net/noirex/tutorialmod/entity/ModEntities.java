package net.noirex.tutorialmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.custom.*;

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
    public static final RegistryObject<EntityType<CarnivorePlantEntity>> CPLANT =
            ENTITY_TYPES.register("cplant",
                    () -> EntityType.Builder.of(CarnivorePlantEntity::new, MobCategory.CREATURE)
                            .sized(1f, 0.1f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "cplant").toString()));
    public static final RegistryObject<EntityType<BeastEntity>> BEAST =
            ENTITY_TYPES.register("beast",
                    () -> EntityType.Builder.of(BeastEntity::new, MobCategory.MONSTER)
                            .sized(3.3f, 7.3f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "beast").toString()));
    public static final RegistryObject<EntityType<CyclopsCrawlerEntity>> CCRAWLER =
            ENTITY_TYPES.register("ccrawler",
                    () -> EntityType.Builder.of(CyclopsCrawlerEntity::new, MobCategory.MONSTER)
                            .sized(2.3f, 2f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "ccrawler").toString()));
    public static final RegistryObject<EntityType<DarkCrounchEntity>> CROUNCH =
            ENTITY_TYPES.register("crounch",
                    () -> EntityType.Builder.of(DarkCrounchEntity::new, MobCategory.MONSTER)
                            .sized(1.2f, 1.7f)
                            .fireImmune()
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "crounch").toString()));
    public static final RegistryObject<EntityType<ChubbySharkyEntity>> SHARK =
            ENTITY_TYPES.register("shark",
                    () -> EntityType.Builder.of(ChubbySharkyEntity::new, MobCategory.CREATURE)
                            .sized(.5f, .5f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "shark").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
