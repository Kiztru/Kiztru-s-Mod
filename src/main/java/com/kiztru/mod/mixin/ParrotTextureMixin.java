package com.kiztru.mod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.render.entity.ParrotEntityRenderer;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ParrotEntityRenderer.class)
public abstract class ParrotTextureMixin {

    @ModifyReturnValue(
            method = "getTexture(Lnet/minecraft/entity/passive/ParrotEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN")
    )
    private Identifier modifyParrotTexture(Identifier original, ParrotEntity parrot) {

        if (parrot.getName().getString().equalsIgnoreCase("Lulu")) {
            return Identifier.of("kiztrusmod", "textures/entity/parrot/albino_parrot.png");
        }

        return original;
    }
}
