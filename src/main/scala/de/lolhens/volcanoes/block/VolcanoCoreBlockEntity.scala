package de.lolhens.volcanoes.block

import net.minecraft.block.Blocks
import net.minecraft.block.entity.{BlockEntity, BlockEntityType}
import net.minecraft.util.Tickable

class VolcanoCoreBlockEntity(`type`: BlockEntityType[VolcanoCoreBlockEntity]) extends BlockEntity(`type`) with Tickable {
  override def tick(): Unit = {
    world.setBlockState(pos.up(), Blocks.MAGMA_BLOCK.getDefaultState)
  }
}
