package com.github.rawtoast.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Slider
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent
import com.badlogic.gdx.utils.viewport.ScreenViewport

import com.github.rawtoast.Uchuu

import org.lwjgl.system.Checks
import scala.annotation.newMain

final case class PreferencesScreen(parent: Uchuu) extends Screen:
  val stage = Stage(ScreenViewport())
  stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f))
  stage.draw()

  override def show(): Unit =
    stage.clear()
    Gdx.input.setInputProcessor(stage)

    // All of this should be moved
    val table = Table()
    table.setFillParent(true)
    // table.setDebug(true) // setting?
    stage.addActor(table)

    val skin = Skin(Gdx.files.internal("skin/uiskin.json"))

    val musicVolumeSlider = Slider(0f, 1f, 0.1f, false, skin)
    musicVolumeSlider.setValue(parent.preferences.getMusicVolume())
    musicVolumeSlider.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.preferences.setMusicVolume(musicVolumeSlider.getValue())
    )

    val soundVolumeSlider = Slider(0f, 1f, 0.1f, false, skin)
    soundVolumeSlider.setValue(parent.preferences.getSoundVolume())
    soundVolumeSlider.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.preferences.setSoundVolume(soundVolumeSlider.getValue())
    )

    val soundCheckBox = CheckBox("Sound", skin)
    soundCheckBox.setChecked(parent.preferences.isSoundEnabled())
    soundCheckBox.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.preferences.setSoundEnabled(soundCheckBox.isChecked())
    )

    val musicCheckBox = CheckBox("Music", skin)
    musicCheckBox.setChecked(parent.preferences.isMusicEnabled())
    musicCheckBox.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.preferences.setMusicEnabled(musicCheckBox.isChecked())
    )

    val backButton = TextButton("Back", skin) // small doesn't work
    backButton.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.changeScreen(Uchuu.Screen.MENU)
    )

    val titleLabel = Label("Preferences", skin)
    val musicVolumeLabel = Label("Music Volumne", skin)
    val musicEnabledLabel = Label("Music Enabled", skin)
    val soundVolumeLabel = Label("Sound Volumne", skin)
    val soundEnabledLabel = Label("Sound Enabled", skin)

    // this looks like it's extractable to a helper
    table.add(titleLabel).colspan(2)
    table.row().pad(10, 0, 0, 10) // Seems like another helper
    table.add(musicVolumeLabel).left()
    table.add(musicVolumeSlider)
    table.row().pad(10, 0, 0, 10)
    table.add(musicEnabledLabel).left()
    table.add(musicCheckBox)
    table.row().pad(10, 0, 0, 10)
    table.add(soundVolumeLabel).left()
    table.add(soundVolumeSlider)
    table.row().pad(10, 0, 0, 10)
    table.add(soundEnabledLabel).left()
    table.add(soundCheckBox)
    table.row().pad(10, 0, 0, 10)
    table.add(backButton).colspan(2)

  override def render(delta: Float): Unit =
    Gdx.gl.glClearColor(0f, 0f, 0f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f))
    stage.draw()

  override def resize(width: Int, height: Int): Unit =
    stage.getViewport().update(width, height, true)

  override def pause(): Unit = ()
  override def resume(): Unit = ()
  override def hide(): Unit = ()
  override def dispose(): Unit =
    stage.dispose()
