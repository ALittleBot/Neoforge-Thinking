package top.alittlebot.thinking.enchantment;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import top.alittlebot.thinking.Thinking;

public class ModEnchantments {

    public static final ResourceKey<Enchantment> AUTOMATIC = key("automatic");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> holderGetterItem = context.lookup(Registries.ITEM);
        register( // 全自动
                context,
                AUTOMATIC,
                Enchantment.enchantment(
                        Enchantment.definition(
                                holderGetterItem.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
                                2,
                                1,
                                Enchantment.constantCost(25),
                                Enchantment.constantCost(50),
                                8,
                                EquipmentSlotGroup.ANY
                        )
                )
        );
    }

    // 注册附魔的方法
    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }

    // 创建附魔资源键的方法
    private static ResourceKey<Enchantment> key(String name)
    {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Thinking.MODID, name));
    }
}
