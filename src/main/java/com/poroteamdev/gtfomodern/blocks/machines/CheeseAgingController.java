package com.poroteamdev.gtfomodern.blocks.machines;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.research.DataBankMachine;
import net.minecraft.ResourceLocationException;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;


public class CheeseAgingController {
    private static final ResourceLocation MACHINE_ID =
            ResourceLocation.fromNamespaceAndPath("gtfomodern", "cheese_aging_factory");

    public static final MachineDefinition DEFINITION = registerMachine();

    private MachineDefinition registerMachine() {
        MultiblockMachineDefinition definition = MultiblockMachineDefinition
                .setTooltipBuilder((stack, tooltip) -> {
                    tooltip.add(Component.translatable("tooltip.gtfomodern.cheese_aging_factory"));
                });
    }
    DataBankMachine
}
