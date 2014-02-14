/*
 * Copyright (c) bdew, 2014
 * https://github.com/bdew/eumfr
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/eumfr/master/MMPL-1.0.txt
 */

package net.bdew.eu_mfr

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent}
import java.util.logging.Logger
import net.minecraftforge.common.Configuration
import powercrystals.minefactoryreloaded.api.FactoryRegistry

@Mod(modid = "eu_mfr", name = "EU/MFR Integration", version = "EU_MFR_VER", dependencies = "required-after:ExtraUtilities;required-after:MineFactoryReloaded", modLanguage = "scala")
object EuMfrIntegration {
  var log: Logger = null
  var enderLilyId = -1

  var plantOnDirt = false
  var plantOnEndstone = false
  var canHarvest = false
  var canFertilize = false

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    log = event.getModLog
    val cfg = new Configuration(event.getSuggestedConfigurationFile)
    cfg.load()
    plantOnDirt = cfg.get(Configuration.CATEGORY_GENERAL, "PlantOnDirt", true).getBoolean(false)
    plantOnEndstone = cfg.get(Configuration.CATEGORY_GENERAL, "PlantOnEndstone", true).getBoolean(false)
    canHarvest = cfg.get(Configuration.CATEGORY_GENERAL, "CanHarvest", true).getBoolean(false)
    canFertilize = cfg.get(Configuration.CATEGORY_GENERAL, "CanFertilize", true).getBoolean(false)
    cfg.save()

  }

  @EventHandler
  def init(event: FMLInitializationEvent) {
    val cExtraUtils = Class.forName("extrautils.ExtraUtils")
    enderLilyId = cExtraUtils.getField("enderLilyId").get(null).asInstanceOf[Int]
    log.info("Ender Lilly ID = %d".format(enderLilyId))
    if (plantOnDirt || plantOnEndstone) FactoryRegistry.registerPlantable(EnderLilyPlantable)
    if (canHarvest) FactoryRegistry.registerHarvestable(EnderLilyHarvestable)
    if (canFertilize) FactoryRegistry.registerFertilizable(EnderLilyFertilizable)
  }
}
