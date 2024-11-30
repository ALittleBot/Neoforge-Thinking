package top.alittlebot.thinking.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinusHealthToolItem extends Item {
    private static final Map<Player, Integer> playerUseCounts = new HashMap<>();

    public MinusHealthToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        // 获取玩家当前使用次数
        int useCount = playerUseCounts.getOrDefault(player, 0);

        // 增加计数器
        useCount++;

        // 如果是第三次使用物品，则让玩家死亡
        if (useCount == 3) {
            // 让玩家死亡，伤害等于当前血量
            player.hurt(player.damageSources().magic(), player.getHealth());

            // 重置计数器
            playerUseCounts.put(player, 0);  // 物品使用次数重置
        } else {
            // 如果不是第三次，正常伤害玩家 1 点血
            player.hurt(player.damageSources().magic(), 2);

            // 更新玩家使用计数
            playerUseCounts.put(player, useCount);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.thinking.minus_health_tool.desc"));
    }
}
