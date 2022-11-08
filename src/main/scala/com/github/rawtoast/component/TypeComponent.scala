package com.github.rawtoast.component

import com.badlogic.ashley.core.Component;

final case class TypeComponent(kind: Entity = Entity.OTHER) extends Component

enum Entity:
  // Probably can remove the STATE_ prefix
  case PLAYER
  case ENEMY
  case SCENERY
  case OTHER
