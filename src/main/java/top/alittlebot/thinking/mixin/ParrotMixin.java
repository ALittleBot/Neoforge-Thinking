package top.alittlebot.thinking.mixin;

import net.minecraft.world.entity.animal.Parrot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Parrot.class)
public class ParrotMixin {
    @Inject(at = @At("HEAD"), method = "isPartyParrot", cancellable = true)
    private void isPartyParrot(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
