package com.alex.guzhenren.item.custom;

import com.alex.guzhenren.utils.ModPlayerUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PrimevalStone extends Item {

    public PrimevalStone(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemStack = player.getItemInHand(usedHand);

        if (level.isClientSide) { return InteractionResultHolder.fail(itemStack); }

        float currentEssence = ModPlayerUtils.getCurrentEssence(player);
        int maxEssence = ModPlayerUtils.getMaxEssence(player);
        if (currentEssence == maxEssence) { return InteractionResultHolder.fail(itemStack); }

        ModPlayerUtils.changeCurrentEssence(player, 5f);
        itemStack.shrink(1);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.guzhenren.primeval_stone.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
