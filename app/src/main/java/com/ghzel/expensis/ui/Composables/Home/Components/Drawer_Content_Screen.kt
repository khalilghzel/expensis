package com.ghzel.expensis.ui.Composables.Home.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.ghzel.expensis.R
import com.ghzel.expensis.ui.Composables.Home.HomeHolderViewModel
import com.ghzel.expensis.ui.routes.NAV_HOME_CATEGORIES
import com.ghzel.expensis.ui.theme.*

@Composable
fun Drawer_Content_Screen(
    onMenueClickListener: (String) -> Unit

) {

    val viewModel: HomeHolderViewModel = hiltViewModel()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painterResource(R.drawable.drawer_bg),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                DarkBlue_transparent,
                                main_color_transparent
                            )
                        )
                    )
            ) {
                Column( modifier = Modifier.fillMaxSize() ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberAsyncImagePainter("https://media.licdn.com/dms/image/C4E03AQFUYlwpg1EwvA/profile-displayphoto-shrink_800_800/0/1579876643789?e=1681344000&v=beta&t=PED7JYZq_Q4UrU7Lyxb4Vb4m2OA7o23fqg74TrgTx_o"),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, Color.White, CircleShape)   // add a border (optional)
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ghzel Khalil",
                        modifier = Modifier,
                        color = Color.White,
                        fontFamily = ubuntu,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "khalilghzel0@gmail.com",
                        modifier = Modifier,
                        color = GreyColor,
                        fontFamily = ubuntu,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )

                }
            }
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.ModeNight,
                contentDescription = "Night Mode",
                tint = main_color, modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.night_mode),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(4.dp))

            Switch(
                colors = SwitchDefaults.colors(
                    checkedThumbColor = DarkBlue_transparent,
                    uncheckedThumbColor = DarkBlue_transparent,
                    checkedTrackColor = main_color,
                    uncheckedTrackColor = GreySC2,
                ),
                checked = viewModel.nightMode.collectAsState(initial = false).value,
                onCheckedChange = { viewModel.updateNightMode(it) },
            )

        }
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clickable { onMenueClickListener(NAV_HOME_CATEGORIES) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.Category,
                contentDescription = "Night Mode",
                tint = main_color, modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(R.string.categories),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineMedium
            )

        }

    }
}