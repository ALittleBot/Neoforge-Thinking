package top.alittlebot.thinking.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(VaultServerData.class)
public interface VaultServerDataInvoker {
    @Invoker("setItemsToEject")
    void invokeSetItemsToEject(List<ItemStack> items);

    @Invoker("getNextItemToEject")
    ItemStack invokeGetNextItemToEject();

    @Invoker("pauseStateUpdatingUntil")
    void invokePauseStateUpdatingUntil(long time);
}
