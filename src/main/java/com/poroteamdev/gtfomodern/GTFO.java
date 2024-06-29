package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.Platform;
import com.poroteamdev.gtfomodern.config.ConfigHolder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.mojang.logging.LogUtils;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(GTFO.MODID)
public class GTFO {
    public static final String MODID = "gtfomodern";
    public static final String NAME = "GregTechCEu";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> BAG_OF_NAQUACHIPS = ITEMS.registerSimpleItem("bag_of_naquachips", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    public GTFO(IEventBus modEventBus) {
        ConfigHolder.init();
        GTFO.init();
    }
    public static void init() {
        LOGGER.info("{} is initializing on platform: {}", NAME, Platform.platformName());
    }

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
