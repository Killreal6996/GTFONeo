package com.poroteamdev.gtfomodern.config;

import com.poroteamdev.gtfomodern.GTFO;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTFO.MODID)
public class ConfigHolder {

    public static ConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(ConfigHolder.class, ConfigFormats.yaml())
                    .getConfigInstance();
        }
    }
}
