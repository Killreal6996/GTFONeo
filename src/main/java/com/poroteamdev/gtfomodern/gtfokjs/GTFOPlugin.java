package com.poroteamdev.gtfomodern.gtfokjs;

import net.minecraft.core.registries.Registries;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;

public class GTFOPlugin implements KubeJSPlugin {
    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry) {
        registry.of(Registries.ITEM, itemCallback -> {
            itemCallback.add("gtfo:spicy_food", SpicyItemBuilder.class, SpicyItemBuilder::new);
        });
    }
}
