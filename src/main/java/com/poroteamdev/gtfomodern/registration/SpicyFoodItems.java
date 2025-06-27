package com.poroteamdev.gtfomodern.registration;


import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;


public class SpicyFoodItems extends Item {
    private final int spiciness;

    public SpicyFoodItems(Properties properties, int spiciness) {
        super(properties.food(createFood(spiciness)));
        this.spiciness = spiciness;
    }

    private static FoodProperties createFood(int spiciness){
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.6f);

        if (spiciness > 0) {
            Holder<MobEffect> effect = getSpiciness(spiciness);
            builder.effect(
                    () -> new MobEffectInstance(effect, spiciness / 1000 * 20, 1), 1.0f);
        }

        return builder.build();
    }

    private static Holder<MobEffect> getSpiciness(int spiciness) {
        if (spiciness >= 2_000_000)
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.WITHER.value());
        if (spiciness >= 500_000)
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.POISON.value());
        if (spiciness >= 100_000)
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.CONFUSION.value());
        if (spiciness >= 50_000)
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.FIRE_RESISTANCE.value());

        return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.DIG_SLOWDOWN.value());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            applySpicyEffects(player, level);
        }
        return super.finishUsingItem(stack, level, entity);
    }

    private void applySpicyEffects(Player player, Level level){
        Holder<MobEffect> effect = getSpiciness(spiciness);
        player.addEffect(new MobEffectInstance(
                effect,
                1,
                1));
        if (spiciness >= 500_000) {
            level.explode(null,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    Math.min(4.0f, spiciness / 1_000_000f),
                    Level.ExplosionInteraction.NONE);
        }
        if (spiciness >= 100_000) {
            player.setRemainingFireTicks(Math.min(20, spiciness / 25_000));
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> tooltipComponents, TooltipFlag pTooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.gtfomodern.naquachip"));
        if (spiciness > 0) {
            tooltipComponents.add(Component.empty());
            Component spicyText = Component.translatable("tooltip.gtfomodern.spiciness",
                            spiciness / 1000 + "K SHU")
                    .withStyle(ChatColorFromSpiciness(spiciness));
            tooltipComponents.add(spicyText);
        }
        super.appendHoverText(pStack, pContext, tooltipComponents, pTooltipFlag);
    }

    private ChatFormatting ChatColorFromSpiciness(int shu){
        if (shu < 10_000) return ChatFormatting.GREEN;
        if (shu < 20_000) return ChatFormatting.YELLOW;
        if (shu < 50_000) return ChatFormatting.GOLD;
        if (shu < 1_000_000) return ChatFormatting.RED;
        return ChatFormatting.DARK_RED;
    }
}
