package com.github.rawtoast.component
 
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
 
final case class B2dBodyComponent(
    body: Body
) extends Component
