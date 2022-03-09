package org.liabri.tila.blockentities;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.registry.Registry;
import org.liabri.tila.blocks.Blocks;

import static org.liabri.tila.Tila.id;

public class BlockEntities {
    public static void init() {}

    public static final BlockEntityType<EaselBlockEntity> EASEL_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            id("easel"),
            FabricBlockEntityTypeBuilder.create(EaselBlockEntity::new, Blocks.EASEL.getLeft()).build(null)
    );
}
