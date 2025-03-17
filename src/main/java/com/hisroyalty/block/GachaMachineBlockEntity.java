package com.hisroyalty.block;

import com.hisroyalty.GachaMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class GachaMachineBlockEntity extends BlockEntity {
    private int level = 0;

    public GachaMachineBlockEntity(BlockPos pos, BlockState state) {
        super(GachaMachine.GACHA_MACHINE_BLOCK_ENTITY, pos, state);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        markDirty();
        if (world != null) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("level", level);
    }


    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        level = nbt.getInt("level");
    }

    @Override
    public boolean supports(BlockState state) {
        return super.supports(state) || state.isOf(GachaMachine.GACHA_MACHINE) || state.isOf(GachaMachine.GACHA_MACHINE_2) || state.isOf(GachaMachine.GACHA_MACHINE_3) || state.isOf(GachaMachine.GACHA_MACHINE_4) || state.isOf(GachaMachine.GACHA_MACHINE_5) || state.isOf(GachaMachine.GACHA_MACHINE_6) || state.isOf(GachaMachine.GACHA_MACHINE_7) || state.isOf(GachaMachine.GACHA_MACHINE_8) || state.isOf(GachaMachine.GACHA_MACHINE_9) || state.isOf(GachaMachine.GACHA_MACHINE_10);
    }
}

