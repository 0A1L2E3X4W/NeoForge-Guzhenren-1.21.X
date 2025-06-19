package com.alex.guzhenren.datagen;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangEnUsProvider extends LanguageProvider {

    public ModLangEnUsProvider(PackOutput output) {
        super(output, Guzhenren.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // ITEMS
        add(ModItems.APERTURE.get(), "Aperture");
        add(ModItems.HUMAN_HEART.get(), "Human Heart");
        add(ModItems.PRIMEVAL_STONE.get(), "Primeval Stone");

        // BLOCKS
        add(ModBlocks.PRIMEVAL_STONE_BLOCK.get(), "Primeval Stone Block");
        add(ModBlocks.PRIMEVAL_STONE_ORE.get(), "Primeval Stone Ore");

        // CREATIVE TABS
        addCreativeTab("gu_material_tab", "Gu Materials");

        // ITEM TOOLTIPS
        addItemToolTipsTranslations();
    }

    private void addCreativeTab(String nameKey, String translation) {
        add("itemGroup." + Guzhenren.MOD_ID + "." + nameKey, translation);
    }

    private void addItemToolTipsTranslations() {
        add("tooltip.guzhenren.primeval_stone.tooltip", "regenerate primeval essence");
    }
}
