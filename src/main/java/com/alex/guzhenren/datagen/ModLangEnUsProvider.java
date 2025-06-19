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
        add(ModItems.APERTURE.get(), "Aperture");
        add(ModItems.HUMAN_HEART.get(), "Human Heart");
        add(ModItems.PRIMEVAL_STONE.get(), "Primeval Stone");

        add(ModBlocks.PRIMEVAL_STONE_BLOCK.get(), "Primeval Stone Block");
        add(ModBlocks.PRIMEVAL_STONE_ORE.get(), "Primeval Stone Ore");

        addCreativeTab("gu_material_tab", "Gu Materials");
    }

    private void addCreativeTab(String nameKey, String translation) {
        add("itemGroup." + Guzhenren.MOD_ID + "." + nameKey, translation);
    }
}
