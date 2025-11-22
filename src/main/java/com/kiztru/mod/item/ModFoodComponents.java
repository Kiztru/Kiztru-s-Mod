package com.kiztru.mod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ARCHON_BREAD = new FoodComponent.Builder()
            .nutrition(20)
            .saturationModifier(1F)
            .statusEffect(new StatusEffectInstance
                    (StatusEffects.REGENERATION,20 * 10,0,false,false),1F)
            .statusEffect(new StatusEffectInstance
                    (StatusEffects.NAUSEA,20 * 10,0,false,false),1F)
            .build();
}
