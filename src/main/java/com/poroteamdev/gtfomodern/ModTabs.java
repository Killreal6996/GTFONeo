package com.poroteamdev.gtfomodern;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.poroteamdev.gtfomodern.item.Items;
import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> GTFO_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GTFO.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD_TAB =
            GTFO_TAB.register("food_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NAQUACHIP.get()))
                    .title(Component.translatable("creativetab.gtfofoodtab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(Items.NAQUACHIP.get());
                    }))
                    .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CROP_TAB =
            GTFO_TAB.register("crop_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CropBlocks.TOMATO.seed().get()))
                    .title(Component.translatable("creativetab.gtfocroptab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(CropBlocks.TOMATO.seed().get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMPONENT_EDIBLE =
            GTFO_TAB.register("edible_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.TOMATO.get()))
                    .title(Component.translatable("creativetab.gtfocomponentedibletab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(Items.TOMATO.get());
                        pOutput.accept(Items.PEELED_POTATO.get());
                        pOutput.accept(Items.POTATO_CHIP.get());
                        pOutput.accept(Items.NAQUADAH_CHIP.get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMPONENT_INEDIBLE =
            GTFO_TAB.register("inedible_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.PLASTIC_BAG.get()))
                    .title(Component.translatable("creativetab.gtfocomponentinedibletab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(Items.PLASTIC_BAG.get());
                    }))
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> INSTRUMENTS_AND_MACHINES =
            GTFO_TAB.register("tool_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.NAQUACHIP.get()))
                    .title(Component.translatable("creativetab.gtfoinstrumentsandmachinestab"))
                    .displayItems(((pParameters, pOutput) -> {
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        GTFO_TAB.register(eventBus);
    }
}
