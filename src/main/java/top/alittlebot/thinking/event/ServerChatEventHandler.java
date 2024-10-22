package top.alittlebot.thinking.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;
import top.alittlebot.thinking.Thinking;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@EventBusSubscriber(modid = Thinking.MODID)
public class ServerChatEventHandler {
    public static boolean isEchoEnabled = false;
    public static int efficiencyLevel = 0;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @SubscribeEvent
    public static void onPlayerChat(ServerChatEvent event) {
        ServerPlayer player = event.getPlayer();
        if (isEchoEnabled) {
            String originalMessage = event.getMessage().getString();
            Component repeatMessage = Component.literal(originalMessage);
            Random random = new Random();
            player.displayClientMessage(Component.translatable("item.thinking.repeater_tool.repeating"), true);
            int wait_time = Math.max(7 - efficiencyLevel, 1);
            scheduler.schedule(() -> {
                Objects.requireNonNull(player.getServer()).getPlayerList().broadcastSystemMessage(repeatMessage, false);
                player.displayClientMessage(Component.translatable("item.thinking.repeater_tool.repeat_successfully"), true);
            }, random.nextInt(wait_time) + 1, TimeUnit.SECONDS);
        }
    }
}
