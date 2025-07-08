package com.poroteamdev.gtfomodern.datagen;
import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;
import com.poroteamdev.gtfomodern.item.Items;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


    @Override
    protected void generate() {
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(CropBlocks.TOMATO.block().get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlocks.TOMATO.ageProperty(),
                        CropBlocks.TOMATO.block().get().getMaxAge()));
        this.add(CropBlocks.TOMATO.block().get(), this.createCropDrops(CropBlocks.TOMATO.block().get(),
                Items.TOMATO.get(), CropBlocks.TOMATO.seed().get(), lootItemConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CropBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
