package com.poroteamdev.gtfomodern.crops;



import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.print.attribute.standard.Copies;


public class CrobBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks("gtfomodern");

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    public static final DeferredHolder<Block, Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new Block (BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


    public static final DeferredHolder<Block, Block> MY_BETTER_BLOCK = BLOCKS.register(
            "my_better_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GRAVEL)
                    .lightLevel(state -> 7)
            ));
}
