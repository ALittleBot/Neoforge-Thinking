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

public class HandCheckerToolItem extends Item {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);  // Chat GPT 是这么写的, 面向AI编程 (●'◡'●)
    boolean isChecking = false;

    public HandCheckerToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            if (isChecking) {
                // 如果已经在检测中，直接返回
                return InteractionResultHolder.success(player.getItemInHand(InteractionHand.MAIN_HAND));
            }
            isChecking = true; // 设置状态为正在检测
            player.sendSystemMessage(Component.translatable("item.thinking.mouse_checker_tool.checking"));

            scheduler.schedule(() -> {
                // 获取主手物品
                ItemStack mainHandItem = player.getMainHandItem();
                // 获取副手物品
                ItemStack offHandItem = player.getOffhandItem();

                // 输出主手和副手的物品名称
                String empty = Component.translatable("item.thinking.hand_checker_tool.empty").getString();
                String mainHandName = mainHandItem.isEmpty() ? empty : mainHandItem.getHoverName().getString();
                String offHandName = offHandItem.isEmpty() ? empty : offHandItem.getHoverName().getString();

                // 向玩家发送消息
                player.sendSystemMessage(Component.literal(Component.translatable("item.thinking.hand_checker_tool.main_hand").getString() + mainHandName));
                player.sendSystemMessage(Component.literal(Component.translatable("item.thinking.hand_checker_tool.offhand").getString() + offHandName));
                isChecking = false; // 完成后重置状态
            }, 3, TimeUnit.SECONDS);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
