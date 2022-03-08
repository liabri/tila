package org.liabri.tila.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class EaselBlockEntity extends BlockEntity {

    public EaselBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.EASEL_BLOCK_ENTITY, pos, state);
    }

    protected Text getContainerName() {
        return new TranslatableText("container.easel");
    }
}
