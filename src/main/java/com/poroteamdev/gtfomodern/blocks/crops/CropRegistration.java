package com.poroteamdev.gtfomodern.blocks.crops;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

/**
 * Helper record storing the crop block and its matching seed item.
 */
public record CropRegistration<T extends CropBlock>(
        DeferredBlock<T> block,
        DeferredHolder<Item, Item> seed,
        IntegerProperty ageProperty,
        Supplier<Item> dropItem) {

    /**
     * Registers a crop block and its seed item.
     *
     * @param cropName        registry name for the crop block
     * @param blockSupplier   supplier creating the crop block
     * @param seedName        registry name for the seed item
     * @param dropItem        supplier of the harvested item
     * @param ageProperty     property used for the crop age
     */
    public static <T extends CropBlock> CropRegistration<T> register(
            String cropName,
            Supplier<T> blockSupplier,
            String seedName,
            Supplier<Item> dropItem,
            IntegerProperty ageProperty) {
        DeferredBlock<T> block = CropBlocks.BLOCKS.register(cropName, blockSupplier);
        DeferredHolder<Item, Item> seeds = Seeds.ITEMS.register(seedName,
                () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
        return new CropRegistration<>(block, seeds, ageProperty, dropItem);
    }
}
