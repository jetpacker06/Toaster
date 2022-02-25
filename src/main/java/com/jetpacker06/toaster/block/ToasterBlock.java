package com.jetpacker06.toaster.block;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ToasterBlock extends Block {
    public ToasterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return voxelShape.orElse(Shapes.block());
    }
    private static final Optional<VoxelShape> voxelShape = Stream.of(
            Block.box(4, 0, 4, 12, 1, 12),
            Block.box(3, 0, 4, 4, 7, 12),
            Block.box(12, 0, 4, 13, 7, 12),
            Block.box(4, 1, 10, 12, 7, 12),
            Block.box(4, 1, 7, 12, 7, 9),
            Block.box(4, 1, 4, 12, 7, 6)
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
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return super.rotate(state, world, pos, direction);
    }
}