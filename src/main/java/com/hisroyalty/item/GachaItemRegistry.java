package com.hisroyalty.item;

import com.hisroyalty.GachaMachine;
import com.hisroyalty.item.custom.CapsuleItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GachaItemRegistry {
    public static final BlockItem GACHA_MACHINE = register("gacha_machine", new BlockItem(GachaMachine.GACHA_MACHINE, new Item.Settings()));

    public static final CapsuleItem BASIC_CAPSULE = register("basic_capsule", new CapsuleItem(new Item.Settings()));

    //iron gold diamond emerald copper
    public static final CapsuleItem COPPER_CAPSULE = register("copper_capsule", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem IRON_CAPSULE = register("iron_capsule", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem GOLD_CAPSULE = register("gold_capsule_alt", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem DIAMOND_CAPSULE = register("diamond_capsule", new CapsuleItem(new Item.Settings()));

    // alternative capsules for everything but emerald and gold
    // netherite capsule
    public static final CapsuleItem NETHERITE_CAPSULE = register("netherite_capsule", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem EMERALD_CAPSULE = register("emerald_capsule_alt", new CapsuleItem(new Item.Settings()));

    public static final CapsuleItem COPPER_CAPSULE_ALT = register("copper_capsule_alt", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem IRON_CAPSULE_ALT = register("iron_capsule_alt", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem DIAMOND_CAPSULE_ALT = register("diamond_capsule_alt", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem NETHERITE_CAPSULE_ALT = register("netherite_capsule_alt", new CapsuleItem(new Item.Settings()));


    // red green yellow
    public static final CapsuleItem RED_CAPSULE = register("red_capsule", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem GREEN_CAPSULE = register("green_capsule", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem YELLOW_CAPSULE = register("yellow_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem GREEN_CAPSULE = register("green_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem YELLOW_CAPSULE = register("yellow_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem IRON_CAPSULE = register("iron_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem GOLD_CAPSULE = register("gold_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem DIAMOND_CAPSULE = register("diamond_capsule", new CapsuleItem(new Item.Settings()));
    //public static final CapsuleItem EMERALD_CAPSULE = register("emerald_capsule", new CapsuleItem(new Item.Settings()));


    public static <T extends Item> T register(String id, T item) {
        return Registry.register(Registries.ITEM, Identifier.of("gachamachine", id), item);
    }

    public static void init() {}
}
