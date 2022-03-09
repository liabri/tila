package org.liabri.tila.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import org.liabri.tila.screenhandlers.EaselScreenHandler;

import javax.annotation.Nullable;

public class EaselBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.EASEL_BLOCK_ENTITY, pos, state);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EaselScreenHandler(syncId, inv);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.tila.easel");
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
