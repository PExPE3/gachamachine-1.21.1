package com.hisroyalty;

import com.hisroyalty.block.GachaMachineBlock;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public class GachaMachineBlockRenderer extends BlockModelRenderer {
    public GachaMachineBlockRenderer(BlockColors colors) {
        super(colors);
    }


    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final TextRenderer textRenderer = client.textRenderer;



    @Override
    public void render(BlockRenderView world, BakedModel model, BlockState state, BlockPos pos, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, long seed, int overlay) {
        int emeraldsLeft = state.get(GachaMachineBlock.LEVEL);  // Get emeralds left from block state

        String emeraldText = "Emeralds Left: " + emeraldsLeft;
        Text text = Text.of(emeraldText);

        // Set the position where the text should appear (above the block)
        matrices.push();
        matrices.translate(pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5);  // Adjust the Y to position it above the block
        matrices.scale(-0.025F, -0.025F, 0.025F);  // Scale the text size

        Matrix4f matrix = matrices.peek().getPositionMatrix();


        // Render the text
        RenderSystem.enableBlend();
        textRenderer.draw(text, (float) (-textRenderer.getWidth(text) / 2), (float) 0, 0xFFFFFF, true, matrix, (VertexConsumerProvider) vertexConsumer, TextRenderer.TextLayerType.NORMAL, 0x000000, overlay);
        RenderSystem.disableBlend();

        matrices.pop();
        super.render(world, model, state, pos, matrices, vertexConsumer, cull, random, seed, overlay);
    }
}
