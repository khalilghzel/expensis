package com.ghzel.expensis.ui.Composables.params.categories.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ghzel.expensis.ui.theme.main_color
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ghzel.domain.categories.dto.Category
import com.ghzel.expensis.ui.theme.GreyColor
import com.ghzel.expensis.ui.theme.ubuntu


@Composable
fun DialogDeleteCategory(category : Category, onDismiss: () -> Unit, onDelete: (Category) -> Unit, onContinue: () -> Unit) {
    val context = LocalContext.current

    Dialog(
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = true, dismissOnClickOutside = true,
        )
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(8.dp)
                .wrapContentSize()

        ) {
            Column(
                modifier = Modifier.wrapContentSize().padding(20.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    text = "Are you sure !?",
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                )


                Text(
                    text = "By clicking delete the "+category.name+" will be deleted with his expenses",
                    modifier = Modifier,
                    color = GreyColor,
                    fontFamily = ubuntu,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )


                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        shape = RoundedCornerShape(5.dp),
                        onClick = {

                            onDismiss()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .weight(1f).wrapContentHeight(),
                        border = BorderStroke(1.dp, main_color),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.secondary),
                    ) {
                        Text(
                            text = "Cancel",
                            color = main_color,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }


                    Button(
                        shape = RoundedCornerShape(5.dp),
                        onClick = {
                            onDelete(category)
                            onDismiss()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(15.dp)
                            .wrapContentHeight(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = main_color),
                    ) {
                        Text(
                            text = "Delete",
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                }

            }
        }
    }
}
