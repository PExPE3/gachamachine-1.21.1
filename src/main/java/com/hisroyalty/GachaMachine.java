package com.hisroyalty;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hisroyalty.block.DummyGachaMachineBlock;
import com.hisroyalty.block.GachaMachineBlock;
import com.hisroyalty.item.GachaItemRegistry;
import com.hisroyalty.mixin.LootContextTypesAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class GachaMachine implements ModInitializer {
	public static final String MOD_ID = "gachamachine";



	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final Block GACHA_MACHINE = Registry.register(Registries.BLOCK, id("gacha_machine"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque()));

	public static final Block GACHA_MACHINE_DUMMY = Registry.register(Registries.BLOCK, id("dummy_gacha_machine"),
			new DummyGachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque()));
	public static final RegistryKey<ItemGroup> GACHA_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), id("item_group"));
	public static final ItemGroup GACHA_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, GACHA_ITEM_GROUP_KEY,
			FabricItemGroup.builder().icon(() -> new ItemStack(GachaItemRegistry.GACHA_MACHINE)).displayName(Text.translatable("itemGroup.gacha_machines")).entries((c, e) -> {
				e.add(GachaItemRegistry.GACHA_MACHINE);
				//e.add(GachaItemRegistry.RED_CAPSULE);
				//e.add(GachaItemRegistry.GREEN_CAPSULE);
				//e.add(GachaItemRegistry.YELLOW_CAPSULE);
				e.add(GachaItemRegistry.BASIC_CAPSULE);
				e.add(GachaItemRegistry.COPPER_CAPSULE);
				e.add(GachaItemRegistry.IRON_CAPSULE);
				e.add(GachaItemRegistry.DIAMOND_CAPSULE);
				e.add(GachaItemRegistry.NETHERITE_CAPSULE);
			}).build());



	public static final LootContextType GACHA_MACHINE_LOOT_CONTEXT = registerLootContext(id("gacha_machine"), b -> b.require(LootContextParameters.ORIGIN).require(LootContextParameters.THIS_ENTITY));
	public static final LootContextType CAPSULE_LOOT_CONTEXT = registerLootContext(id("capsule"), b -> b.require(LootContextParameters.ORIGIN).allow(LootContextParameters.THIS_ENTITY));


	@Override
	public void onInitialize() {
		GachaItemRegistry.init();
		initConfig();
	}

	public void initConfig() {
		File configDir = new File(FabricLoader.getInstance().getConfigDir().toFile(), "gachamachine");

		if (!configDir.exists() && !configDir.mkdirs()) {
			throw new RuntimeException("Failed to create config directory: " + configDir.getAbsolutePath());
		}

		File configFile = new File(configDir, "config.json");

		if (!configFile.exists()) {
			try {
				if (configFile.createNewFile()) {
					System.out.println("Config file created: " + configFile.getAbsolutePath());
				}
			} catch (IOException e) {
				throw new RuntimeException("Failed to create config file: " + configFile.getAbsolutePath(), e);
			}
		}
	}


	protected static LootContextType registerLootContext(Identifier id, Consumer<LootContextType.Builder> type) {
		LootContextType.Builder builder = new LootContextType.Builder();
		type.accept(builder);
		LootContextType lootContextType = builder.build();
		LootContextType check = LootContextTypesAccessor.getMAP().put(id, lootContextType);
		if (check != null) throw new IllegalStateException("Loot table parameter set " + id + " is already registered");
		return lootContextType;
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}


}








