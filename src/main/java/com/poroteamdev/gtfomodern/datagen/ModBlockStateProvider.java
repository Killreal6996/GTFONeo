package com.poroteamdev.gtfomodern.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import com.poroteamdev.gtfomodern.GTFO;
import com.poroteamdev.gtfomodern.blocks.crops.GTFOCropBlocks;
import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
import com.poroteamdev.gtfomodern.blocks.crops.spicyupdate.*;

import java.util.List;

import javax.annotation.Nullable;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(
            PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, GTFO.MODID, existingFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(GTFO.MODID, "block/" + path);
    }

    @Override
    protected void registerStatesAndModels() {
        this.stageBlock(GTFOCropBlocks.TOMATO_CROP.get(), Tomato.AGE, "italianupdate/", "tomato/");
        this.stageBlock(
                GTFOCropBlocks.BELLPEPER_CROP.get(), BellPepper.AGE, "spicyupdate/", "bellpepper/");
        this.stageBlock(
                GTFOCropBlocks.PEPPERONCHINI_CROP.get(),
                Pepperonchini.AGE,
                "spicyupdate/",
                "pepperonchini/");
        this.stageBlock(
                GTFOCropBlocks.BANANAPEPPER_CROP.get(), BananaPepper.AGE, "spicyupdate/", "bananapepper/");
        this.stageBlock(GTFOCropBlocks.POBLANO_CROP.get(), Poblano.AGE, "spicyupdate/", "poblano/");
        this.stageBlock(GTFOCropBlocks.SERRANO_CROP.get(), Serrano.AGE, "spicyupdate/", "serrano/");
        this.stageBlock(
                GTFOCropBlocks.CAYENNEPEPPER_CROP.get(),
                CayennePepper.AGE,
                "spicyupdate/",
                "cayennepepper/");
        this.stageBlock(GTFOCropBlocks.JALAPENO_CROP.get(), Jalapeno.AGE, "spicyupdate/", "jalapeno/");
        this.stageBlock(
                GTFOCropBlocks.THAIPEPPER_CROP.get(), ThaiPepper.AGE, "spicyupdate/", "thaipepper/");
        this.stageBlock(GTFOCropBlocks.HABANERO_CROP.get(), Habanero.AGE, "spicyupdate/", "habanero/");
        this.stageBlock(
                GTFOCropBlocks.CAROLINAREAPER_CROP.get(),
                CarolinaReaper.AGE,
                "spicyupdate/",
                "carolinareaper/");
    }

    // Got these methods from Farmer Delight repo
    // (https://github.com/vectorwing/FarmersDelight/blob/1.21/src/main/java/vectorwing/farmersdelight/data/BlockStates.java)
    public void customStageBlock(
            Block block,
            @Nullable ResourceLocation parent,
            String textureKey,
            IntegerProperty ageProperty,
            List<Integer> suffixes,
            Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(
                        state -> {
                            int ageSuffix = state.getValue(ageProperty);
                            String stageName = blockName(block) + ".stage";
                            stageName += suffixes.isEmpty()
                                    ? ageSuffix
                                    : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                            if (parent == null) {
                                return ConfiguredModel.builder()
                                        .modelFile(
                                                models().cross(stageName, resourceBlock(stageName)).renderType("cutout"))
                                        .build();
                            }
                            return ConfiguredModel.builder()
                                    .modelFile(models()
                                            .singleTexture(stageName, parent, textureKey, resourceBlock(stageName))
                                            .renderType("cutout"))
                                    .build();
                        },
                        ignored);
    }

    public void stageBlock(
            Block block,
            IntegerProperty ageProperty,
            String folder,
            String folder2,
            Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(
                        state -> {
                            int ageSuffix = state.getValue(ageProperty);
                            String stageName =
                                    "crops/" + folder + folder2 + blockName(block) + ".stage" + ageSuffix;
                            return ConfiguredModel.builder()
                                    .modelFile(
                                            models().cross(stageName, resourceBlock(stageName)).renderType("cutout"))
                                    .build();
                        },
                        ignored);
    }
}
