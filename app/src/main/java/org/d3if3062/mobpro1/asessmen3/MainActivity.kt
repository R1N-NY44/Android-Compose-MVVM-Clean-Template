package org.d3if3062.mobpro1.asessmen3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3062.mobpro1.asessmen3.system.database.model.User
import org.d3if3062.mobpro1.asessmen3.system.navigation.NavigationGraph
import org.d3if3062.mobpro1.asessmen3.system.network.UserDataStore
import org.d3if3062.mobpro1.asessmen3.system.network.signIn
import org.d3if3062.mobpro1.asessmen3.system.network.signOut
import org.d3if3062.mobpro1.asessmen3.system.utils.SettingsDataStore
import org.d3if3062.mobpro1.asessmen3.ui.theme.MobproAsessmen3Theme
import org.d3if3062.mobpro1.asessmen3.ui.widgets.ProfilDialog
import org.d3if3062.mobpro1.asessmen3.ui.widgets.TopAppBarWidget

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseApp()
        }
    }
}

@Composable
fun BaseApp(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) {
    val dataStore = SettingsDataStore(context)
    val userStore = UserDataStore(context)
    val appTheme by dataStore.layoutFlow.collectAsState(true)
    var showDialog by remember { mutableStateOf(false) }
    val user by userStore.userFlow.collectAsState(User())
    MobproAsessmen3Theme(darkTheme = appTheme) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            topBar = {
                TopAppBarWidget(
                    title = stringResource(id = R.string.app_name),
                    appTheme = appTheme,
                    showDialog = showDialog,
                    onShowDialogChange = { showDialog = it },
                    onAppThemeChange = { newTheme ->
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStore.saveLayout(!appTheme)
                        }
                    }
                )
            },
            bottomBar = {
                //BottomBarWidget(navController)
            }
        ) { padding ->
            Modifier.padding(padding)
            NavigationGraph(navController)

            // LaunchedEffect to handle sign-in if needed
            LaunchedEffect(showDialog) {
                if (showDialog && user.email.isEmpty()) {
                    CoroutineScope(Dispatchers.IO).launch {
                        signIn(context, userStore)
                    }
                }
            }

            // Display the dialog if showDialog is true
            if (showDialog && user.email.isNotEmpty()) {
                ProfilDialog(user = user, onDismissRequest = { showDialog = false }) {
                    CoroutineScope(Dispatchers.IO).launch {
                        signOut(context, userStore)
                    }
                    showDialog = false
                }
            }
        }
    }
}

fun gate(): Unit {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobproAsessmen3Theme {
        BaseApp()
    }
}