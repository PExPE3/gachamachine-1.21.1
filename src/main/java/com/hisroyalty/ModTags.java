package com.hisroyalty;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.hisroyalty.GachaMachine.id;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> CURRENCY_ITEMS = createTag("currency_items");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, id(name));
        }
    }
}
