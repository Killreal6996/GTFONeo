package com.poroteamdev.gtfomodern.item;

import com.poroteamdev.gtfomodern.registration.GTFOFooditemsTypes;
import com.poroteamdev.gtfomodern.registration.GTFOJustToolTips;
import com.poroteamdev.gtfomodern.registration.GTFOSpicyFoodItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GTFOItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("gtfomodern");

    public static final DeferredHolder<Item, Item> NAQUACHIP =
            ITEMS.register("naquachip", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.NAQUACHIP)
                            .setNoRepair(),
                    5_000_000
                    ));

    public static final DeferredHolder<Item, Item> TOMATO = ITEMS.register("tomato",
            () -> new GTFOJustToolTips(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.VEGETABLE)
                            .setNoRepair()
                    )
            );

    public static final DeferredHolder<Item, Item> PEELED_POTATO = ITEMS.register(
            "peeled_potato",
            () -> new GTFOJustToolTips(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> POTATO_CHIP = ITEMS.register(
            "potato_chip",
            () -> new GTFOJustToolTips(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> NAQUADAH_CHIP = ITEMS.register(
            "naquadah_chip",
            () -> new GTFOJustToolTips(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.VEGETABLE)
                            .setNoRepair()
            )
    );

    public static final DeferredHolder<Item, Item> PLASTIC_BAG = ITEMS.register(
            "plastic_bag",
            () -> new GTFOJustToolTips(
                    new Item.Properties()
            )
    );

    //Peppers
    public static final DeferredHolder<Item, Item> BELLPEPPER =
            ITEMS.register("bellpepper", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    10
            ));

    public static final DeferredHolder<Item, Item> PEPPERONCINI =
            ITEMS.register("pepperoncini", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    100
            ));

    public static final DeferredHolder<Item, Item> BANANA_PEPPER =
            ITEMS.register("bananapepper", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    500
            ));

    public static final DeferredHolder<Item, Item> POBLANO =
            ITEMS.register("poblano", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    1_500
            ));

    public static final DeferredHolder<Item, Item> JALAPENO =
            ITEMS.register("jalapeno", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    8_000
            ));

    public static final DeferredHolder<Item, Item> SERRANO =
            ITEMS.register("serrano", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    23_000
            ));

    public static final DeferredHolder<Item, Item> CAYENNE =
            ITEMS.register("cayennepepper", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    50_000
            ));

    public static final DeferredHolder<Item, Item> THAI_PEPPER =
            ITEMS.register("thaipepper", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    100_000
            ));

    public static final DeferredHolder<Item, Item> HABANERO =
            ITEMS.register("habanero", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    350_000
            ));

    public static final DeferredHolder<Item, Item> CAROLINA_REAPER =
            ITEMS.register("carolinareaper", () -> new GTFOSpicyFoodItems(
                    new Item.Properties()
                            .food(GTFOFooditemsTypes.PEPPER)
                            .setNoRepair(),
                    2_200_000
            ));



    //Item register
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}


