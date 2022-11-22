package com.github.rawtoast.component

import com.badlogic.ashley.core.Component

import com.badlogic.gdx.graphics.g2d.TextureRegion

final case class TextureComponent(
    var region: TextureRegion
) extends Component
