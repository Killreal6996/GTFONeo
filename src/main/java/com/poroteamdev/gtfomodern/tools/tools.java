package com.poroteamdev.gtfomodern.tools;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class tools {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> NAQUACHIP = ITEMS.register("naquachip",
            () -> new Item(new Item.Properties()));

    //public static final DeferredItem<Item> CHIPS = ITEMS.register("chips",() -> new Item());


    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
