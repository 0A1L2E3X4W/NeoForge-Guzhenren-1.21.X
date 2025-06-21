package com.alex.guzhenren.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final String KEY_CATEGORY_GUZHENREN = "key.category.guzhenren";
    public static final String KEY_OPEN_PLAYER_GUI = "key.guzhenren.open_player_gui";

    public static final KeyMapping PLAYER_GUI_KEY = new KeyMapping(
            KEY_OPEN_PLAYER_GUI,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            KEY_CATEGORY_GUZHENREN);

    @SubscribeEvent
    public static void eventInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || Minecraft.getInstance().screen != null || Minecraft.getInstance().level == null)
            return;

        if (PLAYER_GUI_KEY.consumeClick()) {
            return;
        }
    }
}
