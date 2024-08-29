package top.alittlebot.thinking.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {
    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;consume(ILnet/minecraft/world/entity/LivingEntity;)V"))
    private void consume(ItemStack instance, int amount, LivingEntity entity) {
        if (!(ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, instance) > 0)) {
            instance.consume(amount, entity);
        }
    }
    @Redirect(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V"))
    private void shrink(ItemStack instance, int amount) {
        if (!(ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, instance) > 0)) {
            instance.shrink(amount);
        }
    }
}
