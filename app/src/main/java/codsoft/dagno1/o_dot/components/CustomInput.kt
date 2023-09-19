package codsoft.dagno1.o_dot.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import codsoft.dagno1.o_dot.ui.theme.AliceBlue
import codsoft.dagno1.o_dot.ui.theme.Coral

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = label) },
        leadingIcon = { Icon(
            imageVector = leadingIcon,
            contentDescription = null,
            tint = Coral
        ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = AliceBlue),
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done // Use Done or Next as needed
        ),
    )

}
