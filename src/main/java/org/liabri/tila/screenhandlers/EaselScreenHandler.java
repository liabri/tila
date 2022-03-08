package org.liabri.tila.screenhandlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class EaselScreenHandler extends ScreenHandler {
    private final Inventory controllerInventory;
    private final PropertyDelegate propertyDelegate;

    public EaselScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(4), new ArrayPropertyDelegate(2));
    }

    public EaselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ScreenHandlers.EASEL_SCREEN_HANDLER, syncId);

        this.controllerInventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);

        int m, l;

        //Recipe Output
        this.addSlot(new Slot(controllerInventory, 10, 145, 34) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        //Recipe Inputs
        for (m = 0; m < 2; m++) {
            for (l = 0; l < 5; l++) {
                this.addSlot(new Slot(controllerInventory, l + m * 5, 44 + l * 18, 27 + m * 18));
            }
        }

        //Player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 91 + m * 18));
            }
        }
        //Player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 149));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.controllerInventory.canPlayerUse(player);
    }
}