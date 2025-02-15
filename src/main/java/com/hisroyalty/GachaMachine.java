package com.hisroyalty;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hisroyalty.block.GachaMachineBlock;
import com.hisroyalty.block.GachaMachineBlockEntity;
import com.hisroyalty.item.GachaItemRegistry;
import com.hisroyalty.mixin.LootContextTypesAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

public class GachaMachine implements ModInitializer {
	public static final String MOD_ID = "gachamachine";

	public static final Path CONFIG_DIR = FabricLoader.getInstance().getConfigDir().resolve("gachamachine");
	public static final Path CONFIG_FILE = CONFIG_DIR.resolve("config.json");
	private static final Gson GSON = new Gson();
	public static final int DEFAULT_MAX_LEVELS = 3;


	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final Block GACHA_MACHINE = Registry.register(Registries.BLOCK, id("gacha_machine"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS, "gacha_machine", 1));

	//2-10
	public static final Block GACHA_MACHINE_2 = Registry.register(Registries.BLOCK, id("gacha_machine_2"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_2, "gacha_machine_2", 2));
	public static final Block GACHA_MACHINE_3 = Registry.register(Registries.BLOCK, id("gacha_machine_3"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_3, "gacha_machine_3", 3));
	public static final Block GACHA_MACHINE_4 = Registry.register(Registries.BLOCK, id("gacha_machine_4"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_4, "gacha_machine_4", 4));
	public static final Block GACHA_MACHINE_5 = Registry.register(Registries.BLOCK, id("gacha_machine_5"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_5, "gacha_machine_5", 5));
	public static final Block GACHA_MACHINE_6 = Registry.register(Registries.BLOCK, id("gacha_machine_6"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_6, "gacha_machine_6", 6));
	public static final Block GACHA_MACHINE_7 = Registry.register(Registries.BLOCK, id("gacha_machine_7"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_7, "gacha_machine_7", 7));
	public static final Block GACHA_MACHINE_8 = Registry.register(Registries.BLOCK, id("gacha_machine_8"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_8, "gacha_machine_8", 8));
	public static final Block GACHA_MACHINE_9 = Registry.register(Registries.BLOCK, id("gacha_machine_9"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_9, "gacha_machine_9", 9));
	public static final Block GACHA_MACHINE_10 = Registry.register(Registries.BLOCK, id("gacha_machine_10"),
			new GachaMachineBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).nonOpaque(), ModTags.Items.CURRENCY_ITEMS_10, "gacha_machine_10", 10));



	public static final BlockEntityType<GachaMachineBlockEntity> GACHA_MACHINE_BLOCK_ENTITY =
			register("gacha", GachaMachineBlockEntity::new, GACHA_MACHINE, GACHA_MACHINE_2, GACHA_MACHINE_3, GACHA_MACHINE_4, GACHA_MACHINE_5, GACHA_MACHINE_6, GACHA_MACHINE_7, GACHA_MACHINE_8, GACHA_MACHINE_9, GACHA_MACHINE_10);

	private static <T extends BlockEntity> BlockEntityType<T> register(String name,
																	   BlockEntityType.BlockEntityFactory<? extends T> entityFactory,
																	   Block... blocks) {
		Identifier id = id(name);
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
	}


	public static final RegistryKey<ItemGroup> GACHA_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), id("item_group"));
	public static final ItemGroup GACHA_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, GACHA_ITEM_GROUP_KEY,
			FabricItemGroup.builder().icon(() -> new ItemStack(GachaItemRegistry.GACHA_MACHINE)).displayName(Text.translatable("itemGroup.gacha_machines")).entries((c, e) -> {
				e.add(GachaItemRegistry.GACHA_MACHINE);
				e.add(GachaItemRegistry.GACHA_COIN);
				//e.add(GachaItemRegistry.RED_CAPSULE);
				//e.add(GachaItemRegistry.GREEN_CAPSULE);
				//e.add(GachaItemRegistry.YELLOW_CAPSULE);
				e.add(GachaItemRegistry.BASIC_CAPSULE);
				e.add(GachaItemRegistry.WOODEN_CAPSULE);
				e.add(GachaItemRegistry.STONE_CAPSULE);
				e.add(GachaItemRegistry.COPPER_CAPSULE);
				e.add(GachaItemRegistry.LAPIS_CAPSULE);
				e.add(GachaItemRegistry.IRON_CAPSULE);
				e.add(GachaItemRegistry.GOLD_CAPSULE);
				e.add(GachaItemRegistry.EMERALD_CAPSULE);
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

	public static void initConfig() {
		try {
			if (Files.notExists(CONFIG_DIR)) {
				Files.createDirectories(CONFIG_DIR);
			}
			if (Files.notExists(CONFIG_FILE)) {
				JsonObject defaultConfig = new JsonObject();
				for (int i = 1; i <= 10; i++) {
					defaultConfig.addProperty("maximum_currency_amount_" + i, 5);
				}
				Files.writeString(CONFIG_FILE, GSON.toJson(defaultConfig), StandardOpenOption.CREATE);
				System.out.println("Config file created: " + CONFIG_FILE);
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to initialize config", e);
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








