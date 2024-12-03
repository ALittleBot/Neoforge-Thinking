package top.alittlebot.thinking.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static top.alittlebot.thinking.item.GameCrashToolItem.isEnabled;

@Mixin(Screen.class)
public abstract class WindowResizeDetectionMixin {
    @Inject(method = "resize", at = @At("HEAD"))
    private void onResize(Minecraft minecraft, int width, int height, CallbackInfo ci) {
        if (isEnabled) throw new RuntimeException("The game has been intentionally crashed by MC-276962 :-)");
    }
}
