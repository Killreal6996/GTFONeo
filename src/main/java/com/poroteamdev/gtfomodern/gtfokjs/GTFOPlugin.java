package com.poroteamdev.gtfomodern.gtfokjs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.bindings.event.ItemEvents;
import dev.latvian.mods.kubejs.event.KubeEvent;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import com.gregtechceu.gtceu.integration.kjs.events.*;

public class GTFOPlugin implements KubeJSPlugin {
    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry){
        registry.of(Registries.ITEM, itemCallback -> {
            itemCallback.add("gtfo:spicy_food",SpicyItemBuilder.class, SpicyItemBuilder::new);
        });
    }

}
