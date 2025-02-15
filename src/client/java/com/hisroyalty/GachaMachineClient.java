package com.hisroyalty;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class GachaMachineClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_2, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_3, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_4, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_5, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_6, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_7, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_8, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_9, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(GachaMachine.GACHA_MACHINE_10, RenderLayer.getTranslucent());
	}
}