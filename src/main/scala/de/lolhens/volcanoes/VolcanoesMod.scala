package de.lolhens.volcanoes

import de.lolhens.volcanoes.block.VolcanoCoreBlock
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.fabricmc.loader.api.metadata.ModMetadata
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.{BlockItem, Item, ItemGroup}
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

import scala.jdk.CollectionConverters._

object VolcanoesMod extends ModInitializer {
  val metadata: ModMetadata = {
    FabricLoader.getInstance().getEntrypointContainers("main", classOf[ModInitializer])
      .iterator().asScala.find(this eq _.getEntrypoint).get.getProvider.getMetadata
  }

  val volcanoCoreBlockId = new Identifier(metadata.getId, "volcano_core")
  val volcanoCoreBlock: VolcanoCoreBlock = new VolcanoCoreBlock()
  val volcanoCoreBlockEntity: BlockEntityType[_] = volcanoCoreBlock.blockEntityType

  override def onInitialize(): Unit = {
    Registry.register(Registry.BLOCK, volcanoCoreBlockId, volcanoCoreBlock)
    Registry.register(Registry.ITEM, volcanoCoreBlockId, new BlockItem(volcanoCoreBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)))
    Registry.register(Registry.BLOCK_ENTITY_TYPE, volcanoCoreBlockId, volcanoCoreBlockEntity)

    //ServerTickEvents.START_WORLD_TICK.register()
    //ServerTickEvents.END_WORLD_TICK.register()
  }
}
