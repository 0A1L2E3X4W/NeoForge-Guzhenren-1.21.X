package com.alex.guzhenren.item;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Guzhenren.MOD_ID);

    public static final Supplier<CreativeModeTab> GU_MATERIAL_TAB = CREATIVE_MODE_TAB.register("gu_material_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PRIMEVAL_STONE_ORE))
                    .title(Component.translatable("itemGroup." + Guzhenren.MOD_ID + "." + "gu_material_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PRIMEVAL_STONE_ORE);
                        output.accept(ModBlocks.PRIMEVAL_STONE_BLOCK);
                        output.accept(ModItems.PRIMEVAL_STONE);
                        output.accept(ModItems.APERTURE);
                        output.accept(ModItems.HUMAN_HEART);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
