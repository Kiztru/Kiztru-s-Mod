package com.kiztru.mod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class ModGlowingSwordItem extends SwordItem {
    public ModGlowingSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,20 * 15,0,false,false), attacker);
        if (!attacker.getWorld().isClient){
            World world = attacker.getWorld();

            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
            if(lightning != null) {
                lightning.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                world.spawnEntity(lightning);
            }
        }
        return super.postHit(stack, target, attacker);
    }


}
