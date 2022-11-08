package com.github.rawtoast.component

import com.badlogic.ashley.core.Component
import java.text.Normalizer

final case class StateComponent(
    isLooping: Boolean = false,
    time: Float = 0f,
    state: State = State.STATE_NORMAL
) extends Component

enum State:
  // Probably can remove the STATE_ prefix
  case STATE_NORMAL
  case STATE_JUMPING
  case STATE_FALLING
  case STATE_MOVING
  case STATE_HIT

object StateComponent:
  // Might not need this either
  def set(component: StateComponent, state: State): StateComponent =
    component.copy(state = state)
