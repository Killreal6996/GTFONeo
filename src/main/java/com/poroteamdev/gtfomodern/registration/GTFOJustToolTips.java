package com.poroteamdev.gtfomodern.registration;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GTFOJustToolTips extends Item {

    private static final Map<Item, Supplier<Component>> ITEM_TOOLTIPS = new HashMap<>();

    public static void registerTooltip(Item items, Supplier<Component> tooltipSupplier) {
        ITEM_TOOLTIPS.put(items, tooltipSupplier);
    }

    public GTFOJustToolTips(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> tooltipComponents, TooltipFlag pTooltipFlag) {
        Supplier<Component> tooltipSupplier = ITEM_TOOLTIPS.get(pStack.getItem());
        if (tooltipSupplier != null) {
            tooltipComponents.add((tooltipSupplier.get()));
        }
        super.appendHoverText(pStack, pContext, tooltipComponents, pTooltipFlag);
    }
}
