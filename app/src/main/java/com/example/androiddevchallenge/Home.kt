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
package com.example.androiddevchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.ui.theme.PreviewTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Home(bottomPadding: Dp) {
    var search by remember { mutableStateOf("") }
    LazyColumn(
        contentPadding = PaddingValues(bottom = bottomPadding),
        content = {
            item("search") {
                TextField(
                    value = search, onValueChange = { search = it },
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 56.dp
                        )
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            modifier = Modifier.size(18.dp),
                            contentDescription = null
                        )
                    },
                    placeholder = {
                        Text(text = "Search", style = MaterialTheme.typography.body1)
                    },
                    textStyle = MaterialTheme.typography.body1
                )
            }
            item("collections title") {
                Text(
                    text = "FAVORITE COLLECTIONS",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                        .padding(start = 16.dp)
                )
            }
            item("collections") {
                Collections()
            }
            item("align title") {
                Text(
                    text = "ALIGN YOUR BODY",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                        .padding(start = 16.dp)
                )
            }
            item("body") {
                Circles(bodies)
            }
            item("mind title") {
                Text(
                    text = "ALIGN YOUR MIND",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                        .padding(start = 16.dp)
                )
            }
            item("mind") {
                Circles(minds)
            }
        }
    )
}

@Composable
fun Circles(items: List<Align>) {
    LazyRow(
        contentPadding = PaddingValues(start = 8.dp, end = 16.dp)
    ) {
        items.forEach {
            item(it.title) {
                Column(
                    modifier = Modifier.padding(start = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage(
                        data = it.image, modifier = Modifier.size(88.dp),
                        contentDescription = null,
                        requestBuilder = { transformations(CircleCropTransformation()) }
                    )
                    Text(
                        text = it.title,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}

private val bodies = listOf(
    Align(
        "Inversions",
        "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "Quick yoga",
        "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "Stretching",
        "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "Tabata",
        "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "HIIT",
        "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "Pre-natal yoga",
        "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
)

private val minds = listOf(
    Align(
        "Meditate",
        "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "With kids",
        "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "Aromatherapy",
        "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "On the go",
        "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "With pets",
        "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Align(
        "High stress",
        "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
)

data class Align(
    val title: String,
    val image: String,
)

data class C(
    val title: String,
    val image: String,
)

private val collections = listOf(
    Pair(
        C("Short mantras", ""),
        C(
            "Nature meditations",
            "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
        )
    ),
    Pair(
        C(
            "Stress and anxiety",
            "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        C(
            "Self-massage",
            "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        )
    ),
    Pair(
        C(
            "Overwhelmed",
            "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        C(
            "Nightly wind down",
            "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        )
    ),
)

@Composable
fun Collections() {
    LazyRow(
        contentPadding = PaddingValues(start = 8.dp, end = 16.dp),
        content = {
            collections.forEach { item(it.first.title) { Collection(it) } }
        }
    )
}

@Composable
fun Collection(items: Pair<C, C>) {
    Column(
        modifier = Modifier.padding(
            start = 8.dp,
            bottom = 8.dp
        )
    ) {
        Card(
            modifier = Modifier.size(width = 192.dp, height = 56.dp),
            shape = MaterialTheme.shapes.small,
        ) {
            Row(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.surface), verticalAlignment = Alignment.CenterVertically) {
                CoilImage(
                    contentScale = ContentScale.Crop,
                    data = items.first.image,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
                Text(
                    text = items.first.title,
                    modifier = Modifier
                        .padding(start = 16.dp),
                    style = MaterialTheme.typography.h3
                )
            }
        }

        Card(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(width = 192.dp, height = 56.dp),
            shape = MaterialTheme.shapes.small,
        ) {
            Row(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.surface), verticalAlignment = Alignment.CenterVertically) {
                CoilImage(
                    contentScale = ContentScale.Crop,
                    data = items.second.image,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
                Text(
                    text = items.second.title,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightHomePreview() {
    PreviewTheme {
        Scaffold {
            Home(0.dp)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkHomePreview() {
    PreviewTheme(darkTheme = true) {
        Scaffold {
            Home(0.dp)
        }
    }
}
