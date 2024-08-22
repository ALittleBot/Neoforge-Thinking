package top.alittlebot.thinking.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;
import top.alittlebot.thinking.enchantment.ModEnchantments;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void onUse(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (ModEnchantmentHelper.getEnchantmentLevel(ModEnchantments.AUTOMATIC, itemstack) > 0) {
            ThrownTrident thrownTrident = new ThrownTrident(level, player, itemstack);
            thrownTrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
            thrownTrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            level.addFreshEntity(thrownTrident);
            cir.setReturnValue(InteractionResultHolder.consume(itemstack));
        }
    }
}

