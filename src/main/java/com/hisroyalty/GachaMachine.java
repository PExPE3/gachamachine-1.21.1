package com.hisroyalty;

import com.hisroyalty.block.GachaMachineBlock;
import com.hisroyalty.block.GachaMachineBlockEntity;
import com.hisroyalty.config.DatapackConfig;
import com.hisroyalty.item.GachaItemRegistry;
import com.hisroyalty.loot.ModLootTypes;
import com.hisroyalty.mixin.LootContextTypesAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
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
import net.minecraft.resource.ResourceType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class GachaMachine implements ModInitializer {
	public static final String MOD_ID = "gachamachine";

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
				e.add(GachaItemRegistry.GACHA_MACHINE_2);
				e.add(GachaItemRegistry.GACHA_MACHINE_3);
				e.add(GachaItemRegistry.GACHA_MACHINE_4);
				e.add(GachaItemRegistry.GACHA_MACHINE_5);
				e.add(GachaItemRegistry.GACHA_MACHINE_6);
				e.add(GachaItemRegistry.GACHA_MACHINE_7);
				e.add(GachaItemRegistry.GACHA_MACHINE_8);
				e.add(GachaItemRegistry.GACHA_MACHINE_9);
				e.add(GachaItemRegistry.GACHA_MACHINE_10);
				e.add(GachaItemRegistry.GACHA_COIN);
				e.add(GachaItemRegistry.GACHA_COIN_2);
				e.add(GachaItemRegistry.GACHA_COIN_3);
				e.add(GachaItemRegistry.GACHA_COIN_4);
				e.add(GachaItemRegistry.GACHA_COIN_5);
				e.add(GachaItemRegistry.GACHA_COIN_6);
				e.add(GachaItemRegistry.GACHA_COIN_7);
				e.add(GachaItemRegistry.GACHA_COIN_8);
				e.add(GachaItemRegistry.GACHA_COIN_9);
				e.add(GachaItemRegistry.GACHA_COIN_10);


				e.add(GachaItemRegistry.WOODEN_CAPSULE);
				e.add(GachaItemRegistry.STONE_CAPSULE);
				e.add(GachaItemRegistry.COPPER_CAPSULE);
				e.add(GachaItemRegistry.IRON_CAPSULE);
				e.add(GachaItemRegistry.GOLD_CAPSULE);
				e.add(GachaItemRegistry.LAPIS_CAPSULE);
				e.add(GachaItemRegistry.RUBY_CAPSULE);
				e.add(GachaItemRegistry.EMERALD_CAPSULE);
				e.add(GachaItemRegistry.DIAMOND_CAPSULE);
				e.add(GachaItemRegistry.NETHERITE_CAPSULE);

				e.add(GachaItemRegistry.CAPSULE_B1);
				e.add(GachaItemRegistry.CAPSULE_B2);
				e.add(GachaItemRegistry.CAPSULE_B3);
				e.add(GachaItemRegistry.CAPSULE_B4);
				e.add(GachaItemRegistry.CAPSULE_B5);
				e.add(GachaItemRegistry.CAPSULE_B6);
				e.add(GachaItemRegistry.CAPSULE_B7);
				e.add(GachaItemRegistry.CAPSULE_B8);
				e.add(GachaItemRegistry.CAPSULE_B9);
				e.add(GachaItemRegistry.CAPSULE_B10);

				e.add(GachaItemRegistry.CAPSULE_C1);
				e.add(GachaItemRegistry.CAPSULE_C2);
				e.add(GachaItemRegistry.CAPSULE_C3);
				e.add(GachaItemRegistry.CAPSULE_C4);
				e.add(GachaItemRegistry.CAPSULE_C5);
				e.add(GachaItemRegistry.CAPSULE_C6);
				e.add(GachaItemRegistry.CAPSULE_C7);
				e.add(GachaItemRegistry.CAPSULE_C8);
				e.add(GachaItemRegistry.CAPSULE_C9);
				e.add(GachaItemRegistry.CAPSULE_C10);

				e.add(GachaItemRegistry.CAPSULE_D1);
				e.add(GachaItemRegistry.CAPSULE_D2);
				e.add(GachaItemRegistry.CAPSULE_D3);
				e.add(GachaItemRegistry.CAPSULE_D4);
				e.add(GachaItemRegistry.CAPSULE_D5);
				e.add(GachaItemRegistry.CAPSULE_D6);
				e.add(GachaItemRegistry.CAPSULE_D7);
				e.add(GachaItemRegistry.CAPSULE_D8);
				e.add(GachaItemRegistry.CAPSULE_D9);
				e.add(GachaItemRegistry.CAPSULE_D10);

				e.add(GachaItemRegistry.CAPSULE_E1);
				e.add(GachaItemRegistry.CAPSULE_E2);
				e.add(GachaItemRegistry.CAPSULE_E3);
				e.add(GachaItemRegistry.CAPSULE_E4);
				e.add(GachaItemRegistry.CAPSULE_E5);
				e.add(GachaItemRegistry.CAPSULE_E6);
				e.add(GachaItemRegistry.CAPSULE_E7);
				e.add(GachaItemRegistry.CAPSULE_E8);
				e.add(GachaItemRegistry.CAPSULE_E9);
				e.add(GachaItemRegistry.CAPSULE_E10);

				e.add(GachaItemRegistry.CAPSULE_F1);
				e.add(GachaItemRegistry.CAPSULE_F2);
				e.add(GachaItemRegistry.CAPSULE_F3);
				e.add(GachaItemRegistry.CAPSULE_F4);
				e.add(GachaItemRegistry.CAPSULE_F5);
				e.add(GachaItemRegistry.CAPSULE_F6);
				e.add(GachaItemRegistry.CAPSULE_F7);
				e.add(GachaItemRegistry.CAPSULE_F8);
				e.add(GachaItemRegistry.CAPSULE_F9);
				e.add(GachaItemRegistry.CAPSULE_F10);

				e.add(GachaItemRegistry.CAPSULE_G1);
				e.add(GachaItemRegistry.CAPSULE_G2);
				e.add(GachaItemRegistry.CAPSULE_G3);
				e.add(GachaItemRegistry.CAPSULE_G4);
				e.add(GachaItemRegistry.CAPSULE_G5);
				e.add(GachaItemRegistry.CAPSULE_G6);
				e.add(GachaItemRegistry.CAPSULE_G7);
				e.add(GachaItemRegistry.CAPSULE_G8);
				e.add(GachaItemRegistry.CAPSULE_G9);
				e.add(GachaItemRegistry.CAPSULE_G10);

				e.add(GachaItemRegistry.CAPSULE_H1);
				e.add(GachaItemRegistry.CAPSULE_H2);
				e.add(GachaItemRegistry.CAPSULE_H3);
				e.add(GachaItemRegistry.CAPSULE_H4);
				e.add(GachaItemRegistry.CAPSULE_H5);
				e.add(GachaItemRegistry.CAPSULE_H6);
				e.add(GachaItemRegistry.CAPSULE_H7);
				e.add(GachaItemRegistry.CAPSULE_H8);
				e.add(GachaItemRegistry.CAPSULE_H9);
				e.add(GachaItemRegistry.CAPSULE_H10);

				e.add(GachaItemRegistry.CAPSULE_I1);
				e.add(GachaItemRegistry.CAPSULE_I2);
				e.add(GachaItemRegistry.CAPSULE_I3);
				e.add(GachaItemRegistry.CAPSULE_I4);
				e.add(GachaItemRegistry.CAPSULE_I5);
				e.add(GachaItemRegistry.CAPSULE_I6);
				e.add(GachaItemRegistry.CAPSULE_I7);
				e.add(GachaItemRegistry.CAPSULE_I8);
				e.add(GachaItemRegistry.CAPSULE_I9);
				e.add(GachaItemRegistry.CAPSULE_I10);

				e.add(GachaItemRegistry.CAPSULE_J1);
				e.add(GachaItemRegistry.CAPSULE_J2);
				e.add(GachaItemRegistry.CAPSULE_J3);
				e.add(GachaItemRegistry.CAPSULE_J4);
				e.add(GachaItemRegistry.CAPSULE_J5);
				e.add(GachaItemRegistry.CAPSULE_J6);
				e.add(GachaItemRegistry.CAPSULE_J7);
				e.add(GachaItemRegistry.CAPSULE_J8);
				e.add(GachaItemRegistry.CAPSULE_J9);
				e.add(GachaItemRegistry.CAPSULE_J10);

			}).build());



	public static final LootContextType GACHA_MACHINE_LOOT_CONTEXT = registerLootContext(id("gacha_machine"), b -> b.require(LootContextParameters.ORIGIN).require(LootContextParameters.THIS_ENTITY));
	public static final LootContextType CAPSULE_LOOT_CONTEXT = registerLootContext(id("capsule"), b -> b.require(LootContextParameters.ORIGIN).allow(LootContextParameters.THIS_ENTITY));


	@Override
	public void onInitialize() {
		GachaItemRegistry.init();
		ModLootTypes.register();
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new DatapackConfig());
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








