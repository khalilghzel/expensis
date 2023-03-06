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


@Composable
fun DialogCreateCategory(onDismiss: () -> Unit, onDelete: () -> Unit, onContinue: () -> Unit) {
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
                    text = "Create new Category",
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        shape = RoundedCornerShape(5.dp),
                        onClick = {
                            onContinue()
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
                            text = "Save",
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
