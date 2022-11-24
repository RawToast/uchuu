package com.github.rawtoast

import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object Main extends App:
    val config = Lwjgl3ApplicationConfiguration()
    Lwjgl3Application(Uchuu(), config)
