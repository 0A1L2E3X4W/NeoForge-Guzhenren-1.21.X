package com.alex.guzhenren.datagen;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.item.ModItems;
import com.alex.guzhenren.utils.enums.GuMasterRank;
import com.alex.guzhenren.utils.enums.GuMasterTalent;
import com.alex.guzhenren.utils.enums.ModTenExtremePhysique;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangZhCnProvider extends LanguageProvider {

    public ModLangZhCnProvider(PackOutput output) {
        super(output, Guzhenren.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        // ITEMS
        addItem(ModItems.APERTURE, "人窍");
        addItem(ModItems.HUMAN_HEART, "人心");
        addItem(ModItems.PRIMEVAL_STONE, "元石");

        // GU
        addItem(ModItems.HOPE_GU, "希望蛊");

        // BLOCKS
        addBlock(ModBlocks.PRIMEVAL_STONE_ORE, "元石矿");
        addBlock(ModBlocks.PRIMEVAL_STONE_BLOCK, "元石块");

        // CREATIVE TABS
        addCreativeTab("gu_material_tab", "蛊材类");
        addCreativeTab("mortal_gu_tab", "凡蛊类");

        // ITEM TOOLTIPS
        addItemToolTipsTranslations();

        // GU MASTER TALENT
        addGuMasterTalentTranslations();

        // GU MASTER RANK
        addGuMasterRankTranslations();

        // GU MASTER TEN EXTREME PHYSIQUE
        addTenExtremePhysiqueTranslations();
    }

    private void addItemToolTipsTranslations() {
        add("tooltip.guzhenren.primeval_stone.tooltip", "回复真元");
    }

    private void addGuMasterTalentTranslations() {
        add(GuMasterTalent.A.getNameKey(), "甲等");
        add(GuMasterTalent.B.getNameKey(), "乙等");
        add(GuMasterTalent.C.getNameKey(), "丙等");
        add(GuMasterTalent.D.getNameKey(), "丁等");
        add(GuMasterTalent.TEN_EXTREME.getNameKey(), "十绝体");
        add(GuMasterTalent.NULL.getNameKey(), "无");
    }

    private void addGuMasterRankTranslations() {
        add(GuMasterRank.MORTAL.getNameKey(), "凡人");

        add(GuMasterRank.RANK_ONE_INIT.getNameKey(), "一转初阶");
        add(GuMasterRank.RANK_ONE_MID.getNameKey(), "一转中阶");
        add(GuMasterRank.RANK_ONE_UPPER.getNameKey(), "一转高阶");
        add(GuMasterRank.RANK_ONE_PEAK.getNameKey(), "一转高阶");

        add(GuMasterRank.RANK_TWO_INIT.getNameKey(), "二转初阶");
        add(GuMasterRank.RANK_TWO_MID.getNameKey(), "二转中阶");
        add(GuMasterRank.RANK_TWO_UPPER.getNameKey(), "二转高阶");
        add(GuMasterRank.RANK_TWO_PEAK.getNameKey(), "二转高阶");
    }

    private void addTenExtremePhysiqueTranslations() {
        add(ModTenExtremePhysique.VERDANT_GREAT_SUN.getNameKey(), "太日阳莽体");
        add(ModTenExtremePhysique.DESOLATE_ANCIENT_MOON.getNameKey(), "古月阴荒体");
        add(ModTenExtremePhysique.NORTHERN_DARK_ICE_SOUL.getNameKey(), "北冥冰魄体");
        add(ModTenExtremePhysique.BOUNDLESS_FOREST_SAMSARA.getNameKey(), "森海轮回体");
        add(ModTenExtremePhysique.BLAZING_GLORY_LIGHTNING_BRILLIANCE.getNameKey(), "炎煌雷泽体");
        add(ModTenExtremePhysique.MYRIAD_GOLD_WONDROUS_ESSENCE.getNameKey(), "万金妙华体");
        add(ModTenExtremePhysique.GREAT_STRENGTH_TRUE_MARTIAL.getNameKey(), "大力真武体");
        add(ModTenExtremePhysique.CAREFREE_WISDOM_HEART.getNameKey(), "逍遥智心体");
        add(ModTenExtremePhysique.CENTRAL_EARTH_ESSENCE.getNameKey(), "厚土元央体");
        add(ModTenExtremePhysique.UNIVERSE_GREAT_DERIVATION.getNameKey(), "宇宙大衍体");
        add(ModTenExtremePhysique.PURE_DREAM_REALITY_SEEKER.getNameKey(), "纯梦求真体");
        add(ModTenExtremePhysique.NULL.getNameKey(), "无");
    }

    private void addCreativeTab(String nameKey, String translation) {
        add("itemGroup." + Guzhenren.MOD_ID + "." + nameKey, translation);
    }
}
