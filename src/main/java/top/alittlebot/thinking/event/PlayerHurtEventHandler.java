package top.alittlebot.thinking.event;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;

@EventBusSubscriber(modid = Thinking.MODID)
public class PlayerHurtEventHandler {

    @SubscribeEvent()
    public static void onPlayerHurt(LivingDamageEvent.Post event) {
        // 检查是否是玩家受伤
        if (event.getEntity() instanceof Player player) {
            ItemStack itemstack = null;
            for (InteractionHand interactionhand : InteractionHand.values()) {
                ItemStack itemstack1 = player.getItemInHand(interactionhand);
                if (itemstack1.is(ModItems.BILI_COIN_ITEM.get())) {
                    itemstack = itemstack1.copy();
                    itemstack1.shrink(1);
                    break;
                }
            }
            if (itemstack != null) {
                if (player instanceof ServerPlayer serverplayer) {
                    serverplayer.awardStat(Stats.ITEM_USED.get(ModItems.BILI_COIN_ITEM.get()), 1);
                    CriteriaTriggers.USED_TOTEM.trigger(serverplayer, itemstack);
                    player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                }

                player.setHealth(1.0F);
                player.removeEffectsCuredBy(net.neoforged.neoforge.common.EffectCures.PROTECTED_BY_TOTEM);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ModItems.BILI_COIN_ITEM.get()));
            }
        }
    }
}
