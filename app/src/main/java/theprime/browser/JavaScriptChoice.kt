/*
 * Copyright © 2020-2021 Jamal Rothfuchs
 * Copyright © 2020-2021 Stéphane Lenclud
 * Copyright © 2015 Anthony Restaino
 */

package theprime.browser

import theprime.settings.preferences.IntEnum

/**
 * The available Block JavaScript choices.
 */
enum class JavaScriptChoice(override val value: Int) :
    IntEnum {
    NONE(0),
    WHITELIST(1),
    BLACKLIST(2)
}
