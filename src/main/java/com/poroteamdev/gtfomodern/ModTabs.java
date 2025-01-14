package com.poroteamdev.gtfomodern;

import com.poroteamdev.gtfomodern.food.items;
import com.poroteamdev.gtfomodern.crops.seeds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> GTFO_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GTFO.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD_TAB = GTFO_TAB.register("food_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(items.NAQUACHIP.get()))
                    .title(Component.translatable("creativetab.gtfofoodtab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(items.NAQUACHIP.get());
                        //pOutput.accept(items.TOMATO_SEEDS.get());
                    }))
                    .build());

    public static void  register(IEventBus eventBus) {
            GTFO_TAB.register(eventBus);
    }
}
