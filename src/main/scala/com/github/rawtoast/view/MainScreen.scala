package com.github.rawtoast.view

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer

import com.github.rawtoast.Uchuu
import com.github.rawtoast.controller.KeyboardController
import com.badlogic.gdx.Gdx

final case class MainScreen(parent: Uchuu) extends Screen:
  val cam = OrthographicCamera(32, 24)
  // Perhaps this should be injected?
  val controller = KeyboardController()
  // val model = new B2dModel(controller)
  val debugRenderer = Box2DDebugRenderer(true, true, true, true, true, true)

  override def show(): Unit = 
    Gdx.input.setInputProcessor(controller)
    
  override def render(delta: Float): Unit = ()
  override def resize(width: Int, height: Int): Unit = ()
  override def pause(): Unit = ()
  override def resume(): Unit = 
    Gdx.input.setInputProcessor(controller)
  override def hide(): Unit = ()
  override def dispose(): Unit = ()
