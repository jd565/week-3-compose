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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(logInClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        MyIcon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.dark_login else R.drawable.light_login),
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(text = "Email address", style = MaterialTheme.typography.body1)
                }
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(text = "Password", style = MaterialTheme.typography.body1)
                }
            )
            Button(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .fillMaxWidth()
                    .height(72.dp),
                onClick = { logInClick() },
            ) {
                Text(text = "LOG IN")
            }
            Row {
                Text(
                    text = "Don't have an account? ",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
                Text(
                    text = "Sign up",
                    style = MaterialTheme.typography.body1,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
            }
        }
    }
}
