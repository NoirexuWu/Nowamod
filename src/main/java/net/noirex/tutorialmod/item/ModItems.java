package net.noirex.tutorialmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.entity.ModEntities;
import net.noirex.tutorialmod.item.custom.MoonArmorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> DIRTY_MOON_FRAGMENT = ITEMS.register("dirty_moon_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOON_FRAGMENT = ITEMS.register("moon_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOON_INGOT = ITEMS.register("moon_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_SUN_FRAGMENT = ITEMS.register("dirty_sun_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUN_FRAGMENT = ITEMS.register("sun_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUN_INGOT = ITEMS.register("sun_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOON_HELMET = ITEMS.register("moon_helmet",
            () -> new MoonArmorItem(ModArmorMaterials.MOON_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MOON_CHESTPLATE = ITEMS.register("moon_chestplate",
            () -> new MoonArmorItem(ModArmorMaterials.MOON_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MOON_LEGGINGS = ITEMS.register("moon_leggings",
            () -> new MoonArmorItem(ModArmorMaterials.MOON_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MOON_BOOTS = ITEMS.register("moon_boots",
            () -> new MoonArmorItem(ModArmorMaterials.MOON_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CORAL_SKELETON_SPAWN_EGG = ITEMS.register("coral_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CSKELETON,0x89628C,0x6F7B56,
                    new Item.Properties()));
    public static final RegistryObject<Item> CUTE_SPIDER_SPAWN_EGG = ITEMS.register("cute_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CSPIDER,0xA9A9A9,0x434343,
                    new Item.Properties()));
    public static final RegistryObject<Item> CARNIVORE_PLANT_SPAWN_EGG = ITEMS.register("carnivore_plant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CPLANT,0x349643,0x27572E,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
