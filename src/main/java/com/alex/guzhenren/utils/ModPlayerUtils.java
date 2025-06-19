package com.alex.guzhenren.utils;

import com.alex.guzhenren.player.ModEssenceSystem;
import com.alex.guzhenren.player.ModPlayer;
import com.alex.guzhenren.utils.enums.GuMasterRank;
import com.alex.guzhenren.utils.enums.GuMasterTalent;
import com.alex.guzhenren.utils.enums.ModTenExtremePhysique;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;

public class ModPlayerUtils {

    // ESSENCE
    public static int getMaxEssence(Player player) {
        AttachmentType<ModEssenceSystem> essenceType = ModPlayer.ESSENCE.get();
        return player.getData(essenceType).maxVal();
    }

    public static float getCurrentEssence(Player player) {
        AttachmentType<ModEssenceSystem> essenceType = ModPlayer.ESSENCE.get();
        return player.getData(essenceType).currentVal();
    }

    public static void setMaxEssence(Player player, int newMax) {
        AttachmentType<ModEssenceSystem> essenceType = ModPlayer.ESSENCE.get();
        ModEssenceSystem essence = player.getData(essenceType);
        essence = essence.setMaxEssence(newMax);
        player.setData(essenceType, essence);
    }

    public static void setCurrentEssence(Player player, float newCurrent) {
        AttachmentType<ModEssenceSystem> essenceType = ModPlayer.ESSENCE.get();
        ModEssenceSystem essence = player.getData(essenceType);
        essence = essence.setCurrentEssence(newCurrent);
        player.setData(essenceType, essence);
    }

    public static void changeCurrentEssence(Player player, float delta) {
        AttachmentType<ModEssenceSystem> essenceType = ModPlayer.ESSENCE.get();
        ModEssenceSystem essence = player.getData(essenceType);
        essence = essence.setCurrentEssence(essence.currentVal() + delta);
        player.setData(essenceType, essence);
    }

    // AWAKEN APERTURE
    public static boolean getIsAwaken(Player player) {
        AttachmentType<Boolean> isAwaken = ModPlayer.IS_AWAKEN.get();
        return player.getData(isAwaken);
    }

    public static void setIsAwaken(Player player, boolean delta) {
        AttachmentType<Boolean> isAwaken = ModPlayer.IS_AWAKEN.get();
        player.setData(isAwaken, delta);
    }

    // GU MASTER TALENT
    public static GuMasterTalent getTalent(Player player) {
        AttachmentType<GuMasterTalent> talent = ModPlayer.PLAYER_TALENT.get();
        return player.getData(talent);
    }

    public static void setTalent(Player player, GuMasterTalent delta) {
        AttachmentType<GuMasterTalent> talent = ModPlayer.PLAYER_TALENT.get();
        player.setData(talent, delta);
    }

    // GU MASTER RANK
    public static GuMasterRank getRank(Player player) {
        AttachmentType<GuMasterRank> rank = ModPlayer.PLAYER_RANK.get();
        return player.getData(rank);
    }

    public static void setRank(Player player, GuMasterRank delta) {
        AttachmentType<GuMasterRank> rank = ModPlayer.PLAYER_RANK.get();
        player.setData(rank, delta);
    }

    // GU MASTER EXTREME PHYSIQUE
    public static ModTenExtremePhysique getExtremePhysique(Player player) {
        AttachmentType<ModTenExtremePhysique> extremePhysique = ModPlayer.PLAYER_EXTREME_PHYSIQUE.get();
        return player.getData(extremePhysique);
    }

    public static void setExtremePhysique(Player player, ModTenExtremePhysique delta) {
        AttachmentType<ModTenExtremePhysique> extremePhysique = ModPlayer.PLAYER_EXTREME_PHYSIQUE.get();
        player.setData(extremePhysique, delta);
    }
}
