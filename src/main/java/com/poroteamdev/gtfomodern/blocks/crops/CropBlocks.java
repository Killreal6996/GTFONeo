package com.poroteamdev.gtfomodern.blocks.crops;

import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class CropBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("gtfomodern");


    public static final DeferredBlock<Block> TOMATO_CROP = registerBlock("tomato_crop",
            () -> new Tomato(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    /*public static final DeferredHolder<Block, Block> MY_BETTER_BLOCK = BLOCKS.register(
            "my_better_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GRAVEL)
                    .lightLevel(state -> 7)));
*/
    private static <T extends Block>  DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Seeds.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
