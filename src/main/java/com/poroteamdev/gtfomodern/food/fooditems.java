package com.poroteamdev.gtfomodern.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class fooditems {
    public static final FoodProperties NAQUACHIP = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.2f).effect(() -> new
                    MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

}
