package com.poroteamdev.gtfomodern.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Fooditems {
    public static final FoodProperties NAQUACHIP = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1f)
            .build();
    public static final FoodProperties VEGETABLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2f)
            .build();
}