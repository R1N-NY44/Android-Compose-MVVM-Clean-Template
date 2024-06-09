package org.d3if3062.mobpro1.asessmen3.ui.widgets

import android.app.Activity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.d3if3062.mobpro1.asessmen3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(
    title: String,
    appTheme: Boolean,
    showDialog: Boolean,
    onShowDialogChange: (Boolean) -> Unit,
    onAppThemeChange: (Boolean) -> Unit
) {
    val act = LocalContext.current as Activity
    CenterAlignedTopAppBar(
        title = {
            Text(title, style = MaterialTheme.typography.titleMedium)
        },
        navigationIcon = {
            IconButton(onClick = { onAppThemeChange(!appTheme) }) {
                Icon(
                    painter = if (appTheme) painterResource(id = R.drawable.dark_mode) else painterResource(
                        id = R.drawable.light_mode
                    ),
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(
                onClick = { onShowDialogChange(!showDialog) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_circle),
                    contentDescription = "Profil"
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
    )
}