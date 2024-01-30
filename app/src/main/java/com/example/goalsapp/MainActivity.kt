package com.example.goalsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.goalsapp.ui.theme.Cyan
import com.example.goalsapp.ui.theme.GoalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoalsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  MainApp()
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {

    val horizontalPadding = 16.dp

    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
//                    .height(40.dp)
                    .padding(horizontalPadding),
                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceAround
            ){
                IconButton(
                    onClick = {  },
                    modifier = Modifier.background(color = Cyan, shape = RoundedCornerShape(8.dp))
                )
                {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
                Text(
                    text = "Don't Give Up",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.face),
                    contentDescription = "",
                    Modifier
                        .heightIn(2.dp, 50.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                    )
            }
        },
        modifier = Modifier.fillMaxSize()
    ){ scaffoldPadding ->

        val scPadding = scaffoldPadding

        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = horizontalPadding,
                    vertical = scPadding.calculateTopPadding()
                )
        ){
//            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "2 Big Challenges", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "Ambitious person aren't you?", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))

            Row(Modifier.fillMaxWidth()) {
                BigButton(
                    icon = Icons.Default.Timer,
                    iconTint = Color(0xff45BAC5),
                    title = "Life Style",
                    subtitle = "Become a morning person",
                    reminder = "Every Day",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(8.dp))
                BigButton(
                    icon = Icons.Default.Favorite,
                    iconTint = Color(0xffFA6569),
                    title = "Healthy Life",
                    subtitle = "Because your health is the most important",
                    reminder = "Every Day",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Today's Planning", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "You have three actions to do", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                TaskItem(
                    icon = Icons.Outlined.Lightbulb,
                    title = "Learn new skill",
                    subtitle = "Complete programming course",
                    modifier = Modifier.clickable { })
                TaskItem(
                    icon = Icons.Outlined.WorkOutline,
                    title = "Create tutorial",
                    subtitle = "Create new YouTube tutorial",
                    modifier = Modifier.clickable { })
                TaskItem(
                    icon = Icons.Outlined.PlayArrow,
                    title = "Watch video",
                    subtitle = "Watch CodingArk new videos",
                    modifier = Modifier.clickable { })
            }
            Spacer(modifier = Modifier.height(16.dp))

        }

    }

}


@Composable
fun BigButton(
    icon: ImageVector,
    iconTint: Color,
    title: String,
    subtitle: String,
    reminder: String,
    modifier: Modifier = Modifier
    ){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Cyan,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(0.dp),

        modifier = modifier,
    ) {
        Column(Modifier.padding(16.dp)) {
            Icon(imageVector = icon, contentDescription = "Icon", tint = iconTint, modifier = Modifier.size(52.dp))
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Text(text = subtitle, fontWeight = FontWeight.Medium, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Reminder", fontWeight = FontWeight.Light, fontSize = 10.sp, color = Color.Gray)
            Text(text = reminder, fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
        }
    }

}

@Composable
fun TaskItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Cyan,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(0.dp),

    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
//                .wrapContentHeight()
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color(0x44073E64),
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Column(
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ){
                Text(text = title)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(
                onClick = {  },
                modifier = Modifier.align(Alignment.Top)
            ) {
                Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "More")
            }

        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoalsAppTheme {
       MainApp()
    }
}