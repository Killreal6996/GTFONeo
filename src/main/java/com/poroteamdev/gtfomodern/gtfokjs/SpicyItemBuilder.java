package com.poroteamdev.gtfomodern.gtfokjs;
import com.poroteamdev.gtfomodern.registration.GTFOSpicyFoodItems;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpicyItemBuilder extends ItemBuilder {
    private int kjsSpiciness;
    private int kjsNutrition = 4;
    private float kjsSaturation = 0.5f;
    private Item.Properties properties = new Item.Properties();

    public SpicyItemBuilder(ResourceLocation id){
        super(id);
    }

    public SpicyItemBuilder spiciness(int val){
        this.kjsSpiciness = val;
        return this;
    }

    public SpicyItemBuilder nutrition (int val){
        this.kjsNutrition = val;
        return this;
    }

    public SpicyItemBuilder saturation (float val){
        this.kjsSaturation = val;
        return this;
    }

    @Override
    public Item createObject(){
        return build();
    }

    public Item build(){
        FoodProperties foodProperties = new FoodProperties.Builder()
                .nutrition(kjsNutrition)
                .saturationModifier(kjsSaturation)
                .effect(() -> createSpicyEffect(kjsSpiciness), 1.0f)
                .build();

        return new GTFOSpicyFoodItems(properties.food(foodProperties), kjsSpiciness) {
            @Override
            public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
                if (!level.isClientSide && entity instanceof Player player) {
                    applySpicyEffects(player, level);
                }
                return super.finishUsingItem(itemStack, level, entity);
            }
        };
    }

    private MobEffectInstance createSpicyEffect(int spiciness) {
        Holder<MobEffect> effectHolder = GTFOSpicyFoodItems.getSpiciness(spiciness);
        //MobEffect effect = effectHolder.value();
        int duration = spiciness / 2000 * 20;
        return new MobEffectInstance(effectHolder, duration, 2);
    }

    private void applySpicyEffects(Player player, Level level){

        if ((kjsSpiciness >= 100_000) & (kjsSpiciness <1_000_000)) {
            int instDamage = 1 + (kjsSpiciness - 100_000) / 200_000;
            player.hurt(player.damageSources().magic(), instDamage);
        }
        if ((kjsSpiciness >= 1_000_000) & (kjsSpiciness < 5_000_000)) {
            int fireTics = 2 + (kjsSpiciness / 1_000_000) *40;
            player.setRemainingFireTicks(fireTics);
        }
        if (kjsSpiciness >= 5_000_000) {
            level.explode(null,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    Math.min(4.0f, kjsSpiciness / 1_000_000f),
                    Level.ExplosionInteraction.NONE);
        }
        if (kjsSpiciness >= 100_000) {
            player.setRemainingFireTicks(Math.min(20, kjsSpiciness / 25_000));
        }
    }
}
