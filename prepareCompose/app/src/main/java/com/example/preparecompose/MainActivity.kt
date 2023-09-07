package com.example.preparecompose
import android.content.res.Configuration
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.preparecompose.ui.theme.PrepareComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

data class Message(val author: String, val body: String)

/*@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mdoe"
)
@Composable
fun PrevireMessgeCard(){
    PrepareComposeTheme {
        Surface{
            MessageCard(Message("Ban", "Hello, I'm Ban"))
        }
    }
}*/

@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit){
    val context = LocalContext.current
    val state = rememberScaffoldState()
    PrepareComposeTheme {
        Scaffold(
            scaffoldState = state,
            topBar = {
                TopAppBar(
                    title = { Text(text = "Title text") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                            },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        )
                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite"
                        )
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                )
            },
            drawerContent = {
                Icon(
                    modifier = Modifier.padding(14.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
                Text(modifier = Modifier.padding(14.dp), text = "Jun")
                Text(modifier = Modifier.padding(14.dp), text = "Kam")
                Text(modifier = Modifier.padding(14.dp), text = "NKS")
            },
        ) {
            content(it)
        }
    }
}

@Composable
fun MainContent(){
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Hello")
        
    }
}

@Preview
@Composable
fun MyAppPreview(){
    MyApp {it->
        Text(text = "Hello")
    }
}