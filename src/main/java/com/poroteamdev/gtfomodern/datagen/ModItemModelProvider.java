package com.poroteamdev.gtfomodern.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.item.GTFOItems;
import com.poroteamdev.gtfomodern.item.GTFOSeeds;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GTFO.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // natural
        flatItem(GTFOItems.TOMATO.get(), "components/natural/tomato");
        flatItem(GTFOItems.BELLPEPPER.get(), "components/natural/bellpepper");
        flatItem(GTFOItems.PEPPERONCINI.get(), "components/natural/pepperoncini");
        flatItem(GTFOItems.BANANA_PEPPER.get(), "components/natural/banana_pepper");
        flatItem(GTFOItems.POBLANO.get(), "components/natural/poblano");
        flatItem(GTFOItems.JALAPENO.get(), "components/natural/jalapeno");
        flatItem(GTFOItems.SERRANO.get(), "components/natural/serrano");
        flatItem(GTFOItems.CAYENNE.get(), "components/natural/cayenne");
        flatItem(GTFOItems.THAI_PEPPER.get(), "components/natural/thai_pepper");
        flatItem(GTFOItems.HABANERO.get(), "components/natural/habanero");
        flatItem(GTFOItems.CAROLINA_REAPER.get(), "components/natural/carolina_reaper");
        // Food
        flatItem(GTFOItems.NAQUACHIP.get(), "food/naquachip");
        // Seeds
        flatItem(GTFOSeeds.TOMATO_SEEDS.get(), "crops/tomato_seeds");
        flatItem(GTFOSeeds.BELLPEPPER_SEEDS.get(), "crops/bellpepper_seeds");
        flatItem(GTFOSeeds.PEPPERONCHINI_SEEDS.get(), "crops/pepperonchini_seeds");
        flatItem(GTFOSeeds.BANANAPEPPER_SEEDS.get(), "crops/bananapepper_seeds");
        flatItem(GTFOSeeds.POBLANO_SEEDS.get(), "crops/poblano_seeds");
        flatItem(GTFOSeeds.SERRANO_SEEDS.get(), "crops/serrano_seeds");
        flatItem(GTFOSeeds.CAYENNEPEPPER_SEEDS.get(), "crops/cayennepepper_seeds");
        flatItem(GTFOSeeds.JALAPENO_SEEDS.get(), "crops/jalapeno_seeds");
        flatItem(GTFOSeeds.CAROLINAREAPER_SEEDS.get(), "crops/carolinareaper_seeds");
        flatItem(GTFOSeeds.THAIPEPPER_SEEDS.get(), "crops/thaipepper_seeds");
        flatItem(GTFOSeeds.HABANERO_SEEDS.get(), "crops/habanero_seeds");
        // Components
        flatItem(GTFOItems.PEELED_POTATO.get(), "components/potato/peeled_potato");
        flatItem(GTFOItems.POTATO_CHIP.get(), "components/potato/potato_chip");
        flatItem(GTFOItems.NAQUADAH_CHIP.get(), "components/potato/naquadah_chip");
        flatItem(GTFOItems.PLASTIC_BAG.get(), "components/plastic_bag");
    }

    public ItemModelBuilder flatItem(Item item, String string) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        return withExistingParent(itemId.toString(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + string));
    }
}
