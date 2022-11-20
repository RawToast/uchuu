package com.github.rawtoast.component

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.glutils.GLVersion.Type

final case class TypeComponent(kind: TypeComponent.Entity = Entity.OTHER) extends Component

object TypeComponent:
  enum Entity:
    case PLAYER
    case ENEMY
    case SCENERY
    case OTHER
