package com.github.rawtoast

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences

final case class AppPreferences():
  import AppPreferences.*
  def getPreferences(): Preferences =
    Gdx.app.getPreferences(PREFS_NAME)

  def setMusicVolume(volume: Float): Unit =
    val prefs = getPreferences()
    prefs.putFloat(MUSIC_VOLUME, volume)
    prefs.flush()

  def getMusicVolume(): Float =
    val prefs = getPreferences()
    prefs.getFloat(MUSIC_VOLUME, 0.5f)

  def setSoundVolume(volume: Float): Unit =
    val prefs = getPreferences()
    prefs.putFloat(SOUND_VOLUME, volume)
    prefs.flush()

  def getSoundVolume(): Float =
    val prefs = getPreferences()
    prefs.getFloat(SOUND_VOLUME, 0.5f)

  def isMusicEnabled(): Boolean =
    val prefs = getPreferences()
    prefs.getBoolean(MUSIC_ENABLED, true)

  def setMusicEnabled(enabled: Boolean): Unit =
    val prefs = getPreferences()
    prefs.putBoolean(MUSIC_ENABLED, enabled)
    prefs.flush()

  def isSoundEnabled(): Boolean =
    val prefs = getPreferences()
    prefs.getBoolean(SOUND_ENABLED, true)

  def setSoundEnabled(enabled: Boolean): Unit =
    val prefs = getPreferences()
    prefs.putBoolean(SOUND_ENABLED, enabled)
    prefs.flush()

object AppPreferences:
  private val MUSIC_VOLUME = "music.volume"
  private val MUSIC_ENABLED = "music.enabled"
  private val SOUND_VOLUME = "sound.volume"
  private val SOUND_ENABLED = "sound.enabled"
  private val PREFS_NAME = "uchuu.prefs"
