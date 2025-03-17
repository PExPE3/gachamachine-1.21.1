package com.hisroyalty.item;

import com.hisroyalty.GachaMachine;
import com.hisroyalty.item.custom.CapsuleItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GachaItemRegistry {
    public static final BlockItem GACHA_MACHINE = register("gacha_machine", new BlockItem(GachaMachine.GACHA_MACHINE, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_2 = register("gacha_machine_2", new BlockItem(GachaMachine.GACHA_MACHINE_2, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_3 = register("gacha_machine_3", new BlockItem(GachaMachine.GACHA_MACHINE_3, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_4 = register("gacha_machine_4", new BlockItem(GachaMachine.GACHA_MACHINE_4, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_5 = register("gacha_machine_5", new BlockItem(GachaMachine.GACHA_MACHINE_5, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_6 = register("gacha_machine_6", new BlockItem(GachaMachine.GACHA_MACHINE_6, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_7 = register("gacha_machine_7", new BlockItem(GachaMachine.GACHA_MACHINE_7, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_8 = register("gacha_machine_8", new BlockItem(GachaMachine.GACHA_MACHINE_8, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_9 = register("gacha_machine_9", new BlockItem(GachaMachine.GACHA_MACHINE_9, new Item.Settings()));
    public static final BlockItem GACHA_MACHINE_10 = register("gacha_machine_10", new BlockItem(GachaMachine.GACHA_MACHINE_10, new Item.Settings()));



    public static final CapsuleItem WOODEN_CAPSULE = register("capsule_a1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem STONE_CAPSULE = register("capsule_a2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem COPPER_CAPSULE = register("capsule_a3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem IRON_CAPSULE = register("capsule_a4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem GOLD_CAPSULE = register("capsule_a5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem LAPIS_CAPSULE = register("capsule_a6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem RUBY_CAPSULE = register("capsule_a7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem EMERALD_CAPSULE = register("capsule_a8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem DIAMOND_CAPSULE = register("capsule_a9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem NETHERITE_CAPSULE = register("capsule_a10", new CapsuleItem(new Item.Settings()));

    public static final Item GACHA_COIN = register("gacha_coin", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_2 = register("gacha_coin_2", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_3 = register("gacha_coin_3", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_4 = register("gacha_coin_4", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_5 = register("gacha_coin_5", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_6 = register("gacha_coin_6", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_7 = register("gacha_coin_7", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_8 = register("gacha_coin_8", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_9 = register("gacha_coin_9", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item GACHA_COIN_10 = register("gacha_coin_10", new Item(new Item.Settings().rarity(Rarity.RARE)));



    public static final CapsuleItem CAPSULE_B1 = register("capsule_b1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B2 = register("capsule_b2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B3 = register("capsule_b3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B4 = register("capsule_b4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B5 = register("capsule_b5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B6 = register("capsule_b6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B7 = register("capsule_b7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B8 = register("capsule_b8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B9 = register("capsule_b9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_B10 = register("capsule_b10", new CapsuleItem(new Item.Settings()));

    public static final CapsuleItem CAPSULE_C1 = register("capsule_c1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C2 = register("capsule_c2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C3 = register("capsule_c3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C4 = register("capsule_c4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C5 = register("capsule_c5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C6 = register("capsule_c6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C7 = register("capsule_c7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C8 = register("capsule_c8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C9 = register("capsule_c9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_C10 = register("capsule_c10", new CapsuleItem(new Item.Settings()));


    public static final CapsuleItem CAPSULE_D1 = register("capsule_d1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D2 = register("capsule_d2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D3 = register("capsule_d3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D4 = register("capsule_d4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D5 = register("capsule_d5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D6 = register("capsule_d6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D7 = register("capsule_d7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D8 = register("capsule_d8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D9 = register("capsule_d9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_D10 = register("capsule_d10", new CapsuleItem(new Item.Settings()));

    public static final CapsuleItem CAPSULE_E1 = register("capsule_e1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E2 = register("capsule_e2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E3 = register("capsule_e3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E4 = register("capsule_e4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E5 = register("capsule_e5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E6 = register("capsule_e6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E7 = register("capsule_e7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E8 = register("capsule_e8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E9 = register("capsule_e9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_E10 = register("capsule_e10", new CapsuleItem(new Item.Settings()));

    public static final CapsuleItem CAPSULE_F1 = register("capsule_f1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F2 = register("capsule_f2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F3 = register("capsule_f3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F4 = register("capsule_f4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F5 = register("capsule_f5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F6 = register("capsule_f6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F7 = register("capsule_f7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F8 = register("capsule_f8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F9 = register("capsule_f9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_F10 = register("capsule_f10", new CapsuleItem(new Item.Settings()));


    public static final CapsuleItem CAPSULE_G1 = register("capsule_g1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G2 = register("capsule_g2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G3 = register("capsule_g3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G4 = register("capsule_g4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G5 = register("capsule_g5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G6 = register("capsule_g6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G7 = register("capsule_g7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G8 = register("capsule_g8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G9 = register("capsule_g9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_G10 = register("capsule_g10", new CapsuleItem(new Item.Settings()));


    public static final CapsuleItem CAPSULE_H1 = register("capsule_h1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H2 = register("capsule_h2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H3 = register("capsule_h3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H4 = register("capsule_h4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H5 = register("capsule_h5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H6 = register("capsule_h6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H7 = register("capsule_h7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H8 = register("capsule_h8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H9 = register("capsule_h9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_H10 = register("capsule_h10", new CapsuleItem(new Item.Settings()));


    public static final CapsuleItem CAPSULE_I1 = register("capsule_i1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I2 = register("capsule_i2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I3 = register("capsule_i3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I4 = register("capsule_i4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I5 = register("capsule_i5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I6 = register("capsule_i6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I7 = register("capsule_i7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I8 = register("capsule_i8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I9 = register("capsule_i9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_I10 = register("capsule_i10", new CapsuleItem(new Item.Settings()));


    public static final CapsuleItem CAPSULE_J1 = register("capsule_j1", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J2 = register("capsule_j2", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J3 = register("capsule_j3", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J4 = register("capsule_j4", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J5 = register("capsule_j5", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J6 = register("capsule_j6", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J7 = register("capsule_j7", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J8 = register("capsule_j8", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J9 = register("capsule_j9", new CapsuleItem(new Item.Settings()));
    public static final CapsuleItem CAPSULE_J10 = register("capsule_j10", new CapsuleItem(new Item.Settings()));



    public static <T extends Item> T register(String id, T item) {
        return Registry.register(Registries.ITEM, Identifier.of("gachamachine", id), item);
    }

    public static void init() {}
}
