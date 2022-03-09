package org.liabri.tila.screenhandlers;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.Property;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.liabri.tila.recipes.EaselRecipe;

import java.util.List;

public class EaselScreenHandler extends ScreenHandler {
    private final Inventory controllerInventory;
    private final PropertyDelegate propertyDelegate;

    private final Property selectedRecipe;
    private List<EaselRecipe> availableRecipes;
    final CraftingResultInventory output;
    final Slot outputSlot;

    public EaselScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(4), new ArrayPropertyDelegate(2));
    }

    public EaselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ScreenHandlers.EASEL_SCREEN_HANDLER, syncId);

        this.selectedRecipe = Property.create();
        this.availableRecipes = Lists.newArrayList();
        this.output = new CraftingResultInventory();

        this.controllerInventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);

        int m, l;

        //Canvasses slot
        this.addSlot(new Slot(controllerInventory, 0, 30, 30));

        //Recipe Output
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override public boolean canInsert(ItemStack stack) { return false; }
        });

        this.addSlot(this.outputSlot);


        //Recipe Inputs
//        for (m = 0; m < 2; m++) {
//            for (l = 0; l < 5; l++) {
//                this.addSlot(new Slot(controllerInventory, l + m * 5, 44 + l * 18, 27 + m * 18));
//            }
//        }

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

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            EaselRecipe easelRecipe = (EaselRecipe)this.availableRecipes.get(this.selectedRecipe.get());
            this.output.setLastRecipe(easelRecipe);
            this.outputSlot.setStack(easelRecipe.craft(this.controllerInventory));
        } else {
            this.outputSlot.setStack(ItemStack.EMPTY);
        }

        this.sendContentUpdates();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.controllerInventory.canPlayerUse(player);
    }
}