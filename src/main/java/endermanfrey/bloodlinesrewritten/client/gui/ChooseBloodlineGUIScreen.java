
package endermanfrey.bloodlinesrewritten.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import endermanfrey.bloodlinesrewritten.world.inventory.ChooseBloodlineGUIMenu;
import endermanfrey.bloodlinesrewritten.network.ChooseBloodlineGUIButtonMessage;
import endermanfrey.bloodlinesrewritten.BloodlinesRewrittenMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChooseBloodlineGUIScreen extends AbstractContainerScreen<ChooseBloodlineGUIMenu> {
	private final static HashMap<String, Object> guistate = ChooseBloodlineGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ChooseBloodlineGUIScreen(ChooseBloodlineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bloodlines_rewritten:textures/screens/choose_bloodline_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Choose a Bloodline", 6, 7, -12829636);
		this.font.draw(poseStack, "Strong in water,", 69, 25, -12829636);
		this.font.draw(poseStack, "weak on land.", 69, 34, -12829636);
		this.font.draw(poseStack, "Descended from the", 69, 52, -12829636);
		this.font.draw(poseStack, "angels themselves.", 69, 61, -12829636);
		this.font.draw(poseStack, "Tough, but not very", 69, 79, -12829636);
		this.font.draw(poseStack, "versatile.", 69, 88, -12829636);
		this.font.draw(poseStack, "Gain XP to level up!", 6, 16, -12829636);
		this.font.draw(poseStack, "Can fly, but can't", 69, 106, -12829636);
		this.font.draw(poseStack, "wear armor.", 69, 115, -12829636);
		this.font.draw(poseStack, "Can teleport, and", 69, 133, -12829636);
		this.font.draw(poseStack, "can't swim", 69, 142, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 25, 61, 20, new TextComponent("Merfolk"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new ChooseBloodlineGUIButtonMessage(0, x, y, z));
				ChooseBloodlineGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 52, 61, 20, new TextComponent("Aasimar"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new ChooseBloodlineGUIButtonMessage(1, x, y, z));
				ChooseBloodlineGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 79, 61, 20, new TextComponent("Draconi"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new ChooseBloodlineGUIButtonMessage(2, x, y, z));
				ChooseBloodlineGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 15, this.topPos + 106, 51, 20, new TextComponent("Faeri"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new ChooseBloodlineGUIButtonMessage(3, x, y, z));
				ChooseBloodlineGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 15, this.topPos + 133, 51, 20, new TextComponent("Ender"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new ChooseBloodlineGUIButtonMessage(4, x, y, z));
				ChooseBloodlineGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
