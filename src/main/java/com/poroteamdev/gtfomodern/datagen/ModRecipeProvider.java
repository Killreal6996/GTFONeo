package com.poroteamdev.gtfomodern.datagen;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.material.GTFoods;
import com.gregtechceu.gtceu.data.recipe.GTRecipeTypes;
import com.poroteamdev.gtfomodern.GTFOMaterialHandler;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static com.gregtechceu.gtceu.data.material.GTMaterials.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        GTRecipeTypes.DISTILLERY_RECIPES.recipeBuilder("Test1")
                .inputFluids(Water.getFluid(1000))
                .outputFluids(GTFOMaterialHandler.ISOPROPYL_CHLORIDE.getFluid(1000))
                .duration(100).EUt(30)
                .save(pRecipeOutput);
        /*GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("gtfomodern:naqua_chips_recipe")
                .inputItems()*/
    }
}
