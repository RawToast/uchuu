package com.github.rawtoast.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer

import com.github.rawtoast.Uchuu
import com.github.rawtoast.UchuuModel
import com.github.rawtoast.controller.KeyboardController

final case class MainScreen(parent: Uchuu) extends Screen:
  val model = UchuuModel()
  val cam = OrthographicCamera(32, 24)
  // Perhaps this should be injected?
  val controller = KeyboardController()

  val debugRenderer = Box2DDebugRenderer(true, true, true, true, true, true)

  override def show(): Unit =
    Gdx.input.setInputProcessor(controller)

  override def render(delta: Float): Unit =
    model.logicStep(delta)
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    debugRenderer.render(model.world, cam.combined)

  override def resize(width: Int, height: Int): Unit = ()
  override def pause(): Unit = ()
  override def resume(): Unit =
    Gdx.input.setInputProcessor(controller)
  override def hide(): Unit = ()
  override def dispose(): Unit = ()
