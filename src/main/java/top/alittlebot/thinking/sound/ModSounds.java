package top.alittlebot.thinking.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Thinking.MODID);

    public static final String BILI_COIN_THROW_TRANSLATE_KEY = "subtitles.entity.bili_coin.throw";

    public static final DeferredHolder<SoundEvent, SoundEvent> BILI_COIN_THROW_SOUND = SOUNDS.register(
            "entity.bili_coin.throw",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thinking.MODID, "entity.bili_coin.throw"))
    );
}
