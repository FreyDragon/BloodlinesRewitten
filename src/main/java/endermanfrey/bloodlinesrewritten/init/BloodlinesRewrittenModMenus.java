
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package endermanfrey.bloodlinesrewritten.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

import endermanfrey.bloodlinesrewritten.world.inventory.LevelGUIMenu;
import endermanfrey.bloodlinesrewritten.world.inventory.ChooseBloodlineGUIMenu;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloodlinesRewrittenModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<ChooseBloodlineGUIMenu> CHOOSE_BLOODLINE_GUI = register("choose_bloodline_gui",
			(id, inv, extraData) -> new ChooseBloodlineGUIMenu(id, inv, extraData));
	public static final MenuType<LevelGUIMenu> LEVEL_GUI = register("level_gui", (id, inv, extraData) -> new LevelGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
