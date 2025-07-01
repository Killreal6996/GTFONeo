package com.poroteamdev.gtfomodern.item;

import com.poroteamdev.gtfomodern.registration.JustToolTips;
import com.poroteamdev.gtfomodern.registration.SpicyFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> NAQUACHIP =
            ITEMS.register("naquachip", () -> new SpicyFoodItems(
                    new Item.Properties()
                            .food(Fooditems.NAQUACHIP)
                            .setNoRepair(),
                    5_000_000
                    ));
    public static final DeferredHolder<Item, Item> TOMATO = ITEMS.register("tomato",
            () -> new JustToolTips(
                    new Item.Properties()
                            .food(Fooditems.VEGETABLE)
                            .setNoRepair()
                    )
            );
    //Tooltip init and register
    /*private static DeferredHolder<Item, Item> registerWithTooltip(String string, Supplier<Item> itemSupplier, String tooltipKey){
        DeferredHolder<Item, Item> holder = ITEMS.register(string, itemSupplier);
        JustToolTips.registerTooltip(holder.get(),
                () -> Component.translatable(tooltipKey));
        return holder;
    }*/

    //Item register
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}


