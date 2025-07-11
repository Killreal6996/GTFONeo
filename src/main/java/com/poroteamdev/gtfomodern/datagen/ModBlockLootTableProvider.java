package com.poroteamdev.gtfomodern.datagen;
import com.poroteamdev.gtfomodern.blocks.crops.GTFOCropBlocks;
import com.poroteamdev.gtfomodern.item.GTFOSeeds;
import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
import com.poroteamdev.gtfomodern.blocks.crops.spicyupdate.*;
import com.poroteamdev.gtfomodern.item.GTFOItems;
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

        //Italy update
        LootItemCondition.Builder tomatoLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Tomato.AGE, 5));
        this.add(GTFOCropBlocks.TOMATO_CROP.get(), this.createCropDrops(GTFOCropBlocks.TOMATO_CROP.get(),
                GTFOItems.TOMATO.get(), GTFOSeeds.TOMATO_SEEDS.get(), tomatoLootItemConditionBuilder));

        //Spicy update
        LootItemCondition.Builder bellpepperLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.BELLPEPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BellPepper.AGE, 4));
        this.add(GTFOCropBlocks.BELLPEPER_CROP.get(), this.createCropDrops(GTFOCropBlocks.BELLPEPER_CROP.get(),
                GTFOItems.BELLPEPPER.get(), GTFOSeeds.BELLPEPPER_SEEDS.get(), bellpepperLootItemConditionBuilder));

        LootItemCondition.Builder pepperonchiniLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.PEPPERONCHINI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Pepperonchini.AGE, 4));
        this.add(GTFOCropBlocks.PEPPERONCHINI_CROP.get(), this.createCropDrops(GTFOCropBlocks.PEPPERONCHINI_CROP.get(),
                GTFOItems.PEPPERONCINI.get(), GTFOSeeds.PEPPERONCHINI_SEEDS.get(), pepperonchiniLootItemConditionBuilder));

        LootItemCondition.Builder bananapepperLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.BANANAPEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BananaPepper.AGE, 4));
        this.add(GTFOCropBlocks.BANANAPEPPER_CROP.get(), this.createCropDrops(GTFOCropBlocks.BANANAPEPPER_CROP.get(),
                GTFOItems.BANANA_PEPPER.get(), GTFOSeeds.BANANAPEPPER_SEEDS.get(), bananapepperLootItemConditionBuilder));

        LootItemCondition.Builder poblanoLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.POBLANO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Poblano.AGE, 4));
        this.add(GTFOCropBlocks.POBLANO_CROP.get(), this.createCropDrops(GTFOCropBlocks.POBLANO_CROP.get(),
                GTFOItems.POBLANO.get(), GTFOSeeds.POBLANO_SEEDS.get(), poblanoLootItemConditionBuilder));

        LootItemCondition.Builder jalapenoLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.JALAPENO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Jalapeno.AGE, 4));
        this.add(GTFOCropBlocks.JALAPENO_CROP.get(), this.createCropDrops(GTFOCropBlocks.JALAPENO_CROP.get(),
                GTFOItems.JALAPENO.get(), GTFOSeeds.JALAPENO_SEEDS.get(), jalapenoLootItemConditionBuilder));

        LootItemCondition.Builder serranoLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.SERRANO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Serrano.AGE, 4));
        this.add(GTFOCropBlocks.SERRANO_CROP.get(), this.createCropDrops(GTFOCropBlocks.SERRANO_CROP.get(),
                GTFOItems.SERRANO.get(), GTFOSeeds.SERRANO_SEEDS.get(), serranoLootItemConditionBuilder));

        LootItemCondition.Builder cayennepepperLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.CAYENNEPEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CayennePepper.AGE, 4));
        this.add(GTFOCropBlocks.CAYENNEPEPPER_CROP.get(), this.createCropDrops(GTFOCropBlocks.CAYENNEPEPPER_CROP.get(),
                GTFOItems.CAYENNE.get(), GTFOSeeds.CAYENNEPEPPER_SEEDS.get(), cayennepepperLootItemConditionBuilder));

        LootItemCondition.Builder thaipepperLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.THAIPEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ThaiPepper.AGE, 4));
        this.add(GTFOCropBlocks.THAIPEPPER_CROP.get(), this.createCropDrops(GTFOCropBlocks.THAIPEPPER_CROP.get(),
                GTFOItems.THAI_PEPPER.get(), GTFOSeeds.THAIPEPPER_SEEDS.get(), thaipepperLootItemConditionBuilder));

        LootItemCondition.Builder habaneroLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.HABANERO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(Habanero.AGE, 4));
        this.add(GTFOCropBlocks.HABANERO_CROP.get(), this.createCropDrops(GTFOCropBlocks.HABANERO_CROP.get(),
                GTFOItems.HABANERO.get(), GTFOSeeds.HABANERO_SEEDS.get(), bellpepperLootItemConditionBuilder));

        LootItemCondition.Builder carolinareaperLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GTFOCropBlocks.CAROLINAREAPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarolinaReaper.AGE, 5));
        this.add(GTFOCropBlocks.CAROLINAREAPER_CROP.get(), this.createCropDrops(GTFOCropBlocks.CAROLINAREAPER_CROP.get(),
                GTFOItems.CAROLINA_REAPER.get(), GTFOSeeds.CAROLINAREAPER_SEEDS.get(), carolinareaperLootItemConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GTFOCropBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
