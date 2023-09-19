package codsoft.dagno1.o_dot.screens

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.components.CustomInput
import codsoft.dagno1.o_dot.data.Task
import codsoft.dagno1.o_dot.ui.theme.Gray
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.BlueNcs1
import codsoft.dagno1.o_dot.ui.theme.Jasper
import codsoft.dagno1.o_dot.ui.theme.interFamily
import codsoft.dagno1.quotelytics.data.DBHelper
import java.util.Calendar
import java.util.Date

@SuppressLint("SimpleDateFormat", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavController) {
    var taskName by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


    val context = LocalContext.current
    val dbHelper = DBHelper(context, null)

    Scaffold(
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BlueNcs1)
                        .padding(vertical = 5.dp, horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }, modifier = Modifier.size(45.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back Icon",
                            tint = Jasper
                        )
                    }
                    Text(
                        text = "New Task",
                        color = Gray,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = interFamily,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomInput(
                        value = taskName,
                        onValueChange = { taskName = it },
                        label = "Task Name",
                        leadingIcon = Icons.Default.Create,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomInput(
                        value = taskDescription,
                        onValueChange = { taskDescription = it },
                        label = "Task Description",
                        leadingIcon = Icons.Default.Info,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                mDatePickerDialog.show()
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Due Date: ${mDate.value}",
                            color = BlueNcs,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = interFamily,
                            modifier = Modifier.padding(top = 10.dp).weight(0.4f)
                        )
                        Spacer(modifier = Modifier.width(100.dp).weight(0.1f))
                        IconButton(
                            onClick = {
                                mDatePickerDialog.show()
                            }, modifier = Modifier.width(50.dp).height(50.dp).weight(0.1f)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.calander),
                                contentDescription = "Back Icon",
                                tint = Jasper
                            )
                        }
                    }

                }

            }
        },
        floatingActionButton = {
            IconButton(
                onClick = {
                    dbHelper.addTask(
                        Task(
                            id= -1,
                            title = taskName,
                            description = taskDescription,
                            dudDate = mDate.value,
                            isChecked = false
                        )
                    )
                }, modifier = Modifier.size(100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = "Back Icon",
                    tint = Jasper
                )
            }
        }
    )
}