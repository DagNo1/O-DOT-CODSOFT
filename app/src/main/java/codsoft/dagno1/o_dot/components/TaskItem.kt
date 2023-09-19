package codsoft.dagno1.o_dot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.ui.theme.Gray
import codsoft.dagno1.o_dot.ui.theme.BlueNcs1
import codsoft.dagno1.o_dot.ui.theme.Jasper
import codsoft.dagno1.o_dot.ui.theme.White
import codsoft.dagno1.o_dot.ui.theme.interFamily

@Composable
fun TaskItem(
    done: Boolean,
    title: String,
    dueDate: String,
    description: String
) {
    var isChecked by remember { mutableStateOf(done) }
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp,)
            .clip(RoundedCornerShape(10.dp))
            .background(BlueNcs1)
            .padding(10.dp)
    ){
        IconButton(
            onClick = {
                isChecked = !isChecked
            }, modifier = Modifier.size(45.dp)
        ) {
            Icon(
                painter = painterResource(id = if (isChecked) R.drawable.logo  else R.drawable.circle),
                contentDescription = "Back Icon",
                tint = Jasper
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Row (
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = title,
                    color = White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = interFamily,
                    modifier = Modifier.padding(start = 10.dp).weight(0.45f)
                )
                Text(
                    text = dueDate,
                    color = Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = interFamily,
                    modifier = Modifier.padding(start = 10.dp).weight(0.2f)
                )
            }
            Text(
                text = description,
                color = Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = interFamily,
                modifier = Modifier.padding(start = 10.dp)
            )

        }
    }
}