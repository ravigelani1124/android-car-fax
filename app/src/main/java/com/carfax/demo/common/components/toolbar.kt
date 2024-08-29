@file:OptIn(ExperimentalMaterial3Api::class)

package com.carfax.demo.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: String? = null,
    @DrawableRes navigationIcon: Int? = null,
    @DrawableRes actionIcon: Int? = null,
    onBackPressed: () -> Unit = {},
    onTapAction: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            title?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                }
            }
        }, navigationIcon = {
            navigationIcon?.let {
                Image(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { onBackPressed() },
                    painter = painterResource(id = navigationIcon),
                    contentDescription = null,
                )
            }
        }, actions = {
            actionIcon?.let {
                Image(
                    modifier = Modifier
                        .clickable { onTapAction() },
                    painter = painterResource(id = actionIcon),
                    contentDescription = null,
                )
            }
        })
}

@Preview
@Composable
fun MyToolbarPreview() {
    AppToolbar(
        title = "CarFax",
    )
}