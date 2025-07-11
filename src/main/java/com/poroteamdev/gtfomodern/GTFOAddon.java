package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

@SuppressWarnings("unused")
@com.gregtechceu.gtceu.api.addon.GTAddon
public class GTFOAddon  implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GTFO.REGISTRATE;
    }

    @Override
    public void registerTagPrefixes(){}

    @Override
    public void initializeAddon() {
        GTFO.LOGGER.info("GT Food Option modern addon has been loaded!");
    }

    @Override
    public String addonModId() {
        return GTFO.MODID;
    }

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {}
}
