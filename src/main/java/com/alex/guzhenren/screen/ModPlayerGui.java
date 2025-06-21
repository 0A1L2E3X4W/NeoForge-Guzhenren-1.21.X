package com.alex.guzhenren.screen;

import com.alex.guzhenren.utils.ModPlayerUtils;
import com.alex.guzhenren.utils.enums.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ModPlayerGui extends Screen {

    public ModPlayerGui(Player player) {
        super(Component.translatable("screen.guzhenren.title"));
        this.player = player;
    }

    private final Player player;

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        float playerCurrentEssence = ModPlayerUtils.getCurrentEssence(player);
        int playerMaxEssence = ModPlayerUtils.getMaxEssence(player);
        GuMasterRank playerRank = ModPlayerUtils.getRank(player);
        GuMasterTalent playerTalent = ModPlayerUtils.getTalent(player);
        ModTenExtremePhysique playerExtremePhysique = ModPlayerUtils.getExtremePhysique(player);

        guiGraphics.drawString(this.font,
                Component.translatable("screen.guzhenren.rank")
                        .append(": ")
                        .append(Component.translatable(playerRank.getNameKey())),
                20, 20, 0xFFFFFF);

        guiGraphics.drawString(this.font,
                Component.translatable("screen.guzhenren.essence")
                        .append(": ")
                        .append(String.format("%.1f / %d", playerCurrentEssence, playerMaxEssence)),
                20, 40, 0xFFFFFF);

        guiGraphics.drawString(this.font,
                Component.translatable("screen.guzhenren.talent")
                        .append(": ")
                        .append(Component.translatable(playerTalent.getNameKey())),
                20, 60, 0xFFFFFF);

        guiGraphics.drawString(this.font,
                Component.translatable("screen.guzhenren.extreme_physique")
                        .append(": ")
                        .append(Component.translatable(playerExtremePhysique.getNameKey())),
                20, 80, 0xFFFFFF);
    }
}
