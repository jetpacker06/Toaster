package com.jetpacker06.toaster.block.entity;

import com.jetpacker06.toaster.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class ToasterBlockEntity extends BlockEntity implements MenuProvider {

    public ToasterBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntities.TOASTER.get(), pWorldPosition, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Toaster");
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return null;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
    }
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, ToasterBlockEntity pBlockEntity) {
        if(leftHasRecipe(pBlockEntity)) {
            pBlockEntity.itemHandler.extractItem(0, 1, false);
            pBlockEntity.itemHandler.setStackInSlot(1, new ItemStack(ModItems.TOASTED_BREAD.get()));
        }
        if(rightHasRecipe(pBlockEntity)) {
            pBlockEntity.itemHandler.extractItem(3, 1, false);
            pBlockEntity.itemHandler.setStackInSlot(4, new ItemStack(ModItems.TOASTED_BREAD.get(), pBlockEntity.itemHandler.getStackInSlot(4).getCount() + 1));
        }
    }

    public static boolean leftHasRecipe(ToasterBlockEntity entity) {
        //does it have bread? and is the output stack less than 64? and is the output stack toasted bread?
        return entity.itemHandler.getStackInSlot(0).getItem() == ModItems.BREAD_SLICE.get() & entity.itemHandler.getStackInSlot(2).getCount() > 64 & entity.itemHandler.getStackInSlot(2).getItem() == ModItems.TOASTED_BREAD.get();
    }
    public static boolean rightHasRecipe(ToasterBlockEntity entity) {
        //does it have bread? and is the output stack less than 64? and is the output stack toasted bread?
        return entity.itemHandler.getStackInSlot(3).getItem() == ModItems.BREAD_SLICE.get() & entity.itemHandler.getStackInSlot(4).getCount() > 64 & entity.itemHandler.getStackInSlot(4).getItem() == ModItems.TOASTED_BREAD.get();
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
    }
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

}