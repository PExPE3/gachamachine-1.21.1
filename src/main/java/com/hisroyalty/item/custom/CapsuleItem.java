package com.hisroyalty.item.custom;

import com.hisroyalty.GachaMachine;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

import static com.hisroyalty.GachaMachine.MOD_ID;

public class CapsuleItem extends Item {
    private Identifier lootTableId;

    public CapsuleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return TypedActionResult.pass(user.getStackInHand(hand));
        List<ItemStack> drops = getDrops((ServerWorld) world, user.getPos(), user);
        ItemStack capsule = user.getStackInHand(hand);

        ItemStack resultStack = capsule.copy();
        resultStack.decrement(1);

        for (ItemStack stack : drops) {
            if (!user.giveItemStack(stack)) {
                user.dropStack(stack);
            }
        }

        return TypedActionResult.consume(resultStack);
    }


    private List<ItemStack> getDrops(ServerWorld world, Vec3d pos, @Nullable Entity user) {
        if (getLootTableId() == null) return Collections.emptyList();
        LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder(world)
                .add(LootContextParameters.ORIGIN, pos)
                .addOptional(LootContextParameters.THIS_ENTITY, user)
                .build(GachaMachine.CAPSULE_LOOT_CONTEXT);
//        Identifier lootTableId = Identifier.of(MOD_ID, "gacha_machine");
        LootTable lootTable = world.getServer()
                .getReloadableRegistries()
                .getLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, getLootTableId()));
        return lootTable.generateLoot(lootContextParameterSet);
    }

    public final Identifier getLootTableId() {
        if (lootTableId == null) lootTableId = Registries.ITEM.getId(this).withPrefixedPath("gacha_capsules/");
        return lootTableId;
    }




}

