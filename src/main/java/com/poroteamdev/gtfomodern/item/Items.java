package com.poroteamdev.gtfomodern.item;

import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;
import com.poroteamdev.gtfomodern.registration.JustToolTips;
import com.poroteamdev.gtfomodern.registration.SpicyFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
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

    public static final DeferredHolder<Item, Item> PEELED_POTATO = ITEMS.register(
            "peeled_potato",
            () -> new JustToolTips(
                    new Item.Properties()
                            .food(Fooditems.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> POTATO_CHIP = ITEMS.register(
            "potato_chip",
            () -> new JustToolTips(
                    new Item.Properties()
                            .food(Fooditems.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> NAQUADAH_CHIP = ITEMS.register(
            "naquadah_chip",
            () -> new JustToolTips(
                    new Item.Properties()
                            .food(Fooditems.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> PLASTIC_BAG = ITEMS.register(
            "plastic_bag",
            () -> new JustToolTips(
                    new Item.Properties()
            )
    );


    //Item register
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}


