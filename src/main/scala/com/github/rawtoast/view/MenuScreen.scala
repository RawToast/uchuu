package com.github.rawtoast.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.viewport.ScreenViewport

import com.github.rawtoast.Uchuu

final case class MenuScreen(parent: Uchuu) extends Screen:
  val stage = new Stage(new ScreenViewport())
  Gdx.input.setInputProcessor(stage)
  stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f))
  stage.draw()

  override def show(): Unit =
    // Create a table that fills the screen. Everything else will go inside this table.
    val table = new Table()
    table.setFillParent(true)
    table.setDebug(true)
    stage.addActor(table)

    // Create buttons
    val skin = new Skin(Gdx.files.internal("skin/uiskin.json"))
    val newGame = new TextButton("New Game", skin)
    val preferences = new TextButton("Preferences", skin)
    val exit = new TextButton("Exit", skin)

    table.add(newGame).fillX().uniformX()
    table.row().pad(10, 0, 10, 0)
    table.add(preferences).fillX().uniformX()
    table.row()
    table.add(exit).fillX().uniformX()

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
  override def dispose(): Unit = ()
