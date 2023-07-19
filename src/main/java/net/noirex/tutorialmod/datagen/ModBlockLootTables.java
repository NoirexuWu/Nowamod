package net.noirex.tutorialmod.datagen;

import net.noirex.tutorialmod.block.ModBlocks;
import net.noirex.tutorialmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MOON_FRAGMENT_BLOCK.get());
        dropSelf(ModBlocks.DIRTY_MOON_FRAGMENT_BLOCK.get());

        add(ModBlocks.DIRTY_MOON_FRAGMENT_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DIRTY_MOON_FRAGMENT_ORE.get(), ModItems.DIRTY_MOON_FRAGMENT.get()));
        add(ModBlocks.DEEPSLATE_MOON_FRAGMENT_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_MOON_FRAGMENT_ORE.get(), ModItems.DIRTY_MOON_FRAGMENT.get()));


        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.EBONY_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
