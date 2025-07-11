package com.poroteamdev.gtfomodern.blocks.crops;

import com.poroteamdev.gtfomodern.blocks.crops.italyupdate.Tomato;
import com.poroteamdev.gtfomodern.blocks.crops.spicyupdate.*;
import com.poroteamdev.gtfomodern.item.GTFOSeeds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class GTFOCropBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("gtfomodern");

    //Italy update
    public static final DeferredBlock<Block> TOMATO_CROP = registerBlock("tomato_crop",
            () -> new Tomato(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    //Spicy update
    public static final DeferredBlock<Block> BELLPEPER_CROP = registerBlock("bellpepper_crop",
            () -> new BellPepper(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> PEPPERONCHINI_CROP = registerBlock("pepperonchini_crop",
            () -> new Pepperonchini(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> BANANAPEPPER_CROP = registerBlock("bananapepper_crop",
            () -> new BananaPepper(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> POBLANO_CROP = registerBlock("poblano_crop",
            () -> new Poblano(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> JALAPENO_CROP = registerBlock("jalapeno_crop",
            () -> new Jalapeno(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> SERRANO_CROP = registerBlock("serrano_crop",
            () -> new Serrano(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> CAYENNEPEPPER_CROP = registerBlock("cayennepepper_crop",
            () -> new CayennePepper(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> THAIPEPPER_CROP = registerBlock("thaipepper_crop",
            () -> new ThaiPepper(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> HABANERO_CROP = registerBlock("habanero_crop",
            () -> new Habanero(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

    public static final DeferredBlock<Block> CAROLINAREAPER_CROP = registerBlock("carolinareaper_crop",
            () -> new CarolinaReaper(BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM)));

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
        GTFOSeeds.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
