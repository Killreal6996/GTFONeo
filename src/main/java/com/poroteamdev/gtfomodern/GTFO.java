package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.Platform;
import com.poroteamdev.gtfomodern.config.ConfigHolder;

import com.poroteamdev.gtfomodern.food.items;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(GTFO.MODID)
public class GTFO {
    public static final String MODID = "gtfomodern";
    public static final String NAME = "GregTechCEu";
    public static final Logger LOGGER = LogUtils.getLogger();
    public GTFO(IEventBus modEventBus) {
        ModTabs.register(modEventBus);
        items.register(modEventBus);
        ConfigHolder.init();
        GTFO.init();
        //modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);

    }
    public static void init() {
        LOGGER.info("{} is initializing on platform: {}", NAME, Platform.platformName());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}
    
    /*private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept((ItemLike) tools.NAQUACHIP);
        }
    }*/
    
    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, FormattingUtil.toLowerCaseUnder(path));
    }
    public static ResourceLocation appendId(String id) {
        String[] strings = new String[] { "gtceu", id };
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
