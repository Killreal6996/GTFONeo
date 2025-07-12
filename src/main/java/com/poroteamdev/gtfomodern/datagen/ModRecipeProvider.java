package com.poroteamdev.gtfomodern.datagen;



import com.gregtechceu.gtceu.data.recipe.GTRecipeTypes;
import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.GTFOMaterialHandler;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;


import static com.gregtechceu.gtceu.api.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.data.material.GTMaterials.*;
import static com.poroteamdev.gtfomodern.item.GTFOItems.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        GTFO.LOGGER.info("Generating GTFO recipes...");
        GTRecipeTypes.DISTILLERY_RECIPES.recipeBuilder("Test1")
                .inputFluids(Water.getFluid(1000))
                .outputFluids(GTFOMaterialHandler.ISOPROPYL_CHLORIDE.getFluid(1000))
                .duration(100).EUt(30)
                .save(pRecipeOutput);

        GTRecipeTypes.CUTTER_RECIPES.recipeBuilder("PeeledPotato")
                .inputItems(Items.POTATO)
                .inputFluids(Water.getFluid(250))
                .outputItems(PEELED_POTATO)
                .duration(10).EUt(30)
                .save(pRecipeOutput);

        GTRecipeTypes.CUTTER_RECIPES.recipeBuilder("PotatoChip")
                .inputItems(PEELED_POTATO)
                .outputItems(POTATO_CHIP, 30)
                .duration(20).EUt(30)
                .save(pRecipeOutput);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("NaquadahChip")
                .inputItems(POTATO_CHIP, 30)
                .inputItems(dust, Naquadah, 1)
                .outputItems(NAQUADAH_CHIP, 30)
                .duration(200).EUt(128)
                .save(pRecipeOutput);

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("PlasticBag")
                .inputItems(foil, Polyethylene, 2)
                .circuitMeta(20)
                .outputItems(PLASTIC_BAG)
                .duration(200).EUt(64)
                .save(pRecipeOutput);

        GTRecipeTypes.PACKER_RECIPES.recipeBuilder("NaquaChips")
                .inputItems(PLASTIC_BAG)
                .inputItems(NAQUADAH_CHIP, 60)
                .outputItems(NAQUACHIP)
                .duration(400).EUt(128)
                .save(pRecipeOutput);

        /*GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("gtfomodern:naqua_chips_recipe")
                .inputItems()*/

    }
}
