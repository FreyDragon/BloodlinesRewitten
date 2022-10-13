package endermanfrey.bloodlinesrewritten.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import javax.annotation.Nullable;

import endermanfrey.bloodlinesrewritten.network.BloodlinesRewrittenModVariables;

@Mod.EventBusSubscriber
public class GameLoopProcedure {
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
		if (("null").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
			{
				double _setval = 0;
				entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CanUseAbility2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CanUseAbility1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BloodlineLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (("Mer").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				{
					double _setval = 1;
					entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CanUseAbility1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 1) {
					if (entity.isInWaterRainOrBubble()) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 1));
					} else {
						entity.setSecondsOnFire(15);
					}
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 2) {
					if (entity.isInWaterRainOrBubble()) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 1));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1));
					} else {
						entity.setSecondsOnFire(15);
					}
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 3) {
					if (entity.isInWaterRainOrBubble()) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 1));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 3));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 2));
					} else {
						entity.setSecondsOnFire(15);
					}
					{
						double _setval = 1;
						entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CanUseAbility2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (("Aasimar").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				{
					double _setval = 1;
					entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CanUseAbility1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 2) {
					if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.HEALTH_BOOST) : false)) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200000, 4));
					}
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 3) {
					{
						double _setval = 1;
						entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CanUseAbility2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (("Draconic").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				{
					double _setval = 1;
					entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CanUseAbility1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 2) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 4));
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 3) {
					{
						double _setval = 1;
						entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CanUseAbility2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (("Fae").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, (ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, (ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, (ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, (ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, (ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, (ItemStack.EMPTY));
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, (ItemStack.EMPTY));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, (ItemStack.EMPTY));
					}
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (("Fae")
							.equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline));
					_player.onUpdateAbilities();
				}
				{
					double _setval = 1;
					entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CanUseAbility1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 2) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 4));
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 3) {
					{
						double _setval = 1;
						entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CanUseAbility2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (("Ender").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				{
					double _setval = 1;
					entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CanUseAbility1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 2) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 2));
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 3) {
					{
						double _setval = 1;
						entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CanUseAbility2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (entity.isInWaterRainOrBubble()) {
					entity.hurt(DamageSource.DROWN, 1);
				}
			}
			if (("Dwarf").equals((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).Bloodline)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 3));
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel >= 2) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 2));
				}
				if ((entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel == 3) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4));
				}
			}
		}
	}
