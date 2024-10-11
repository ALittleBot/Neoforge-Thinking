package top.alittlebot.thinking.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FrameToolItem extends Item {
    public FrameToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (world.isClientSide()) {
            EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
            boolean status = !dispatcher.shouldRenderHitBoxes();
            dispatcher.setRenderHitBoxes(status);
            if (status) {
                player.displayClientMessage(Component.translatable("item.thinking.frame_tool.enabled"), true);
            } else {
                player.displayClientMessage(Component.translatable("item.thinking.frame_tool.disabled"), true);
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
