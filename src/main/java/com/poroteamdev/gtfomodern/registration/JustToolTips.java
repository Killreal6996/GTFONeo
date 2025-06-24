package com.poroteamdev.gtfomodern.registration;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class JustToolTips extends Item {
    public JustToolTips(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> tooltipComponents, TooltipFlag pTooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.gtfomodern.naquachip"));
        super.appendHoverText(pStack, pContext, tooltipComponents, pTooltipFlag);
    }
}
