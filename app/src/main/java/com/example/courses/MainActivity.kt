package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsApp(DataSource.topics, Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun TopicsApp(topicList: List<Topic>, modifier: Modifier = Modifier) {
    Row(){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
        ) {
            items(topicList) { topic ->
                TopicCard(
                    topic = topic,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }

    }
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Row(Modifier.width(220.dp).fillMaxHeight()){
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
            )
            Column(){
                Text(
                    text = stringResource(topic.stringResourceId),
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp, end = 16.dp, start = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(Modifier
                    .padding(start = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "grain lol"
                    )
                    Text(
                        text = topic.numOfCourses.toString(),
                        Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //val topic = Topic(R.string.photography, 321, R.drawable.photography)
    TopicCard(DataSource.topics[4])
}