package com.poroteamdev.gtfomodern;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.poroteamdev.gtfomodern.item.GTFOItems;
import com.poroteamdev.gtfomodern.item.GTFOSeeds;

public class GTFOModTabs {
    public static final DeferredRegister<CreativeModeTab> GTFO_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GTFO.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD_TAB =
            GTFO_TAB.register("food_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GTFOItems.NAQUACHIP.get()))
                    .title(Component.translatable("creativetab.gtfofoodtab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(GTFOItems.NAQUACHIP.get());
                    }))
                    .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CROP_TAB =
            GTFO_TAB.register("crop_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GTFOSeeds.TOMATO_SEEDS.get()))
                    .title(Component.translatable("creativetab.gtfocroptab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(GTFOSeeds.TOMATO_SEEDS.get());

                        pOutput.accept(GTFOSeeds.BELLPEPPER_SEEDS.get());
                        pOutput.accept(GTFOSeeds.PEPPERONCHINI_SEEDS.get());
                        pOutput.accept(GTFOSeeds.BANANAPEPPER_SEEDS.get());
                        pOutput.accept(GTFOSeeds.POBLANO_SEEDS.get());
                        pOutput.accept(GTFOSeeds.JALAPENO_SEEDS.get());
                        pOutput.accept(GTFOSeeds.SERRANO_SEEDS.get());
                        pOutput.accept(GTFOSeeds.CAYENNEPEPPER_SEEDS.get());
                        pOutput.accept(GTFOSeeds.THAIPEPPER_SEEDS.get());
                        pOutput.accept(GTFOSeeds.HABANERO_SEEDS.get());
                        pOutput.accept(GTFOSeeds.CAROLINAREAPER_SEEDS.get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMPONENT_EDIBLE =
            GTFO_TAB.register("edible_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GTFOItems.TOMATO.get()))
                    .title(Component.translatable("creativetab.gtfocomponentedibletab"))
                    .displayItems(((pParameters, pOutput) -> {
                        // vegetables, fruits, berries
                        pOutput.accept(GTFOItems.TOMATO.get());

                        pOutput.accept(GTFOItems.BELLPEPPER.get());
                        pOutput.accept(GTFOItems.PEPPERONCINI.get());
                        pOutput.accept(GTFOItems.BANANA_PEPPER.get());
                        pOutput.accept(GTFOItems.POBLANO.get());
                        pOutput.accept(GTFOItems.JALAPENO.get());
                        pOutput.accept(GTFOItems.SERRANO.get());
                        pOutput.accept(GTFOItems.CAYENNE.get());
                        pOutput.accept(GTFOItems.THAI_PEPPER.get());
                        pOutput.accept(GTFOItems.HABANERO.get());
                        pOutput.accept(GTFOItems.CAROLINA_REAPER.get());

                        // edible components
                        pOutput.accept(GTFOItems.PEELED_POTATO.get());
                        pOutput.accept(GTFOItems.POTATO_CHIP.get());
                        pOutput.accept(GTFOItems.NAQUADAH_CHIP.get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMPONENT_INEDIBLE =
            GTFO_TAB.register("inedible_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GTFOItems.PLASTIC_BAG.get()))
                    .title(Component.translatable("creativetab.gtfocomponentinedibletab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(GTFOItems.PLASTIC_BAG.get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> INSTRUMENTS_AND_MACHINES =
            GTFO_TAB.register("tool_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GTFOItems.NAQUACHIP.get()))
                    .title(Component.translatable("creativetab.gtfoinstrumentsandmachinestab"))
                    .displayItems(((pParameters, pOutput) -> {}))
                    .build());

    public static void register(IEventBus eventBus) {
        GTFO_TAB.register(eventBus);
    }
}
