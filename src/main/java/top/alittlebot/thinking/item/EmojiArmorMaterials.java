package top.alittlebot.thinking.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EmojiArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Thinking.MODID);
    public static final Holder<ArmorMaterial> EMOJI_ARMOR_MATERIAL =
            ARMOR_MATERIALS.register("smile_emoji", () -> new ArmorMaterial(
                    // Determines the defense value of this armor material, depending on what armor piece it is.
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 0);  // Emoji是没有防御点的 (～￣▽￣)～
                    }),
                    // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                    // Gold uses 25, we put copper slightly below that.
                    20,
                    // Determines the sound played when equipping this armor.
                    // This is wrapped with a Holder.
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    // Determines the repair item for this armor.
                    () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
                    // Determines the texture locations of the armor to apply when rendering
                    // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Thinking.MODID, "textures/item/smile_emoji.png"), "", false)
                    ),
                    // Returns the toughness value of the armor. The toughness value is an additional value included in
                    // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
                    // https://minecraft.wiki/w/Armor#Armor_toughness
                    // Only diamond and netherite have values greater than 0 here, so we just return 0.
                    0,
                    // Returns the knockback resistance value of the armor. While wearing this armor, the player is
                    // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
                    // from all armor pieces combined, they will not take any knockback at all.
                    // Only netherite has values greater than 0 here, so we just return 0.
                    0
            ));


    public static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String id, Map<ArmorItem.Type, Integer> defensePoints,
            int enchantability, Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredientSupplier,
            float toughness,
            float knockbackResistance,
            boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
                // 纹理层的 ID、后缀以及该层是否可染色。
                // 我们可以将盔甲材质 ID 作为纹理层 ID 传递。
                // 我们不需要后缀，因此我们将传递一个空字符串。
                // 我们将传递收到的可染色布尔值作为可染色参数。
                new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Thinking.MODID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.

        // 大多数时候，您会需要材质的 RegistryEntry - 尤其是对于 ArmorItem 构造函数。
        return ARMOR_MATERIALS.register(id, () -> material);
    }
}
