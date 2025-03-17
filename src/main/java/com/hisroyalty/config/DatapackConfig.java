package com.hisroyalty.config;

import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.InputStreamReader;

import static com.hisroyalty.GachaMachine.LOGGER;
import static com.hisroyalty.GachaMachine.id;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;

import java.util.HashMap;
import java.util.Map;

public class DatapackConfig implements SimpleSynchronousResourceReloadListener {
    private static final Codec<Map<String, Integer>> CONFIG_CODEC = Codec.unboundedMap(Codec.STRING, Codec.INT);
    private static final Map<String, Integer> gachaMachineCurrencyLimits = new HashMap<>();

    @Override
    public Identifier getFabricId() {
        return id("datapack_config");
    }

    @Override
    public void reload(ResourceManager resourceManager) {
        gachaMachineCurrencyLimits.clear();

        resourceManager.findResources("config", path -> path.getPath().endsWith(".json")).forEach((id, resource) -> {
            if (id.getPath().equals("config/server_config.json")) {
                try (InputStreamReader reader = new InputStreamReader(resource.getInputStream())) {
                    JsonElement json = JsonParser.parseReader(reader);
                    DataResult<Map<String, Integer>> result = CONFIG_CODEC.parse(JsonOps.INSTANCE, json);

                    result.resultOrPartial(System.err::println).ifPresentOrElse(
                            gachaMachineCurrencyLimits::putAll,
                            () -> LOGGER.warn("Failed to load config for gacha machine: {}", id)
                    );

                    LOGGER.info("Loaded config for gacha machine: {}", id);
                } catch (Exception e) {
                    LOGGER.error("Failed to load config for gacha machine: {}", id, e);
                }
            }
        });
    }

    public static int getMaxCurrency(String machineId) {
        return gachaMachineCurrencyLimits.getOrDefault(machineId, 5);
    }
}


