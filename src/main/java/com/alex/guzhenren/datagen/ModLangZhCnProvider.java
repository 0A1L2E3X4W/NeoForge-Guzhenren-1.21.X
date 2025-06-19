package com.alex.guzhenren.datagen;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangZhCnProvider extends LanguageProvider {

    public ModLangZhCnProvider(PackOutput output) {
        super(output, Guzhenren.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.APERTURE, "人窍");
        addItem(ModItems.HUMAN_HEART, "人心");
        addItem(ModItems.PRIMEVAL_STONE, "元石");

        addBlock(ModBlocks.PRIMEVAL_STONE_ORE, "元石矿");
        addBlock(ModBlocks.PRIMEVAL_STONE_BLOCK, "元石块");

        addCreativeTab("gu_material_tab", "蛊材类");
    }

    private void addCreativeTab(String nameKey, String translation) {
        add("itemGroup." + Guzhenren.MOD_ID + "." + nameKey, translation);
    }
}
