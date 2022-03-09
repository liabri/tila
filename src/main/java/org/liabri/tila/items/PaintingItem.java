package org.liabri.tila.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import static org.liabri.tila.Tila.PAINTING_ITEM_GROUP;

public class PaintingItem extends Item {
    private final String refName;
    private final int width;
    private final int height;

    private PaintingMotive paintingMotive;

    public String getRefName() {
        return this.refName;
    }

    public PaintingItem(String name, int width, int height) {
        super(new FabricItemSettings().group(PAINTING_ITEM_GROUP));
        this.refName = name;
        this.width = width;
        this.height = height;
        this.paintingMotive = register(this.refName, this.width, this.height);
    }

//    public void register() {
//        this.paintingMotive = Registry.register(Registry.PAINTING_MOTIVE, this.refName, new PaintingMotive(this.width, this.height));
//    }

    private static PaintingMotive register(String name, int width, int height) {
        return Registry.register(Registry.PAINTING_MOTIVE, name, new PaintingMotive(width, height));
    }

    protected boolean canPlaceOn(PlayerEntity player, Direction side, ItemStack stack, BlockPos pos) {
        return !side.getAxis().isVertical() && player.canPlaceOn(pos, side, stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        Direction direction = context.getSide();
        BlockPos blockPos2 = blockPos.offset(direction);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if (playerEntity != null && !this.canPlaceOn(playerEntity, direction, itemStack, blockPos2)) {
            return ActionResult.FAIL;
        } else {
            World world = context.getWorld();
            PaintingEntity paintingEntity = new PaintingEntity(world, blockPos2, direction, this.paintingMotive);
            NbtCompound nbtCompound = itemStack.getNbt();

            if (nbtCompound != null) {
                EntityType.loadFromEntityNbt(world, playerEntity, paintingEntity, nbtCompound);
            }

            if (paintingEntity.canStayAttached()) {
                if (!world.isClient) {
                    paintingEntity.onPlace();
                    world.emitGameEvent(playerEntity, GameEvent.ENTITY_PLACE, blockPos);
                    world.spawnEntity(paintingEntity);
                }

                itemStack.decrement(1);
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.CONSUME;
            }
        }
    }
}
