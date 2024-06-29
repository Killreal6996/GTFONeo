package com.poroteamdev.gtfomodern;

import com.poroteamdev.gtfomodern.config.ConfigHolder;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GTFO.MODID)
public class GTFO {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gtfomodern";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GTFO(IEventBus modEventBus) {
        ConfigHolder.init();
        
    }
}
