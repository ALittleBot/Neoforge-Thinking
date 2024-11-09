package top.alittlebot.thinking.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ExitGameToolItem extends Item {
    public ExitGameToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        Minecraft minecraft = Minecraft.getInstance();
        if (world.isClientSide()) {
            if (minecraft.level != null) {
                minecraft.level.disconnect();
            }
            // minecraft.disconnect(new GenericMessageScreen(Component.translatable("menu.savingLevel")));
            minecraft.setScreen(new TitleScreen());
        }
        return InteractionResultHolder.pass(new ItemStack(ModItems.EXIT_GAME_TOOL_ITEM.get()));  // 瞎写一个, 又不是不能用 (●'◡'●)
    }
}
