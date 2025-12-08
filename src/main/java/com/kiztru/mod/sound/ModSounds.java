package com.kiztru.mod.sound;

import com.kiztru.mod.KiztrusMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent REMEMBER_US;
    public static final SoundEvent MY_PEOPLE;
    public static final RegistryKey<JukeboxSong> REMEMBER_US_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG,
            Identifier.of(KiztrusMod.MOD_ID,"remember_us"));

    static {
        REMEMBER_US = registerSoundEvent("remember_us");
        MY_PEOPLE = registerSoundEvent("my_people");
    }

    public static final RegistryKey<JukeboxSong> MY_PEOPLE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG,
                    Identifier.of(KiztrusMod.MOD_ID,"my_people"));


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(KiztrusMod.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        KiztrusMod.LOGGER.info("Registering Mod Sounds for " + KiztrusMod.MOD_ID);
    }
}
