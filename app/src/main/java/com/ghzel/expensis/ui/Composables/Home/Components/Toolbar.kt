package com.ghzel.expensis.ui.Composables.Home.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ghzel.expensis.R
import com.ghzel.expensis.ui.theme.AppMainTheme
import com.ghzel.expensis.ui.theme.DarkBlue
import com.ghzel.expensis.ui.theme.main_color
import com.ghzel.expensis.ui.theme.ubuntu

@Composable
fun Toolbar(
    navController: NavController,
    onMenueClickListener: () -> Unit

) {

    Surface(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp),
        elevation = 4.dp,
        color = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        modifier = Modifier.size(35.dp),
                        onClick = { onMenueClickListener() }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.menue_icon),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(DarkBlue),
                            modifier = Modifier
                                .size(20.dp)

                        )
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "Ghzel Khalil",
                        modifier = Modifier,
                        color = DarkBlue,
                        fontFamily = ubuntu,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
                IconButton(
                    modifier = Modifier.size(35.dp),
                    onClick = { navController.navigateUp() }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_notif),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(main_color),
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }


        }
    }

}
