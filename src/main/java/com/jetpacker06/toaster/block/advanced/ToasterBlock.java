package com.jetpacker06.toaster.block.advanced;

import com.jetpacker06.toaster.block.entity.BlockEntities;
import com.jetpacker06.toaster.block.entity.ToasterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.stream.Stream;

public class ToasterBlock extends BaseEntityBlock implements EntityBlock {
    public ToasterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return voxelShape.orElse(Shapes.block());
    }
    private static final Optional<VoxelShape> voxelShape = Stream.of(
            Block.box(4, 0, 4, 12, 1, 12),
            Block.box(4, 0, 3, 12, 7, 4),
            Block.box(4, 0, 12, 12, 7, 13),
            Block.box(10, 1, 4, 12, 7, 12),
            Block.box(4, 1, 4, 6, 7, 12),
            Block.box(7, 1, 4, 9, 7, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));
    private static final Optional<VoxelShape> rotatedVoxelShape = Stream.of(
            Block.box(4, 0, 4, 12, 1, 12),
            Block.box(3, 0, 4, 4, 7, 12),
            Block.box(12, 0, 4, 13, 7, 12),
            Block.box(4, 1, 10, 12, 7, 12),
            Block.box(4, 1, 7, 12, 7, 9),
            Block.box(4, 1, 4, 12, 7, 6)
              ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return voxelShape.orElse(Shapes.block());
    }
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof ToasterBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (ToasterBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return super.rotate(state, world, pos, direction);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ToasterBlockEntity(pPos, pState);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ToasterBlockEntity) {
                ((ToasterBlockEntity) blockEntity).drops();
            }
        }
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, BlockEntities.TOASTER.get(), ToasterBlockEntity::tick);
    }
}