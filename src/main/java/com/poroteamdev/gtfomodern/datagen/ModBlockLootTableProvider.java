package com.poroteamdev.gtfomodern.datagen;
import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;
import com.poroteamdev.gtfomodern.blocks.crops.Seeds;
import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
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
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(CropBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Tomato.AGE, 5));
        this.add(CropBlocks.TOMATO_CROP.get(), this.createCropDrops(CropBlocks.TOMATO_CROP.get(),
                Items.TOMATO.get(), Seeds.TOMATO_SEEDS.get(), lootItemConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CropBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
