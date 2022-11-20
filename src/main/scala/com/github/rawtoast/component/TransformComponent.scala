package com.github.rawtoast.component

import com.badlogic.ashley.core.Component

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3;

case class TransformComponent(
    isHidden: Boolean = false,
    scale: Vector2 = new Vector2(1f, 1f),
    position: Vector3 = new Vector3(),
    var rotation: Double = 0.0
) extends Component {}
