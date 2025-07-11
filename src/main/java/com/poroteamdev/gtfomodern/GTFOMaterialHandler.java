package com.poroteamdev.gtfomodern;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.data.material.GTMaterials;
import com.gregtechceu.gtceu.api.fluid.FluidBuilder;
import com.gregtechceu.gtceu.api.fluid.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluid.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.material.material.Material;

import javax.annotation.PropertyKey;

import static com.gregtechceu.gtceu.api.material.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.data.material.GTMaterials.*;

public class GTFOMaterialHandler {
    public static void init(){
        //Don't pay attention, use it for tests
        System.out.println("Material registred: " + ISOPROPYL_CHLORIDE.getFluid()); // Должно быть true
        System.out.println("Fluid exists? " + (ISOPROPYL_CHLORIDE.getFluid() != null));
    }

        public static final Material ISOPROPYL_CHLORIDE = new Material.Builder(GTFO.id("isopropyl_chloride"))
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7FB7D4)
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(CH3)2CHl",true);
    }
