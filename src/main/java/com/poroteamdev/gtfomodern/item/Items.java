package com.poroteamdev.gtfomodern.item;

import com.poroteamdev.gtfomodern.ItemsCustom.SpicyFoodItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> NAQUACHIP =
            ITEMS.register("naquachip", () -> new SpicyFoodItems(
                    new Item.Properties()
                            .food(Fooditems.NAQUACHIP)
                            .setNoRepair(),
                    5_000_000
                    ));

    //Item register
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}


