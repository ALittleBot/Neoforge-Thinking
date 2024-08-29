package top.alittlebot.thinking.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.alittlebot.thinking.mixinhelper.InjectHelper;

@Mixin(SpawnEggItem.class)
public abstract class SpawnEggItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"))
    public void injectUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        if (level instanceof ServerLevel serverLevel) {
            ItemStack itemStack = context.getItemInHand();
            EntityType<?> entityType = this.getType(itemStack);

            // 获取附魔信息并将其添加到生成的实体中
            Mob entity = (Mob) entityType.spawn(serverLevel, itemStack, context.getPlayer(), context.getClickedPos(), MobSpawnType.SPAWN_EGG, true, false);
            if (entity != null) {
                // 将附魔信息添加到实体的NBT标签中
                this.thinking_NeoForge_1_21$addEnchantmentsToEntity(itemStack, entity);
            }
        }
    }

    @Unique
    private void thinking_NeoForge_1_21$addEnchantmentsToEntity(ItemStack itemStack, Entity entity) {
        if (entity instanceof Mob) {
            ListTag enchantmentList = InjectHelper.enchantmentsToNbtList(itemStack);
            CompoundTag entityTag = entity.getPersistentData();
            entityTag.put("Enchantments", enchantmentList);
            System.out.println(entityTag);
            entity.load(entityTag);
        }
    }

    // 获取物品的附魔信息的方法
    @Shadow
    public abstract EntityType<?> getType(ItemStack stack);
}