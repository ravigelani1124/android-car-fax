package com.carfax.demo.common.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carfax.demo.R

@Composable
fun ErrorComponent(
    modifier: Modifier = Modifier,
    show: Boolean = false,
    @DrawableRes icon: Int? = null,
    @StringRes message: Int?,
    onRetry: () -> Unit,
) {
    if (show) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon?.let {
                Image(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(24.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    alignment = Alignment.TopCenter
                )
            }
            message?.let {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(id = message),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .size(36.dp)
                    .clickable(
                        onClick = onRetry
                    ),
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun ErrorComponentPreview() {
    ErrorComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        message = R.string.error_no_internet,
    ) {}
}