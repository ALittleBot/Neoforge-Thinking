package top.alittlebot.thinking.event;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;
import top.alittlebot.thinking.enchantment.ModEnchantments;

@EventBusSubscriber(modid = Thinking.MODID)
public class RainingKnivesEnchantmentHandler {
    private static int timer = 0;

    @SubscribeEvent
    public static void onLivingUpdate(EntityTickEvent.Pre event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;
        if (timer <= 0) {
            timer = 20;
            Level level = entity.level();

            // 检查生物是否佩戴头盔并且头盔上有特定的附魔
            ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
            if (!helmet.isEmpty() && ModEnchantmentHelper.getEnchantmentLevel(ModEnchantments.RAINING_KNIVES, helmet) > 0) {
                BlockPos entityPos = entity.blockPosition();
                // 遍历以生物为中心，半径8格范围内的每一格
                for (int x = -4; x <= 4; x++) {
                    for (int z = -4; z <= 4; z++) {
                        BlockPos tridentPos = entityPos.offset(x, 5, z);  // 头顶5格处生成三叉戟

                        // 生成三叉戟实体
                        ThrownTrident trident = new ThrownTrident(level, entity, new ItemStack(Items.TRIDENT));

                        RandomSource random = RandomSource.create();
                        double offsetX = random.nextDouble() * 0.8 - 0.4;  // 设置x偏移
                        double offsetZ = random.nextDouble() * 0.8 - 0.4;  // 设置z偏移

                        Vec3 position = new Vec3(tridentPos.getX() + offsetX, tridentPos.getY(), tridentPos.getZ() + offsetZ);
                        trident.setPos(position);

                        // 设置三叉戟向下移动
                        Vec3 velocity = new Vec3(0, -1, 0);
                        trident.setDeltaMovement(velocity);

                        // 将三叉戟添加到世界中
                        level.addFreshEntity(trident);
                    }
                }
            }
        } else {
            timer -= 1;
        }
    }
}
