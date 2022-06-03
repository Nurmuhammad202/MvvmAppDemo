package uz.personal.mvvmappdemo.simplemvvm.views.changecolor

import uz.personal.mvvmappdemo.simplemvvm.model.colors.NamedColor

/**
 * Represents list item for the color; it may be selected or not
 */
data class NamedColorListItem(
    val namedColor: NamedColor,
    val selected: Boolean
)