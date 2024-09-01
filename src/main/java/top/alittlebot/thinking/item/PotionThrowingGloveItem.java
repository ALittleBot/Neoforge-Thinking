package top.alittlebot.thinking.item;

import net.minecraft.world.InteractionResult;
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
import top.alittlebot.thinking.mixinhelper.InjectHelper;

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
                return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
            }
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(hand));
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

    private void throwPotion(Level level, Player player, ItemStack itemstack, InteractionHand hand) {
        int multishot = InjectHelper.getEnchantmentLevel(player.getItemInHand(hand), Enchantments.MULTISHOT);
        int power = InjectHelper.getEnchantmentLevel(player.getItemInHand(hand), Enchantments.POWER);
        if (multishot > 0) {
            for (int i = 0; i < multishot + 1; i++) {
                double offsetX = level.random.nextGaussian() * 0.1;
                double offsetY = level.random.nextGaussian() * 0.1;
                double offsetZ = level.random.nextGaussian() * 0.1;
                ThrownPotion potionEntity = new ThrownPotion(level, player);
                potionEntity.setItem(itemstack);
                potionEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F + (float) power * 0.1F, 1.0F);
                potionEntity.push(offsetX, offsetY, offsetZ);
                level.addFreshEntity(potionEntity);
            }
        } else {
            ThrownPotion potionEntity = new ThrownPotion(level, player);
            potionEntity.setItem(itemstack);
            potionEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F + (float) power * 0.1F, 1.0F); // 调整速度为2.0F，投掷更远
            level.addFreshEntity(potionEntity);
        }
        if (!player.isCreative() && !(ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, player.getItemInHand(hand)) > 0)) {
            itemstack.shrink(1);
        }
    }
}
