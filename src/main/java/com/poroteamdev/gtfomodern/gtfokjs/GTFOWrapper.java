package com.poroteamdev.gtfomodern.gtfokjs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import com.poroteamdev.gtfomodern.registration.GTFOSpicyFoodItems;

public class GTFOWrapper {
    public static Item createSpicyItem(int spiciness, int nutrition, float saturation) {
        ResourceLocation tempID = ResourceLocation.parse("gtfomodern:temp_spicyfood");

        return new SpicyItemBuilder(tempID)
                .spiciness(spiciness)
                .nutrition(nutrition)
                .saturation(saturation)
                .build();
    }

    public static void addSpicyToItem(ItemStack stack, Player player, Level level) {
        if (stack.getItem() instanceof GTFOSpicyFoodItems GTFOSpicyFoodItems) {
            GTFOSpicyFoodItems.applySpicyEffects(player, level);
        }
    }
}
