package com.poroteamdev.gtfomodern.datagen;

import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.item.Items;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GTFO.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    //basicItem(Items.TOMATO.get());
    }
}
