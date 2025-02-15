package com.hisroyalty.sounds;

import com.hisroyalty.GachaMachine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class GachaSounds {
   // public static final SoundEvent !! = registerSoundEvent("!!");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = GachaMachine.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        GachaMachine.LOGGER.info("Registering Sounds for " + GachaMachine.MOD_ID);
    }
}
