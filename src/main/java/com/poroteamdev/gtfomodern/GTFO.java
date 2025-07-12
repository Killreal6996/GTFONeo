package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.material.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.Platform;
import com.poroteamdev.gtfomodern.blocks.machines.CheeseAgingFactoryController;
import com.poroteamdev.gtfomodern.config.ConfigHolder;

import com.poroteamdev.gtfomodern.blocks.crops.GTFOCropBlocks;
import com.poroteamdev.gtfomodern.item.GTFOSeeds;
import com.poroteamdev.gtfomodern.item.GTFOItems;
import com.poroteamdev.gtfomodern.registration.GTFOJustToolTips;
import com.poroteamdev.gtfomodern.registration.GTFOSpicyFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.spongepowered.asm.launch.platform.MixinPlatformAgentMinecraftForge;

@Mod(GTFO.MODID)
public class GTFO {
    public static final String MODID = "gtfomodern";
    public static final String NAME = "GregtechFoodOption";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static GTRegistrate REGISTRATE = GTRegistrate.create(GTFO.MODID);
    public GTFO(IEventBus modEventBus) {
        //Registering classes
        GTFOModTabs.register(modEventBus);

        GTFOItems.ITEMS.register(modEventBus);
        LOGGER.info("GTFO items registered");

        GTFOCropBlocks.BLOCKS.register(modEventBus);
        LOGGER.info("GTFO blocks registered");

        GTFOSeeds.ITEMS.register(modEventBus);
        LOGGER.info("GTFO seeds registered");

        //GTRegistration.REGISTRATE.registerRegistrate(modEventBus);
        //CheeseAgingFactoryController.init();
        ConfigHolder.init();
        GTFO.init();


        modEventBus.addListener(EventPriority.NORMAL, false, MaterialEvent.class, this::registerGTMaterials);
        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::registerMachines);

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
            LOGGER.info("Well, if you read this - GTFO mod still work!");

            GTFOJustToolTips.registerTooltip(GTFOItems.TOMATO.get(),
                    ()-> Component.translatable("tooltip.gtfomodern.tomato"));
            GTFOSpicyFoodItems.registerTooltip(GTFOItems.NAQUACHIP.get(),
                    () -> Component.translatable("tooltip.gtfomodern.naquachip"));
            LOGGER.info("Custom tooltips for GTFO items registered");
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

    private void registerMachines(GTCEuAPI.RegisterEvent event){
        if (event.getRegistry() == GTRegistries.MACHINES) {
            //CheeseAgingFactoryController.init();
        }
    }
}
