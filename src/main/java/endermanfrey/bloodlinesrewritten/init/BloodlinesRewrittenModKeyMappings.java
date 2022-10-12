
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package endermanfrey.bloodlinesrewritten.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import endermanfrey.bloodlinesrewritten.network.OpenLevelMenuMessage;
import endermanfrey.bloodlinesrewritten.network.Ability2Message;
import endermanfrey.bloodlinesrewritten.network.Ability1Message;
import endermanfrey.bloodlinesrewritten.BloodlinesRewrittenMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BloodlinesRewrittenModKeyMappings {
	public static final KeyMapping ABILITY_1 = new KeyMapping("key.bloodlines_rewritten.ability_1", GLFW.GLFW_KEY_R, "key.categories.misc");
	public static final KeyMapping ABILITY_2 = new KeyMapping("key.bloodlines_rewritten.ability_2", GLFW.GLFW_KEY_G, "key.categories.misc");
	public static final KeyMapping OPEN_LEVEL_MENU = new KeyMapping("key.bloodlines_rewritten.open_level_menu", GLFW.GLFW_KEY_I,
			"key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ABILITY_1);
		ClientRegistry.registerKeyBinding(ABILITY_2);
		ClientRegistry.registerKeyBinding(OPEN_LEVEL_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == ABILITY_1.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new Ability1Message(0, 0));
						Ability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == ABILITY_2.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new Ability2Message(0, 0));
						Ability2Message.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == OPEN_LEVEL_MENU.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new OpenLevelMenuMessage(0, 0));
						OpenLevelMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
