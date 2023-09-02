package com.example.preparecompose
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.preparecompose.ui.theme.PrepareComposeTheme
import com.example.preparecompose.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreenContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyApp {
        MyScreenContent()
    }
}

@Composable
fun Greeting(name: String){

    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}


@Composable
fun MyApp(content: @Composable () -> Unit){
    PrepareComposeTheme() {
        Surface(color = Purple80) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(100){"안드로이드 #$it"}){
    val counterState = remember{ mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()){
        NameList(names = names, Modifier.weight(1f))
        Counter(
            count = counterState.value,
            updateCount = {newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit){
    Button(
        onClick = {updateCount(count+1)},
        colors = ButtonDefaults.buttonColors(
            if(count > 5) Color.Black else Color.Blue
        )
    ){
        Text("$count 번 클릭하셨네요!")
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(items = names){name->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

