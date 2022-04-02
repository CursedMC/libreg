@file:Environment(EnvType.CLIENT)

package dev.cursedmc.libreg.example.block.entity.client

import dev.cursedmc.libreg.example.block.entity.ExampleBlockEntities
import dev.cursedmc.libreg.example.block.entity.TestBlockEntity
import dev.cursedmc.libreg.registry.block.entity.blockEntityRenderer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.RenderLayers
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.BlockRenderManager
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.Vec3d
import kotlin.random.Random

// cursed class name

class TestBlockEntityRenderer(private val renderManager: BlockRenderManager) : BlockEntityRenderer<TestBlockEntity> {
	override fun render(entity: TestBlockEntity, tickDelta: Float, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, overlay: Int) {
		// If delay has ended
		if (translationTime + shakeDelay < System.currentTimeMillis()) {
			// Randomize offset
			offset = Vec3d(
				Random.nextDouble(-maxOffset, maxOffset),
				Random.nextDouble(-maxOffset, maxOffset),
				Random.nextDouble(-maxOffset, maxOffset),
			)
			translationTime = System.currentTimeMillis()
		}
		
		matrices.push()
		
		// Translate the model by the current offset
		matrices.translate(offset.x, offset.y, offset.z)
		
		// Render model
		// TODO: render red, green, and blue variants with their own offsets
		renderManager.modelRenderer.render(
			entity.world, renderManager.getModel(entity.cachedState), entity.cachedState, entity.pos, matrices,
			vertexConsumers.getBuffer(RenderLayers.getBlockLayer(entity.cachedState)),
			true, java.util.Random(), entity.cachedState.getRenderingSeed(entity.pos), OverlayTexture.DEFAULT_UV
		)
		
		matrices.pop()
	}
	
	companion object {
		// How long to wait until the offset is randomized again
		private const val shakeDelay = 25
		// How far the offset should render
		private const val maxOffset = .01
		
		// How far the BlockEntity will render outside of its model
		internal var offset = Vec3d(
			Random.nextDouble(-maxOffset, maxOffset),
			Random.nextDouble(-maxOffset, maxOffset),
			Random.nextDouble(-maxOffset, maxOffset),
		)
		// When the offset was last updated
		private var translationTime = System.currentTimeMillis()
	}
}

@Suppress("unused")
object ExampleBlockEntityRenderers {
	val test_renderer = blockEntityRenderer(
		{ TestBlockEntityRenderer(it.renderManager) },
		ExampleBlockEntities.TEST_TYPE,
	)
	
	/* no-op */
	fun initialize() = Unit
}
