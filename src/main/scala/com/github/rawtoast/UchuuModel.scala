package com.github.rawtoast

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.CircleShape
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.World

final case class UchuuModel():
  // Could inject
  lazy val world = World(Vector2(0, -10f), true)
  createFloor()
  createObject()
  createMovingObject()

  def logicStep(delta: Float): Unit =
    world.step(delta, 3, 3)

  private def createObject(): Unit =
    val bodyDef = BodyDef()
    bodyDef.`type` = BodyDef.BodyType.DynamicBody
    bodyDef.position.set(0, 0)

    // add the body to the world
    val body = world.createBody(bodyDef)

    // set the shape of the body
    val shape = PolygonShape()
    shape.setAsBox(1, 1)

    body.createFixture(shape, 0.0f)
    shape.dispose()

  private def createFloor(): Unit =
    val bodyDef = BodyDef()
    bodyDef.`type` = BodyDef.BodyType.StaticBody
    bodyDef.position.set(0, -10)

    // add the body to the world
    val body = world.createBody(bodyDef)

    // set the shape of the body
    val shape = PolygonShape()
    shape.setAsBox(50, 10)

    body.createFixture(shape, 0.0f)
    shape.dispose()

  private def createMovingObject(): Unit =
    val bodyDef = BodyDef()
    bodyDef.`type` = BodyDef.BodyType.KinematicBody
    bodyDef.position.set(0, -12)

    // add the body to the world
    val body = world.createBody(bodyDef)

    // set the shape of the body
    val shape = PolygonShape()
    shape.setAsBox(1f, 1f)

    body.createFixture(shape, 0.0f)
    shape.dispose()

    body.setLinearVelocity(0, 0.75f)
