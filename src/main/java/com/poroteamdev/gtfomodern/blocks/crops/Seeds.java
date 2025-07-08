package com.poroteamdev.gtfomodern.blocks.crops;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Seeds {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("gtfomodern");

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
