package com.github.rawtoast

import com.badlogic.gdx.Game

import com.github.rawtoast.view.EndScreen
import com.github.rawtoast.view.LoadingScreen
import com.github.rawtoast.view.MainScreen
import com.github.rawtoast.view.MenuScreen
import com.github.rawtoast.view.PreferencesScreen

final case class Uchuu() extends Game:
  import Uchuu.Screen._

  // Tempted to pass these in as constructor parameters
  lazy val loadingScreen = LoadingScreen(this)
  lazy val preferences = AppPreferences()

  lazy val mainScreen = MainScreen(this)
  lazy val menuScreen = MenuScreen(this)
  lazy val preferencesScreen = PreferencesScreen(this)
  lazy val endGameScreen = EndScreen(this)

  override def create(): Unit =
    setScreen(menuScreen)

  def changeScreen(screen: Uchuu.Screen): Unit =
    screen match
      case MENU        => setScreen(menuScreen)
      case PREFERENCES => setScreen(preferencesScreen)
      case APPLICATION => setScreen(mainScreen)
      case ENDGAME     => setScreen(endGameScreen)
      case LOADING     => setScreen(loadingScreen)

object Uchuu:
  enum Screen:
    case MENU
    case PREFERENCES
    case APPLICATION
    case ENDGAME
    case LOADING
