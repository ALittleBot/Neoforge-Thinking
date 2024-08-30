package top.alittlebot.thinking.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;

// 还有多重射击没做 （；´д｀）ゞ

public class PotionThrowingGloveItem extends Item {
    public PotionThrowingGloveItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            ItemStack potionStack = findPotionInInventory(player);
            if (potionStack != null) {
                throwPotion(world, player, potionStack, hand);
                return new InteractionResultHolder<>(net.minecraft.world.InteractionResult.SUCCESS, player.getItemInHand(hand));
            }
        }
        return new InteractionResultHolder<>(net.minecraft.world.InteractionResult.FAIL, player.getItemInHand(hand));
    }

    private ItemStack findPotionInInventory(Player player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.getItem() == Items.SPLASH_POTION || stack.getItem() == Items.LINGERING_POTION) {
                return stack;
            }
        }
        return null;
    }

    private void throwPotion(Level world, Player player, ItemStack potionStack, InteractionHand hand) {
        ThrownPotion potionEntity = new ThrownPotion(world, player);
        potionEntity.setItem(potionStack);
        potionEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.0F); // 调整速度为2.0F，投掷更远
        world.addFreshEntity(potionEntity);
        if (!player.isCreative() && !(ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, player.getItemInHand(hand)) > 0)) {
            potionStack.shrink(1);
        }
    }
}
