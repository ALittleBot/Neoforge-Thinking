package top.alittlebot.thinking.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;

import static top.alittlebot.thinking.event.ServerChatEventHandler.efficiencyLevel;
import static top.alittlebot.thinking.event.ServerChatEventHandler.isEchoEnabled;

public class RepeaterToolItem extends Item {
    public RepeaterToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            isEchoEnabled = !isEchoEnabled;
            efficiencyLevel = ModEnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, player.getItemInHand(hand));
            Component statusMessage = isEchoEnabled ? Component.translatable("item.thinking.repeater_tool.enabled") : Component.translatable("item.thinking.repeater_tool.disabled");
            player.displayClientMessage(statusMessage, true);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
