package com.poroteamdev.gtfomodern.food;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.bus.api.IEventBus;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> NAQUACHIP = ITEMS.register("naquachip",
            () -> new Item(new Item.Properties().food(fooditems.NAQUACHIP)));



    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
