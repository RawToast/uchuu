package com.github.rawtoast.controller

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Vector2

class KeyboardController extends InputProcessor():
  private var leftPressed, rightPressed = false
  private var upPressed, downPressed = false

  private var isMouse1Down, isMouse2Down, isMouse3Down = false
  private var isDragged = false
  private val mousePosition = new Vector2(0, 0)

  override def keyDown(keycode: Int): Boolean =
    keycode match
      case Keys.LEFT  => leftPressed = true
      case Keys.RIGHT => rightPressed = true
      case Keys.UP    => upPressed = true
      case Keys.DOWN  => downPressed = true
      case _: Int     => ()
    leftPressed || rightPressed || upPressed || downPressed

  override def keyUp(keycode: Int): Boolean =
    keycode match
      case Keys.LEFT  => leftPressed = false
      case Keys.RIGHT => rightPressed = false
      case Keys.UP    => upPressed = false
      case Keys.DOWN  => downPressed = false
      case _: Int     => ()
    !(leftPressed || rightPressed || upPressed || downPressed)
  override def keyTyped(character: Char): Boolean = false
  override def touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean =
    if (button == 0)
      isMouse1Down = true
    else if (button == 1)
      isMouse2Down = true
    else if (button == 2)
      isMouse3Down = true
    mousePosition.set(screenX.toFloat, screenY.toFloat)
    return false

  override def touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean =
    isDragged = false
    if (button == 0)
      isMouse1Down = false
    else if (button == 1)
      isMouse2Down = false
    else if (button == 2)
      isMouse3Down = false
    mousePosition.set(screenX.toFloat, screenY.toFloat)
    false

  override def touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean =
    isDragged = true
    mousePosition.set(screenX.toFloat, screenY.toFloat)
    false

  override def mouseMoved(screenX: Int, screenY: Int): Boolean =
    mousePosition.set(screenX.toFloat, screenY.toFloat)
    false

  override def scrolled(x: Float, y: Float): Boolean = false

  def isLeftPressed: Boolean = leftPressed
  def isRightPressed: Boolean = rightPressed
  def isUpPressed: Boolean = upPressed
  def isDownPressed: Boolean = downPressed
