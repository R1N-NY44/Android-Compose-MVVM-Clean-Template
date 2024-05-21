package R1N.NY44.mvvm

import R1N.NY44.mvvm.system.navigation.NavigationRoot
import R1N.NY44.mvvm.system.utils.SettingsDataStore
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import R1N.NY44.mvvm.ui.theme.MVVMByR1NNY44Theme
import R1N.NY44.mvvm.ui.widgets.BottomBarWidget
import R1N.NY44.mvvm.ui.widgets.TopAppBarWidget
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseApp()
        }
    }
}
@Composable
fun BaseApp(navController: NavHostController = rememberNavController()) {
    val dataStore = SettingsDataStore(LocalContext.current)
    val appTheme by dataStore.layoutFlow.collectAsState(true)
    MVVMByR1NNY44Theme(darkTheme = appTheme) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            topBar = {
                TopAppBarWidget(stringResource(id = R.string.app_name))
            },
            bottomBar = {
                BottomBarWidget(navController)
            }
        ) { padding ->
            Modifier.padding(padding)
            NavigationRoot(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMByR1NNY44Theme {
        BaseApp()
    }
}