package com.poroteamdev.gtfomodern.registration;


import me.shedaniel.rei.api.client.gui.widgets.TooltipContext;
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

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class GTFOSpicyFoodItems extends Item {
    private int spiciness;

    public GTFOSpicyFoodItems(Properties properties, int spiciness) {
        super(properties.food(createFood(spiciness)));
        this.spiciness = spiciness;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    private static FoodProperties createFood(int spiciness){
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.4f);

        if (spiciness > 0) {
            Holder<MobEffect> effect = getSpiciness(spiciness);
            builder.effect(
                    () -> new MobEffectInstance(effect, spiciness / 2000 * 20, 1), 1.0f);
        }

        return builder.build();
    }

    public static Holder<MobEffect> getSpiciness(int spiciness) {
        if ((spiciness >= 1_000) & (spiciness < 10_000)) {
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.FIRE_RESISTANCE.value());
        }

        if ((spiciness >= 10_000) & (spiciness < 100_000)) {
            return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.POISON.value());
        }
        return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(MobEffects.DIG_SLOWDOWN.value());

    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            applySpicyEffects(player, level);
        }
        return super.finishUsingItem(stack, level, entity);
    }

    public void applySpicyEffects(Player player, Level level){
        Holder<MobEffect> effect = getSpiciness(spiciness);
        player.addEffect(new MobEffectInstance(
                effect,
                1,
                1));
        if ((spiciness >= 100_000) & (spiciness <1_000_000)) {
            int instDamage = 1 + (spiciness - 100_000) / 200_000;
            player.hurt(player.damageSources().magic(), instDamage);
        }
        if ((spiciness >= 1_000_000) & (spiciness < 5_000_000)) {
            int fireTics = 2 + (spiciness / 1_000_000) *40;
            player.setRemainingFireTicks(fireTics);
        }
        if (spiciness >= 5_000_000) {
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

    private static final Map<Item, Supplier<Component>> ITEM_TOOLTIPS = new HashMap<>();

    public static void registerTooltip(Item items, Supplier<Component> tooltipSupplier) {
        ITEM_TOOLTIPS.put(items, tooltipSupplier);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> tooltipComponents, TooltipFlag pTooltipFlag) {
        Supplier<Component> anothertooltipSupplier = ITEM_TOOLTIPS.get(pStack.getItem());
        if (anothertooltipSupplier != null) {
            tooltipComponents.add((anothertooltipSupplier.get()));
        }
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
