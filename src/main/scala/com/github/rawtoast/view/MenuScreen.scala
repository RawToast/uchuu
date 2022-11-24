package com.github.rawtoast.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent
import com.badlogic.gdx.utils.viewport.ScreenViewport

import com.github.rawtoast.Uchuu

final case class MenuScreen(parent: Uchuu) extends Screen:
  val stage = Stage(ScreenViewport())
  stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f))
  stage.draw()

  override def show(): Unit =
    // Create a table that fills the screen. Everything else will go inside this table.
    val table = Table()
    table.setFillParent(true)
    table.setDebug(true)
    stage.addActor(table)

    // Create buttons
    val skin = Skin(Gdx.files.internal("skin/uiskin.json"))
    val newGame = TextButton("New Game", skin)
    val preferences = TextButton("Preferences", skin)
    val exit = TextButton("Exit", skin)

    table.add(newGame).fillX().uniformX()
    table.row().pad(10, 0, 10, 0)
    table.add(preferences).fillX().uniformX()
    table.row()
    table.add(exit).fillX().uniformX()

    // Add listeners to buttons
    exit.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          Gdx.app.exit()
    )

    newGame.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.changeScreen(Uchuu.Screen.APPLICATION)
    )

    preferences.addListener(
      new ChangeListener:
        override def changed(event: ChangeEvent, actor: Actor): Unit =
          parent.changeScreen(Uchuu.Screen.PREFERENCES)
    )
    Gdx.input.setInputProcessor(stage)

    // preferences.addListener(event =>
    //   parent.changeScreen(Uchuu.Screen.PREFERENCES)
    //   false
    // )

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
