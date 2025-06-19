package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Guzhenren.MOD_ID);

    // ===== GU MATERIALS =====
    public static final DeferredItem<Item> APERTURE = ITEMS.register("aperture", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HUMAN_HEART = ITEMS.register("human_heart", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PRIMEVAL_STONE = ITEMS.register("primeval_stone", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
