package com.poroteamdev.gtfomodern.datagen;

import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;
import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, GTFO.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeCrop(((CropBlock) CropBlocks.TOMATO_CROP.get()),
                "tomato_crop.stage", "tomato_crop.stage");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String texturename){
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((Tomato) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(GTFO.MODID,"block/crops/italianupdate/tomato/"+texturename+state.getValue(((Tomato) block).
                        getAgeProperty()))).renderType("cutout"));
        return models;
    }
}
