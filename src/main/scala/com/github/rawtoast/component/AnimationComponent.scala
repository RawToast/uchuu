package com.github.rawtoast.component
 
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.IntMap;
 import com.badlogic.gdx.graphics.g2d.TextureRegion
 
final case class AnimationComponent(
    animations: IntMap[Animation[TextureRegion]]
) extends Component
