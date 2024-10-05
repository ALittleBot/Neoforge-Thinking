package top.alittlebot.thinking.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GameCheckerToolItem extends Item {
    public GameCheckerToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (world.isClientSide()) {
            Minecraft.getInstance().setScreen(new DisconnectedScreen(Minecraft.getInstance().screen, Component.translatable("item.thinking.game_checker_tool.title"), Component.translatable("item.thinking.game_checker_tool.result")));
        }  // 实参 'Minecraft.getInstance().screen' 可能为null, 但是无视风险 ヾ(≧▽≦*)o
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
