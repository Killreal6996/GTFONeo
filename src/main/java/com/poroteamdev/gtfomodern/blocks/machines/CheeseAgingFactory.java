package com.poroteamdev.gtfomodern.blocks.machines;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;

public class CheeseAgingFactory extends MultiblockControllerMachine {

    private int humidity = 0;
    private int temperature = 12;

    public CheeseAgingFactory(IMachineBlockEntity holder) {
        super(holder);
    }
}
