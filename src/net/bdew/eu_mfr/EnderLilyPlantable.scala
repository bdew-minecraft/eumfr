/*
 * Copyright (c) bdew, 2014
 * https://github.com/bdew/eumfr
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/eumfr/master/MMPL-1.0.txt
 */

package net.bdew.eu_mfr

import powercrystals.minefactoryreloaded.api.IFactoryPlantable
import net.minecraft.world.World
import net.minecraft.item.ItemStack
import net.minecraft.block.Block

object EnderLilyPlantable extends IFactoryPlantable {
  def getSeedId: Int = EuMfrIntegration.enderLilyId
  def getPlantedBlockId(world: World, x: Int, y: Int, z: Int, stack: ItemStack): Int = EuMfrIntegration.enderLilyId
  def getPlantedBlockMetadata(world: World, x: Int, y: Int, z: Int, stack: ItemStack): Int = 0
  def canBePlantedHere(world: World, x: Int, y: Int, z: Int, stack: ItemStack): Boolean =
    world.isAirBlock(x, y, z) &&
      ((world.getBlockId(x, y - 1, z) == Block.whiteStone.blockID && EuMfrIntegration.plantOnEndstone) ||
        (world.getBlockId(x, y - 1, z) == Block.dirt.blockID && EuMfrIntegration.plantOnDirt))
  def prePlant(world: World, x: Int, y: Int, z: Int, stack: ItemStack) {}
  def postPlant(world: World, x: Int, y: Int, z: Int, stack: ItemStack) {}
}
