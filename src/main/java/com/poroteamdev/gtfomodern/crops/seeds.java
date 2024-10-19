package com.poroteamdev.gtfomodern.crops;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class seeds {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(CrobBlocks.TOMATO_CROP.get(), new Item.Properties()));



    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
