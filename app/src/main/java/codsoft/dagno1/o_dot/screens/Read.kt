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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.components.TaskItem
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.interFamily

@Composable
fun Read() {
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
            TaskItem(
                done = false,
                title = "Do Laundry",
                dueDate = "09/18/2002",
                description = "Just pick it up and do it"
            )
            TaskItem(
                done = true,
                title = "Do Laundry",
                dueDate = "09/18/2002",
                description = "Just pick it up and do it"
            )
            TaskItem(
                done = false,
                title = "Do Laundry",
                dueDate = "09/18/2002",
                description = "Just pick it up and do it"
            )
        }
    }
}
