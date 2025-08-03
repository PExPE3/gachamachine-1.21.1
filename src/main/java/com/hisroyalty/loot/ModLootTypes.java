package com.hisroyalty.loot;

import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModLootTypes {
    public static final LootPoolEntryType COMMAND_ENTRY = new LootPoolEntryType(CommandLootEntry.CODEC);

    public static void register() {
        Registry.register(
                Registries.LOOT_POOL_ENTRY_TYPE,
                Identifier.of("gachamachine", "command_entry"),
                COMMAND_ENTRY
        );
    }
}
