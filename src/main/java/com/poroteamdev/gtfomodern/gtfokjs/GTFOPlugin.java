package com.poroteamdev.gtfomodern.gtfokjs;

import dev.latvian.mods.kubejs.KubeJSPlugin;

import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import net.minecraft.core.registries.Registries;

public class GTFOPlugin implements KubeJSPlugin {
    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry){
        registry.of(Registries.ITEM, itemCallback -> {
            itemCallback.add("gtfo:spicy_food",SpicyItemBuilder.class, SpicyItemBuilder::new);
        });
    }

}
