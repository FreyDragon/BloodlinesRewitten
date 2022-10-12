
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package endermanfrey.bloodlinesrewritten.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import endermanfrey.bloodlinesrewritten.client.gui.LevelGUIScreen;
import endermanfrey.bloodlinesrewritten.client.gui.ChooseBloodlineGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BloodlinesRewrittenModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BloodlinesRewrittenModMenus.CHOOSE_BLOODLINE_GUI, ChooseBloodlineGUIScreen::new);
			MenuScreens.register(BloodlinesRewrittenModMenus.LEVEL_GUI, LevelGUIScreen::new);
		});
	}
}
