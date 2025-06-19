package com.alex.guzhenren.datagen;

import com.alex.guzhenren.Guzhenren;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Guzhenren.MOD_ID)
public class DataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // TRANSLATORS
        generator.addProvider(event.includeServer(), new ModLangEnUsProvider(output));
        generator.addProvider(event.includeServer(), new ModLangZhCnProvider(output));

        // LOOT TABLES
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        // BLOCK TAGS
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // RECIPES
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));

        // ITEM MODELS
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));

        // BLOCK STATES
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
    }
}
