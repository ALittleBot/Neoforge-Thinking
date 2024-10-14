package top.alittlebot.thinking.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MouseCheckerToolItem extends Item {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);  // Chat GPT 是这么写的, 面向AI编程 (●'◡'●)
    boolean isChecking = false;
    public MouseCheckerToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        return initiateCheck(player);
    }

    private InteractionResultHolder<ItemStack> initiateCheck(Player player) {
        if (isChecking) {
            // 如果已经在检测中，直接返回
            return InteractionResultHolder.success(player.getItemInHand(InteractionHand.MAIN_HAND));
        }

        isChecking = true; // 设置状态为正在检测
        player.sendSystemMessage(Component.translatable("item.thinking.mouse_checker_tool.checking"));

        // 三秒后发送检测结果
        scheduler.schedule(() -> {
            player.sendSystemMessage(Component.translatable("item.thinking.mouse_checker_tool.result"));
            isChecking = false; // 完成后重置状态
        }, 3, TimeUnit.SECONDS);

        return InteractionResultHolder.success(player.getItemInHand(InteractionHand.MAIN_HAND));
    }
}
