package top.alittlebot.thinking.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.entity.vault.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.alittlebot.thinking.enchantmentblock.BlockEnchantmentStorage;
import top.alittlebot.thinking.enchantment.ModEnchantmentHelper;

@Mixin(VaultBlockEntity.Server.class)
public class VaultBlockEntityServerMixin {

    @Redirect(method = "tryInsertKey", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;consume(ILnet/minecraft/world/entity/LivingEntity;)V"))
    private static void redirectConsumeMethod(ItemStack instance, int amount, LivingEntity entity) {
        if (!(ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, instance) > 0)) {
            instance.consume(amount, entity);
        }
    }

    @Inject(method = "isValidToInsert", at = @At("HEAD"), cancellable = true)
    private static void modifyIsValidToInsert(VaultConfig config, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (ModEnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0 && (stack.is(Items.TRIAL_KEY))) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "tryInsertKey",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/entity/vault/VaultServerData;addToRewardedPlayers(Lnet/minecraft/world/entity/player/Player;)V"),
            cancellable = true)
    private static void onAddToRewardedPlayers(ServerLevel level, BlockPos pos, BlockState state, VaultConfig config, VaultServerData serverData, VaultSharedData sharedData, Player player, ItemStack stack, CallbackInfo ci) {
        if (BlockEnchantmentStorage.getLevel(Enchantments.INFINITY, pos) > 0) {  // 十分感谢马夫鱼的方块存储附魔的代码 (●'◡'●)
            ci.cancel(); // 取消对 addToRewardedPlayers 的调用
        }
    }

    /*
    @Inject(method = "unlock", at = @At("HEAD"), cancellable = true)
    private static void injectUnlock(ServerLevel level, BlockState state, BlockPos pos, VaultConfig config, VaultServerData serverData, VaultSharedData sharedData, List<ItemStack> itemsToEject, CallbackInfo ci) {
        ((VaultServerDataInvoker) serverData).invokeSetItemsToEject(itemsToEject);

        // Keep setting the vault to UNLOCKING state indefinitely.
        sharedData.setDisplayItem(((VaultServerDataInvoker) serverData).invokeGetNextItemToEject());
        ((VaultServerDataInvoker) serverData).invokePauseStateUpdatingUntil(level.getGameTime() + 14L);

        // Check if the vault is already in the UNLOCKING state, if not, set it back to UNLOCKING.
        if (!state.getValue(VaultBlock.STATE).equals(VaultState.UNLOCKING)) {
            setVaultState(level, pos, state, (BlockState) state.setValue(VaultBlock.STATE, VaultState.UNLOCKING), config, sharedData);
        }
    }

    @Shadow
    static void setVaultState(ServerLevel level, BlockPos pos, BlockState oldState, BlockState newState, VaultConfig config, VaultSharedData sharedData) {
        VaultState vaultstate = (VaultState) oldState.getValue(VaultBlock.STATE);
        VaultState vaultstate1 = (VaultState) newState.getValue(VaultBlock.STATE);
        level.setBlock(pos, newState, 3);
        vaultstate.onTransition(level, pos, vaultstate1, config, sharedData, (Boolean) newState.getValue(VaultBlock.OMINOUS));
    }
     */
}

