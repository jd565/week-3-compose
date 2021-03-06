/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFFFFFFFF),
    primaryVariant = Color(0xFFFFFFFF),
    secondary = Color(0xFFE1AFAF),
    secondaryVariant = Color(0xFFE1AFAF),
    background = Color(0xFF333333),
    surface = Color(0xFFFFFFFF).copy(alpha = 0.15f),
    error = Color(0xFFCF6679),
    onPrimary = Color(0xFF333333),
    onSecondary = Color(0xFF333333),
    onBackground = Color(0xFFF0EAE2),
    onSurface = Color.White.copy(alpha = 0.80f),
    onError = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF333333),
    primaryVariant = Color(0xFF33333),
    secondary = Color(0xFF886363),
    secondaryVariant = Color(0xFF886363),
    background = Color(0xFFF0EAE2),
    surface = Color.White.copy(alpha = 0.85f),
    error = Color(0xFFB00020),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF655454),
    onSurface = Color(0xFF333333).copy(alpha = 0.8f),
    onError = Color.White
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Composable
fun PreviewTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = previewTypography,
        shapes = shapes,
        content = content
    )
}
