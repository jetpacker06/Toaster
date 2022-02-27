package com.jetpacker06.toaster.block.advanced;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;
import java.util.stream.Stream;

public class ChurnBlock extends Block {
    public ChurnBlock(Properties p_49795_) {super(p_49795_);}
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return voxelShape.orElse(Shapes.block());
    }
    private static final Optional<VoxelShape> voxelShape = Stream.of(
            Block.box(5, 0, 10, 6, 1, 11),
            Block.box(10, 0, 10, 11, 1, 11),
            Block.box(10, 0, 5, 11, 1, 6),
            Block.box(5, 0, 5, 6, 1, 6),
            Block.box(5, 1, 5, 11, 2, 11),
            Block.box(10, 2, 10, 11, 7, 11),
            Block.box(6, 7, 10, 10, 14, 11),
            Block.box(10, 7, 6, 11, 14, 10),
            Block.box(5, 7, 6, 6, 14, 10),
            Block.box(6, 7, 5, 10, 14, 6),
            Block.box(4, 2, 6, 5, 7, 10),
            Block.box(5, 2, 10, 6, 7, 11),
            Block.box(5, 2, 5, 6, 7, 6),
            Block.box(10, 2, 5, 11, 7, 6),
            Block.box(11, 2, 6, 12, 7, 10),
            Block.box(6, 2, 4, 10, 7, 5),
            Block.box(6, 2, 11, 10, 7, 12),
            Block.box(5, 14, 6, 11, 15, 10),
            Block.box(6, 14, 5, 10, 15, 6),
            Block.box(6, 14, 10, 10, 15, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));
    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return voxelShape.orElse(Shapes.block());
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
