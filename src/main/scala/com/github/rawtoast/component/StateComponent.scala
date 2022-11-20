package com.github.rawtoast.component

import com.badlogic.ashley.core.Component

import java.text.Normalizer

final case class StateComponent(
    isLooping: Boolean = false,
    var time: Float = 0f,
    var state: StateComponent.State = State.NORMAL
) extends Component:
  import StateComponent.State

  def isNormalOrMoving: Boolean =
    state == State.NORMAL || state == State.MOVING

object StateComponent:
  enum State:
    case NORMAL
    case JUMPING
    case FALLING
    case MOVING
    case HIT
