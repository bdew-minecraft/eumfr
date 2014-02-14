/*
 * Copyright (c) bdew, 2014
 * https://github.com/bdew/eumfr
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/eumfr/master/MMPL-1.0.txt
 */

package net.bdew.eu_mfr

import powercrystals.minefactoryreloaded.api.{HarvestType, IFactoryHarvestable}
import net.minecraft.world.World
import java.util.Random
import java.util
import java.lang.{Boolean => JBoolean}
import net.minecraft.item.ItemStack
import net.minecraft.block.Block

object EnderLilyHarvestable extends IFactoryHarvestable {
  def getPlantId = EuMfrIntegration.enderLilyId
  def getHarvestType = HarvestType.Normal
  def breakBlock(): Boolean = true
  def canBeHarvested(world: World, harvesterSettings: util.Map[String, JBoolean], x: Int, y: Int, z: Int): Boolean = world.getBlockMetadata(x, y, z) >= 7
  def getDrops(world: World, rand: Random, harvesterSettings: util.Map[String, JBoolean], x: Int, y: Int, z: Int): util.List[ItemStack] =
    Block.blocksList(EuMfrIntegration.enderLilyId).getBlockDropped(world, x, y, z, world.getBlockMetadata(x, y, z), 0)
  def preHarvest(world: World, x: Int, y: Int, z: Int) {}
  def postHarvest(world: World, x: Int, y: Int, z: Int) {}
}
