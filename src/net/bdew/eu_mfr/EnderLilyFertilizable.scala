/*
 * Copyright (c) bdew, 2014
 * https://github.com/bdew/eumfr
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/eumfr/master/MMPL-1.0.txt
 */

package net.bdew.eu_mfr

import powercrystals.minefactoryreloaded.api.{FertilizerType, IFactoryFertilizable}
import net.minecraft.world.World
import java.util.Random
import net.minecraft.block.{BlockCrops, Block}

object EnderLilyFertilizable extends IFactoryFertilizable {
  def getFertilizableBlockId: Int = EuMfrIntegration.enderLilyId

  def canFertilizeBlock(world: World, x: Int, y: Int, z: Int, fertilizerType: FertilizerType): Boolean =
    world.getBlockMetadata(x, y, z) < 7

  def fertilize(world: World, rand: Random, x: Int, y: Int, z: Int, fertilizerType: FertilizerType): Boolean = {
    Block.crops.asInstanceOf[BlockCrops].fertilize(world, x, y, z)
    return true
  }
}
