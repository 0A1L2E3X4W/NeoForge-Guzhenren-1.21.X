package com.alex.guzhenren.datagen;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.event.ModKeyBindings;
import com.alex.guzhenren.item.ModItems;
import com.alex.guzhenren.utils.enums.GuMasterRank;
import com.alex.guzhenren.utils.enums.GuMasterTalent;
import com.alex.guzhenren.utils.enums.ModTenExtremePhysique;
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

        // GU
        addItem(ModItems.HOPE_GU, "Hope Gu");

        // BLOCKS
        add(ModBlocks.PRIMEVAL_STONE_BLOCK.get(), "Primeval Stone Block");
        add(ModBlocks.PRIMEVAL_STONE_ORE.get(), "Primeval Stone Ore");

        // CREATIVE TABS
        addCreativeTab("gu_material_tab", "Gu Materials");
        addCreativeTab("mortal_gu_tab", "Mortal Gu");

        // ITEM TOOLTIPS
        addItemToolTipsTranslations();

        // GU MASTER TALENT
        addGuMasterTalentTranslations();

        // GU MASTER RANK
        addGuMasterRankTranslations();

        // GU MASTER TEN EXTREME PHYSIQUE
        addTenExtremePhysiqueTranslations();

        // GU MASTER SCREEN
        addScreenTranslations();

        // KEY BINDINGS
        addKeyBindingsTranslation();
    }

    private void addScreenTranslations() {
        add("screen.guzhenren.title", "GUI");
        add("screen.guzhenren.rank", "Rank");
        add("screen.guzhenren.essence", "Essence");
        add("screen.guzhenren.talent", "Talent");
        add("screen.guzhenren.extreme_physique", "Physique");
    }

    private void addKeyBindingsTranslation() {
        add(ModKeyBindings.KEY_CATEGORY_GUZHENREN, "GUZHENREN Mod");
        add(ModKeyBindings.KEY_OPEN_PLAYER_GUI, "Player Gui");
    }

    private void addItemToolTipsTranslations() {
        add("tooltip.guzhenren.primeval_stone.tooltip", "regenerate primeval essence");
    }

    private void addGuMasterTalentTranslations() {
        add(GuMasterTalent.A.getNameKey(), "A");
        add(GuMasterTalent.B.getNameKey(), "B");
        add(GuMasterTalent.C.getNameKey(), "C");
        add(GuMasterTalent.D.getNameKey(), "D");
        add(GuMasterTalent.TEN_EXTREME.getNameKey(), "Ten Extreme Physique");
        add(GuMasterTalent.NULL.getNameKey(), "Ordinary");
    }

    private void addGuMasterRankTranslations() {
        add(GuMasterRank.MORTAL.getNameKey(), "Mortal");

        add(GuMasterRank.RANK_ONE_INIT.getNameKey(), "Rank One Init");
        add(GuMasterRank.RANK_ONE_MID.getNameKey(), "Rank One Mid");
        add(GuMasterRank.RANK_ONE_UPPER.getNameKey(), "Rank One Upper");
        add(GuMasterRank.RANK_ONE_PEAK.getNameKey(), "Rank One Peak");

        add(GuMasterRank.RANK_TWO_INIT.getNameKey(), "Rank Two Init");
        add(GuMasterRank.RANK_TWO_MID.getNameKey(), "Rank Two Mid");
        add(GuMasterRank.RANK_TWO_UPPER.getNameKey(), "Rank Two Upper");
        add(GuMasterRank.RANK_TWO_PEAK.getNameKey(), "Rank Two Peak");
    }

    private void addTenExtremePhysiqueTranslations() {
        add(ModTenExtremePhysique.VERDANT_GREAT_SUN.getNameKey(), "Verdant Great Sun");
        add(ModTenExtremePhysique.DESOLATE_ANCIENT_MOON.getNameKey(), "Desolate Ancient Moon");
        add(ModTenExtremePhysique.NORTHERN_DARK_ICE_SOUL.getNameKey(), "Northern Dark Ice Soul");
        add(ModTenExtremePhysique.BOUNDLESS_FOREST_SAMSARA.getNameKey(), "Boundless Forest Samsara");
        add(ModTenExtremePhysique.BLAZING_GLORY_LIGHTNING_BRILLIANCE.getNameKey(), "Blazing Glory Lightning Brilliance");
        add(ModTenExtremePhysique.MYRIAD_GOLD_WONDROUS_ESSENCE.getNameKey(), "Myriad Gold Wondrous Essence");
        add(ModTenExtremePhysique.GREAT_STRENGTH_TRUE_MARTIAL.getNameKey(), "Great Strength True Martial");
        add(ModTenExtremePhysique.CAREFREE_WISDOM_HEART.getNameKey(), "Carefree Wisdom Heart");
        add(ModTenExtremePhysique.CENTRAL_EARTH_ESSENCE.getNameKey(), "Central Earth Essence");
        add(ModTenExtremePhysique.UNIVERSE_GREAT_DERIVATION.getNameKey(), "Universe Great Derivation");
        add(ModTenExtremePhysique.PURE_DREAM_REALITY_SEEKER.getNameKey(), "Pure Dream Reality Seeker");
        add(ModTenExtremePhysique.NULL.getNameKey(), "None");
    }

    private void addCreativeTab(String nameKey, String translation) {
        add("itemGroup." + Guzhenren.MOD_ID + "." + nameKey, translation);
    }
}
