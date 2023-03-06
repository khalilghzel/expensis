package com.ghzel.expensis.ui.Composables.params.categories.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghzel.domain.categories.dto.Category
import com.ghzel.expensis.ui.theme.*


@Composable
fun CategoryCard(
    modifier: Modifier,
    category: Category,
    onDeleteClicked: () -> Unit,
    onClicked: () -> Unit,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {onClicked() },
        backgroundColor = MaterialTheme.colorScheme.secondary,
        elevation = 10.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,


            ) {

            Image(
                painterResource(category.icon),
                contentDescription = "Open", modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Text(
                    text = category.name,
                    modifier = Modifier,
                    color = GreyColor,
                    fontFamily = ubuntu,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                )

                Text(
                    text = category.description,
                    modifier = Modifier,
                    color = GreyColor,
                    fontFamily = ubuntu,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            }


            IconButton(
                modifier = Modifier
                    .size(35.dp)
                    .padding(5.dp),
                onClick = { onDeleteClicked() }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Open", tint = DarkBlue, modifier = Modifier.size(30.dp)
                )
            }


        }


    }
}


