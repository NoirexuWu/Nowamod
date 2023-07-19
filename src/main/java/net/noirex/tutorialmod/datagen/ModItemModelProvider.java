package net.noirex.tutorialmod.datagen;

import net.noirex.tutorialmod.TutorialMod;
import net.noirex.tutorialmod.block.ModBlocks;
import net.noirex.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MOON_FRAGMENT);
        simpleItem(ModItems.DIRTY_MOON_FRAGMENT);
        saplingItem(ModBlocks.EBONY_SAPLING);

        simpleItem(ModItems.MOON_HELMET);
        simpleItem(ModItems.MOON_CHESTPLATE);
        simpleItem(ModItems.MOON_LEGGINGS);
        simpleItem(ModItems.MOON_BOOTS);


        withExistingParent(ModItems.CORAL_SKELETON_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CUTE_SPIDER_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
