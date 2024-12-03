package top.alittlebot.thinking.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class GameCrashToolItem extends Item {
    public static boolean isEnabled = false;

    public GameCrashToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (world.isClientSide) {
            isEnabled = !isEnabled;
            if (isEnabled) {
                player.displayClientMessage(Component.translatable("item.thinking.game_crash_tool.enabled"), true);
            } else {
                player.displayClientMessage(Component.translatable("item.thinking.game_crash_tool.disabled"), true);
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
