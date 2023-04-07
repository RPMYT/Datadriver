package io.github.rpmyt.finetune.mixin.mixins.late.botania.flower;

import io.github.rpmyt.finetune.FinetuneConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.block.subtile.generating.SubTileNarslimmus;

@Mixin(SubTileNarslimmus.class)
public class NarslimmusMixin {
    @Inject(method = "getMaxMana", at = @At("HEAD"), cancellable = true, remap = false)
    public void modify(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(FinetuneConfig.Botania.ManaCapacities.NARSLIMMUS);
    }

    @ModifyConstant(method = "onUpdate", constant = @Constant(intValue = 820), remap = false)
    private int modify(int generated) {
        return FinetuneConfig.Botania.GenerationAmounts.NARSLIMMUS;
    }
}
