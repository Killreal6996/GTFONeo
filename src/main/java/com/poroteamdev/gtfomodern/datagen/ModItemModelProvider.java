package com.poroteamdev.gtfomodern.datagen;

import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.blocks.crops.Seeds;
import com.poroteamdev.gtfomodern.item.Items;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GTFO.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        flatItem(Items.TOMATO.get(), "components/natural/tomato");
        flatItem(Items.NAQUACHIP.get(),"food/naquachip");
        flatItem(Seeds.TOMATO_SEEDS.get(),"crops/tomato_seeds");
        flatItem(Items.PEELED_POTATO.get(),"components/potato/peeled_potato");
        flatItem(Items.POTATO_CHIP.get(),"components/potato/potato_chip");
        flatItem(Items.NAQUADAH_CHIP.get(),"components/potato/naquadah_chip");
        flatItem(Items.PLASTIC_BAG.get(),"components/plastic_bag");
    }

    public ItemModelBuilder flatItem(Item item, String string) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        return withExistingParent(itemId.toString(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/"+string));
    }
}

