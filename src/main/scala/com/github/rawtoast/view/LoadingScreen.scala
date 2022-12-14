package com.github.rawtoast.view

import com.badlogic.gdx.Screen

import com.github.rawtoast.Uchuu

final case class LoadingScreen(parent: Uchuu) extends Screen:
  override def show(): Unit = ()
  override def render(delta: Float): Unit = 
    parent.changeScreen(Uchuu.Screen.MENU)
  override def resize(width: Int, height: Int): Unit = ()
  override def pause(): Unit = ()
  override def resume(): Unit = ()
  override def hide(): Unit = ()
  override def dispose(): Unit = ()
