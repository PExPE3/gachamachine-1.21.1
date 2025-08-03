package com.hisroyalty.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;


import java.util.List;
import java.util.function.Consumer;


import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;

public class CommandLootEntry extends LeafEntry {
    public static final MapCodec<CommandLootEntry> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                    com.mojang.serialization.Codec.STRING.fieldOf("command").forGetter(e -> e.command)
            ).and(LeafEntry.addLeafFields(instance)).apply(instance, CommandLootEntry::new));
    private final String command;

    public CommandLootEntry(String command, int weight, int quality, List<LootCondition> conditions, List<LootFunction> functions) {
        super(weight, quality, conditions, functions);
        this.command = command;
    }

    @Override
    protected void generateLoot(Consumer<ItemStack> lootConsumer, LootContext context) {
        World world = context.getWorld();
        if (!(world instanceof ServerWorld serverWorld)) return;

        MinecraftServer server = serverWorld.getServer();
        Vec3d origin = context.get(LootContextParameters.ORIGIN);
        // BlockPos pos = BlockPos.ofFloored(origin);

        ServerCommandSource source = new ServerCommandSource(
                CommandOutput.DUMMY,
                origin,
                Vec2f.ZERO,
                serverWorld,
                2,
                "LootCommand",
                Text.literal("LootCommand"),
                server,
                null
        );

        try {
            server.getCommandManager().executeWithPrefix(source, command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LootPoolEntryType getType() {
        return ModLootTypes.COMMAND_ENTRY;
    }
}
