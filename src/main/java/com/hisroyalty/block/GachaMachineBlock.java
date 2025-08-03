package com.hisroyalty.block;

import com.hisroyalty.config.DatapackConfig;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

import static com.hisroyalty.GachaMachine.*;
import static java.util.Collections.emptyList;

public class GachaMachineBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    private final TagKey<Item> currencyTag;
    private final String loot;
    private final int configProperty;

    public GachaMachineBlock(Settings settings, TagKey<Item> currencyTag, String loot, int configProperty) {
        super(settings);
        this.currencyTag = currencyTag;
        this.loot = loot;
        this.configProperty = configProperty;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(HALF);

    }


    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return;
        }

        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GachaMachineBlockEntity) {
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }







    public static int deserializeLevel(int index) {
        return switch (index) {
            case 1 -> DatapackConfig.getMaxCurrency("gacha_machine_1");
            case 2 -> DatapackConfig.getMaxCurrency("gacha_machine_2");
            case 3 -> DatapackConfig.getMaxCurrency("gacha_machine_3");
            case 4 -> DatapackConfig.getMaxCurrency("gacha_machine_4");
            case 5 -> DatapackConfig.getMaxCurrency("gacha_machine_5");
            case 6 -> DatapackConfig.getMaxCurrency("gacha_machine_6");
            case 7 -> DatapackConfig.getMaxCurrency("gacha_machine_7");
            case 8 -> DatapackConfig.getMaxCurrency("gacha_machine_8");
            case 9 -> DatapackConfig.getMaxCurrency("gacha_machine_9");
            case 10 -> DatapackConfig.getMaxCurrency("gacha_machine_10");
            default -> 5;
        };
    }



    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.up()).isReplaceable();
    }


    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                return emptyList();
        }
        return super.getDroppedStacks(state, builder);
    }



    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient()) {
            world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }




    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis() == Direction.Axis.Y) {
            boolean valid = true;
            DoubleBlockHalf half = state.get(HALF);

            if (half == DoubleBlockHalf.LOWER && direction == Direction.UP)
                if (!neighborState.isOf(this) || neighborState.get(HALF) != DoubleBlockHalf.UPPER)
                    valid = false;
            if (half == DoubleBlockHalf.UPPER && direction == Direction.DOWN)
                if (!neighborState.isOf(this) || neighborState.get(HALF) != DoubleBlockHalf.LOWER)
                    valid = false;

            if (!valid) return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private boolean isValidItem(ItemStack stack, World world) {
        if (world.isClient) {
            return false;
        }
        return stack.isIn(currencyTag);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            pos = pos.down();
        }
        if (!(world.getBlockEntity(pos) instanceof GachaMachineBlockEntity gachaMachineBlockEntity)) {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }

        if (!isValidItem(stack, world)) {
            StringBuilder itemNames = new StringBuilder();
            List<RegistryEntry<Item>> currencyItems = Registries.ITEM.getOrCreateEntryList(currencyTag).stream().toList();

            if (currencyItems.isEmpty()) {
                itemNames.append("No valid currencies");
            } else {
                for (RegistryEntry<Item> itemRegistryEntry : currencyItems) {
                    Item item = itemRegistryEntry.value();
                    String itemName = item.getName().getString();
                    itemNames.append(itemName).append(", ");
                }

                if (!itemNames.isEmpty()) {
                    itemNames.setLength(itemNames.length() - 2);
                }
            }

            Text message = Text.translatable("message.gacha_machine.invalid_currency",
                    Text.literal(itemNames.toString()).styled(style -> style.withColor(Formatting.RED))
            ).styled(style -> style.withColor(Formatting.RED));

            if (hand == Hand.MAIN_HAND && !player.getWorld().isClient) {
                player.sendMessage(message, message.getString().length() <= 128);
            }
            return ItemActionResult.FAIL;
        }

        if (isValidItem(stack, world)) {
            int currentLevel = gachaMachineBlockEntity.getLevel();

            if (currentLevel < (deserializeLevel(configProperty) - 1)) {
                gachaMachineBlockEntity.setLevel(currentLevel + 1);

                Text text = Text.literal("[").append(Text.of(String.valueOf(currentLevel + 1)))
                        .append(Text.of("/")).append(Text.of(String.valueOf(deserializeLevel(configProperty))))
                        .append(Text.of("]"));
                if (!world.isClient()) player.sendMessage(text, true);

                if (!player.isCreative()) {
                    stack.decrement(1);
                }

                SoundEvent soundEvent = SoundEvents.BLOCK_CHAIN_STEP;
                world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else {
                if (!world.isClient) {
                    List<ItemStack> capsules = getOutput(player);
                    Direction direction = state.get(FACING);
                    BlockPos spawnPos = pos;
                    if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                        spawnPos = pos.down();
                    }
                    double offsetX = direction.getOffsetX() * 0.5;
                    double offsetZ = direction.getOffsetZ() * 0.5;

                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }

                    for (ItemStack capsule : capsules) {
                        if (capsule.getCount() > 1) {
                            Random random = new Random();
                            int messageIndex = random.nextInt(4) + 1;
                            Text message = Text.translatable("message.gacha_machine.multiple_rewards_" + messageIndex,
                                            Text.of(capsule.getItem().getName()))
                                    .styled(style -> style.withColor(Formatting.GOLD));
                            player.sendMessage(message, false);
                        }
                        ItemEntity capsuleEntity = new ItemEntity(
                                world,
                                spawnPos.getX() + 0.5 + offsetX,
                                spawnPos.getY() + 0.5,
                                spawnPos.getZ() + 0.5 + offsetZ,
                                capsule
                        );
                        capsuleEntity.setVelocity(
                                direction.getOffsetX() * 0.2,
                                0.0,
                                direction.getOffsetZ() * 0.2
                        );
                        world.spawnEntity(capsuleEntity);
                    }
                    gachaMachineBlockEntity.setLevel(0);
                    world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.FAIL;
    }


    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof GachaMachineBlockEntity gachaMachineBlockEntity) {
            return gachaMachineBlockEntity.getLevel();
        }
        return 0;
    }

    public List<ItemStack> getOutput(PlayerEntity player) {
        if (player == null) {
            System.err.println("Player is null");
            return List.of(ItemStack.EMPTY);
        }


        if (!(player.getWorld() instanceof ServerWorld serverWorld)) {
            System.err.println("Player is not in a server world");
            return List.of(ItemStack.EMPTY);
        }

        LootContextParameterSet parameters = new LootContextParameterSet.Builder(serverWorld)
                .add(LootContextParameters.ORIGIN, player.getPos())
                .add(LootContextParameters.THIS_ENTITY, player)
                .build(GACHA_MACHINE_LOOT_CONTEXT);

        Identifier lootTableId = Identifier.of(MOD_ID, loot);
        LootTable lootTable = serverWorld.getServer()
                .getReloadableRegistries()
                .getLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, lootTableId));


        if (lootTable == null) {
            System.err.println("Loot table not found: " + lootTableId);
            return List.of(ItemStack.EMPTY);
        }


        List<ItemStack> generatedLoot = lootTable.generateLoot(parameters);

        if (generatedLoot == null || generatedLoot.isEmpty()) {
            System.err.println("No loot generated from table: " + lootTableId);
            return List.of(ItemStack.EMPTY);
        }

        return generatedLoot;
    }





    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GachaMachineBlockEntity(pos, state);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (player.isCreative() || !player.canHarvest(state))) {
            onBreakInCreative(world, pos, state, player);
        }

        return super.onBreak(world, pos, state, player);
    }

    protected static void onBreakInCreative(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                world.setBlockState(blockPos, blockState2, 35);
                world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
            }
        }

    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
