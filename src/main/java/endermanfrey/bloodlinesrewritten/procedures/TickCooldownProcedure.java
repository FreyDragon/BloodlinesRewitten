package endermanfrey.bloodlinesrewritten.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import endermanfrey.bloodlinesrewritten.network.BloodlinesRewrittenModVariables;

@Mod.EventBusSubscriber
public class TickCooldownProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Ability1Cooldown + -1;
			entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Ability1Cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Ability2Cooldown + -1;
			entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Ability2Cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
