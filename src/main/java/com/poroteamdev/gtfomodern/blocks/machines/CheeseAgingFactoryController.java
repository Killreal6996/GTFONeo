package com.poroteamdev.gtfomodern.blocks.machines;


import com.gregtechceu.gtceu.api.RotationState;
import com.gregtechceu.gtceu.api.block.IMachineBlock;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.multiblock.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.common.registry.GTRegistration;

import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.multiblock.Predicates.blocks;
import static com.gregtechceu.gtceu.data.block.GTBlocks.*;

public class CheeseAgingFactoryController {

    private static MultiblockMachineDefinition CHEESE_AGING_FACTORY;

            public static void init() {
                if (GTRegistration.REGISTRATE == null) {
                    throw new IllegalStateException("GTRegistration.REGISTRATE is not initialized!");
                }
            //LITTLE BROKE BRO
            GTRegistration.REGISTRATE
                    .multiblock("cheese_aging_factory", CheeseAgingFactory::new)
                    .rotationState(RotationState.ALL)
                    .appearanceBlock(CASING_BRONZE_BRICKS)
                    .pattern(definition -> FactoryBlockPattern.start()
                            .aisle("XXX","XXX","XXX")
                            .aisle("XXX","XXX","XXX")
                            .aisle("XXX","XZX","XXX")
                            .where('X', blocks((IMachineBlock) CASING_BRONZE_BRICKS))
                            .where('Z', Predicates.controller(blocks(definition.getBlock())))
                            .build())
                    .tooltips(Component.translatable("tooltip.gtfomodern.cheese_aging_factory"))
                    .register();
    }
    //private CheeseAgingFactoryController() {}
    public static MultiblockMachineDefinition getDefinition() {
        return CHEESE_AGING_FACTORY;
    }
}
