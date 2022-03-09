package org.liabri.tila.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.liabri.tila.screenhandlers.EaselScreenHandler;

import javax.annotation.Nullable;

public class EaselBlockEntity extends BlockEntity implements EaselImplementedInventory, NamedScreenHandlerFactory {
    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.EASEL_BLOCK_ENTITY, pos, state);
    }

    private final DefaultedList<ItemStack> ITEMS = DefaultedList.ofSize(1, ItemStack.EMPTY);

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EaselScreenHandler(syncId, inv, this, new ArrayPropertyDelegate(2));
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.tila.easel");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return ITEMS;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, ITEMS);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, ITEMS);
        super.writeNbt(nbt);
    }

//    public static class Type extends BlockEntityType<EaselBlockEntity> {
//        public static Type INSTANCE = new Type();
//
//        public Type() {
//            super(FabricBlockEntityTypeBuilder.create(EaselBlockEntity::new, Blocks.EASEL.getLeft()).build(null), ImmutableSet.of(), null);
//        }
//
//        @Override
//        public boolean supports(BlockState state) {
//            return state.getBlock() instanceof EaselBlock;
//        }
//    }
}
