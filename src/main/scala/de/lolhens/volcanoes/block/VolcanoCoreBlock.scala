package de.lolhens.volcanoes.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block._
import net.minecraft.block.entity.{BlockEntity, BlockEntityType}
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.world.BlockView

class VolcanoCoreBlock() extends Block(VolcanoCoreBlock.settings) with BlockEntityProvider {
  val blockEntityType: BlockEntityType[VolcanoCoreBlockEntity] =
    BlockEntityType.Builder.create(() => new VolcanoCoreBlockEntity(blockEntityType), this)
      .build(null)

  override def createBlockEntity(world: BlockView): BlockEntity = blockEntityType.instantiate()

  override def getPistonBehavior(state: BlockState): PistonBehavior = PistonBehavior.BLOCK
}

object VolcanoCoreBlock {
  private val settings =
    FabricBlockSettings
      .of(Material.STONE)
      .requiresTool()
      .hardness(3.0F)
}

