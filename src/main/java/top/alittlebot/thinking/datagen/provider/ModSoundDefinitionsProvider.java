package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.sound.ModSounds;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Thinking.MODID, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.BILI_COIN_THROW_SOUND, SoundDefinition.definition()
                .with(
                        sound("thinking:entity.bili_coin.throw")
                )
                .subtitle(ModSounds.BILI_COIN_THROW_TRANSLATE_KEY)
                .replace(true)
        );
    }
}
