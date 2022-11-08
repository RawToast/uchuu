package com.github.rawtoast.component
 
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
 
final case class CollisionComponent(
    collisionEntity: Entity
) extends Component

