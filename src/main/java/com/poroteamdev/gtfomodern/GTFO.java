package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.api.material.material.event.MaterialEvent;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.api.registry.*;
import com.lowdragmc.lowdraglib.Platform;
import com.poroteamdev.gtfomodern.config.ConfigHolder;

import com.poroteamdev.gtfomodern.blocks.crops.CropBlocks;
import com.poroteamdev.gtfomodern.blocks.crops.Seeds;
import com.poroteamdev.gtfomodern.item.Items;
import com.poroteamdev.gtfomodern.registration.JustToolTips;
import com.poroteamdev.gtfomodern.registration.SpicyFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(GTFO.MODID)
public class GTFO {
    public static final String MODID = "gtfomodern";
    public static final String NAME = "GregtechFoodOption";
    public static final Logger LOGGER = LogUtils.getLogger();
    public GTFO(IEventBus modEventBus) {
        //Registering classes
        ModTabs.register(modEventBus);
        Items.ITEMS.register(modEventBus);
        CropBlocks.BLOCKS.register(modEventBus);
        Seeds.ITEMS.register(modEventBus);

        modEventBus.addListener(this::registerGTMaterials);
        //Initializing
        ConfigHolder.init();
        GTFO.init();
        modEventBus.addListener(this::commonSetup);
    }

    private void registerGTMaterials(MaterialEvent event){
        GTFOMaterialHandler.init();
        LOGGER.info("Custom GTFO materials registered");
    }

    public static void init() {
        LOGGER.info("{} is initializing on platform: {}", NAME, Platform.platformName());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            JustToolTips.registerTooltip(Items.TOMATO.get(),
                    ()-> Component.translatable("tooltip.gtfomodern.tomato"));
            SpicyFoodItems.registerTooltip(Items.NAQUACHIP.get(),
                    () -> Component.translatable("tooltip.gtfomodern.naquachip"));
        });
    }
    
    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, FormattingUtil.toLowerCaseUnder(path));
    }

    public static ResourceLocation appendId(String id) {
        String[] strings = new String[] { "gtfomodern", id };
        int i = id.indexOf(':');
        if (i >= 0) {
            strings[1] = id.substring(i + 1);
            if (i >= 1) {
                strings[0] = id.substring(0, i);
            }
        }
        return ResourceLocation.fromNamespaceAndPath(strings[0], strings[1]);
    }

}
