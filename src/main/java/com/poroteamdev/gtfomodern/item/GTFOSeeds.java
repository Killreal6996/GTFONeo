package com.poroteamdev.gtfomodern.item;

import com.poroteamdev.gtfomodern.blocks.crops.GTFOCropBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GTFOSeeds {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("gtfomodern");

    //Italy Update
    public static final DeferredHolder<Item, Item> TOMATO_SEEDS = ITEMS.register(
            "tomato_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.TOMATO_CROP.get(), new Item.Properties()));

    //Spicy update
    public static final DeferredHolder<Item, Item> BELLPEPPER_SEEDS = ITEMS.register(
            "bellpepper_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.BELLPEPER_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> PEPPERONCHINI_SEEDS = ITEMS.register(
            "pepperonchini_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.PEPPERONCHINI_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> BANANAPEPPER_SEEDS = ITEMS.register(
            "bananopepper_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.BANANAPEPPER_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> POBLANO_SEEDS = ITEMS.register(
            "poblano_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.POBLANO_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> JALAPENO_SEEDS = ITEMS.register(
            "jalapeno_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.JALAPENO_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> SERRANO_SEEDS = ITEMS.register(
            "serrano_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.SERRANO_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> CAYENNEPEPPER_SEEDS = ITEMS.register(
            "cayennepepper_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.CAYENNEPEPPER_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> THAIPEPPER_SEEDS = ITEMS.register(
            "thaipepper_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.THAIPEPPER_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> HABANERO_SEEDS = ITEMS.register(
            "habanero_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.HABANERO_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> CAROLINAREAPER_SEEDS = ITEMS.register(
            "carolinareaper_seeds",
            () -> new ItemNameBlockItem(GTFOCropBlocks.CAROLINAREAPER_CROP.get(), new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
