package top.alittlebot.thinking.mixin;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;
import top.alittlebot.thinking.enchantment.ModEnchantments;
import top.alittlebot.thinking.mixinhelper.InjectHelper;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void onUse(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        ItemStack itemstack = player.getItemInHand(hand);
        if ((ModEnchantmentHelper.getEnchantmentLevel(ModEnchantments.AUTOMATIC, itemstack) > 0)) {
            ThrownTrident thrownTrident = new ThrownTrident(level, player, itemstack);
            thrownTrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
            thrownTrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;  // 只有创造模式下才能捡起

            int k = InjectHelper.getEnchantmentLevel(itemstack, Enchantments.MULTISHOT);
            if (k > 0) {
                for (int i = 0; i < k + 1; i++) {//抛出m+2个鱼钩，存放在1至m中
                    // 生成随机偏移速度
                    double offsetX = level.random.nextGaussian() * 0.1;
                    double offsetY = level.random.nextGaussian() * 0.1;
                    double offsetZ = level.random.nextGaussian() * 0.1;
                    // 创建带有随机偏移速度的鱼竿实体
                    int j = InjectHelper.getEnchantmentLevel(itemstack, Enchantments.RIPTIDE);
                    ThrownTrident tridentEntity = new ThrownTrident(level, player, itemstack);
                    tridentEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float) j * 0.5F, 1.0F);
                    tridentEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    tridentEntity.push(offsetX, offsetY, offsetZ);
                    level.addFreshEntity(tridentEntity);
                }
            } else {
                level.addFreshEntity(thrownTrident);
                itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
                Holder<SoundEvent> holder = EnchantmentHelper.pickHighestLevel(itemstack, EnchantmentEffectComponents.TRIDENT_SOUND)
                        .orElse(SoundEvents.TRIDENT_THROW);
                level.playSound(null, player, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                cir.setReturnValue(InteractionResultHolder.consume(itemstack));
            }
        }
    }

    /*
    @Inject(method = "releaseUsing", at = @At("HEAD"))
    public void onUse(ItemStack itemstack, Level level, LivingEntity entityLiving, int timeLeft, CallbackInfo cir) {
        if (entityLiving instanceof Player player &&
                (ModEnchantmentHelper.getEnchantmentLevel(ModEnchantments.AUTOMATIC, itemstack) > 0)
                && (ModEnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, itemstack) > 0)) {
            if (ModEnchantmentHelper.getEnchantmentLevel(ModEnchantments.AUTOMATIC, itemstack) > 0) {
                ThrownTrident thrownTrident = new ThrownTrident(level, player, itemstack);
                thrownTrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                thrownTrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;  // 只有创造模式下才能捡起
                level.addFreshEntity(thrownTrident);
                itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));

                Holder<SoundEvent> holder = EnchantmentHelper.pickHighestLevel(itemstack, EnchantmentEffectComponents.TRIDENT_SOUND)
                        .orElse(SoundEvents.TRIDENT_THROW);
                level.playSound(null, player, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }
     */

}

