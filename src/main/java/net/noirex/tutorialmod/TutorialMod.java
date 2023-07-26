package net.noirex.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.noirex.tutorialmod.block.ModBlocks;
import net.noirex.tutorialmod.entity.ModEntities;
import net.noirex.tutorialmod.entity.client.*;
import net.noirex.tutorialmod.entity.custom.CyclopsCrawlerEntity;
import net.noirex.tutorialmod.item.ModCreativeModeTabs;
import net.noirex.tutorialmod.item.ModItems;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB.get()) {
            event.accept(ModItems.DIRTY_MOON_FRAGMENT);
            event.accept(ModItems.DIRTY_SUN_FRAGMENT);
            event.accept(ModItems.MOON_FRAGMENT);
            event.accept(ModItems.SUN_FRAGMENT);
            event.accept(ModItems.SUN_INGOT);
            event.accept(ModItems.MOON_INGOT);
            event.accept(ModItems.MOON_HELMET);
            event.accept(ModItems.MOON_CHESTPLATE);
            event.accept(ModItems.MOON_LEGGINGS);
            event.accept(ModItems.MOON_BOOTS);
            event.accept(ModItems.SUN_HELMET);
            event.accept(ModItems.SUN_CHESTPLATE);
            event.accept(ModItems.SUN_LEGGINGS);
            event.accept(ModItems.SUN_BOOTS);
            event.accept(ModItems.CORAL_SKELETON_SPAWN_EGG);
            event.accept(ModItems.CUTE_SPIDER_SPAWN_EGG);
            event.accept(ModItems.CARNIVORE_PLANT_SPAWN_EGG);
            event.accept(ModItems.BEAST_SPAWN_EGG);
            event.accept(ModItems.CCRAWLER_SPAWN_EGG);
            event.accept(ModItems.DARK_CROUNCH_SPAWN_EGG);
            event.accept(ModItems.CHUBBY_SHARK_SPAWN_EGG);
        }

        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB.get()) {
            event.accept(ModBlocks.MOON_FRAGMENT_BLOCK);
            event.accept(ModBlocks.DIRTY_MOON_FRAGMENT_BLOCK);
            event.accept(ModBlocks.DIRTY_MOON_FRAGMENT_ORE);
            event.accept(ModBlocks.DEEPSLATE_MOON_FRAGMENT_ORE);
            event.accept(ModBlocks.SUN_FRAGMENT_BLOCK);
            event.accept(ModBlocks.DIRTY_SUN_FRAGMENT_BLOCK);
            event.accept(ModBlocks.DIRTY_SUN_FRAGMENT_ORE);
            event.accept(ModBlocks.DEEPSLATE_SUN_FRAGMENT_ORE);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
            event.accept(ModBlocks.EBONY_SAPLING);
        }

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CSKELETON.get(), CSkeletonRenderer::new);
            EntityRenderers.register(ModEntities.CSPIDER.get(), CuteSpiderRenderer::new);
            EntityRenderers.register(ModEntities.CPLANT.get(), CarnivorePlantRenderer::new);
            EntityRenderers.register(ModEntities.BEAST.get(), BeastRenderer::new);
            EntityRenderers.register(ModEntities.CCRAWLER.get(), CyclopsCrawlerRenderer::new);
            EntityRenderers.register(ModEntities.CROUNCH.get(), DarkCrouchRenderer::new);
            EntityRenderers.register(ModEntities.SHARK.get(), ChubbySharkyRenderer::new);
        }
    }
}
