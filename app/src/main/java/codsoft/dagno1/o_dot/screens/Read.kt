package codsoft.dagno1.o_dot.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.components.TaskCard
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.interFamily
import codsoft.dagno1.quotelytics.data.DBHelper

@Composable
fun Read(navController: NavController) {
    val context = LocalContext.current
    val dbHelper = DBHelper(context, null)

    val currentTasks = dbHelper.getAllUnfinishedTasks()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.o_dot),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Task List",
                color = BlueNcs,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = interFamily,
                modifier = Modifier.padding(start = 10.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(bottom = 50.dp)
            ) {
                items(currentTasks.size) { i ->
                    TaskCard(currentTasks[i], navController = navController)
                }
            }
        }
    }
}
