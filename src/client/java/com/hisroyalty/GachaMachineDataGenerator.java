package com.hisroyalty;

import com.hisroyalty.item.GachaItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class GachaMachineDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(GachaModelGenerator::new);
	}

	private static class GachaModelGenerator extends FabricModelProvider {
		public GachaModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator generator) {
			// ideally the gacha machine blockstate should be generated here
			generator.registerParentedItemModel(GachaItemRegistry.GACHA_MACHINE, GachaMachine.id("block/gacha_machine"));
		}

		@Override
		public void generateItemModels(ItemModelGenerator generator) {
			//generator.register(GachaItemRegistry.RED_CAPSULE, Models.GENERATED);
			//generator.register(GachaItemRegistry.GREEN_CAPSULE, Models.GENERATED);
			//generator.register(GachaItemRegistry.YELLOW_CAPSULE, Models.GENERATED);
			generator.register(GachaItemRegistry.IRON_CAPSULE, Models.GENERATED);
			generator.register(GachaItemRegistry.GOLD_CAPSULE, Models.GENERATED);
			generator.register(GachaItemRegistry.DIAMOND_CAPSULE, Models.GENERATED);
			generator.register(GachaItemRegistry.EMERALD_CAPSULE, Models.GENERATED);
		}
	}
}
