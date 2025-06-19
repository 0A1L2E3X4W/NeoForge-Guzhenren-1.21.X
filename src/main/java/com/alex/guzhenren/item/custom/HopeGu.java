package com.alex.guzhenren.item.custom;

import com.alex.guzhenren.utils.ModPlayerUtils;
import com.alex.guzhenren.utils.enums.GuMasterRank;
import com.alex.guzhenren.utils.enums.GuMasterTalent;
import com.alex.guzhenren.utils.enums.ModTenExtremePhysique;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HopeGu extends Item {

    public HopeGu(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemStack = player.getItemInHand(usedHand);

        if (level.isClientSide) { return InteractionResultHolder.fail(itemStack); }

        // SET IS AWAKEN
        boolean isAwaken = ModPlayerUtils.getIsAwaken(player);
        if (isAwaken) { return InteractionResultHolder.fail(itemStack); }
//        ModPlayerUtils.setIsAwaken(player, true);

        // SET INIT STATS
        generateBasicStats(player);

        // REDUCE ITEM BY 1
        itemStack.shrink(1);

        System.out.println(ModPlayerUtils.getMaxEssence(player));
        System.out.println(ModPlayerUtils.getCurrentEssence(player));

        return InteractionResultHolder.success(itemStack);
    }

    private void generateBasicStats(Player player) {
        GuMasterTalent talent = getRandomPlayerTalent();
        int maxEss = getMaxEssence(talent);
        float currentEss = maxEss * 0.75f;

        ModPlayerUtils.setMaxEssence(player, maxEss);
        ModPlayerUtils.setCurrentEssence(player, currentEss);
        ModPlayerUtils.setRank(player, GuMasterRank.RANK_ONE_INIT);
        ModPlayerUtils.setTalent(player, talent);

        ModTenExtremePhysique extremePhysique;

        if (talent == GuMasterTalent.TEN_EXTREME) {
            extremePhysique = getRandomExtremePhysique();
            ModPlayerUtils.setExtremePhysique(player, extremePhysique);
        } else {
            ModPlayerUtils.setExtremePhysique(player, ModTenExtremePhysique.NULL);
        }
    }

    private GuMasterTalent getRandomPlayerTalent() {
        Random rand = new Random();
        double r = rand.nextDouble() * 100;

        if (r < 25) return GuMasterTalent.D;
        if (r < 50) return GuMasterTalent.C;
        if (r < 70) return GuMasterTalent.B;
        if (r < 90) return GuMasterTalent.A;
        return GuMasterTalent.TEN_EXTREME;
    }

    private int getMaxEssence(GuMasterTalent talent) {
        Random rand = new Random();
        int max = 100000;
        int min = 10000;

        if (talent == GuMasterTalent.A) { min = 80000; max = 99000; }
        if (talent == GuMasterTalent.B) { min = 60000; max = 79999; }
        if (talent == GuMasterTalent.C) { min = 40000; max = 59999; }
        if (talent == GuMasterTalent.D) { min = 20000; max = 39999; }
        if (talent == GuMasterTalent.TEN_EXTREME) { return 100000; }

        return rand.nextInt(max - min + 1) + min;
    }

    private ModTenExtremePhysique getRandomExtremePhysique() {
        List<ModTenExtremePhysique> validPhysiques = new ArrayList<>();
        for (ModTenExtremePhysique physique : ModTenExtremePhysique.values()) {
            if (physique != ModTenExtremePhysique.NULL && physique != ModTenExtremePhysique.PURE_DREAM_REALITY_SEEKER) {
                validPhysiques.add(physique);
            }
        }

        int index = new Random().nextInt(validPhysiques.size());
        return validPhysiques.get(index);
    }
}
