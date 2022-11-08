package com.github.rawtoast.component
 
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.IntMap;
 
final case class AnimationComponent(
    animations: IntMap[Animation[_]]
) extends Component
