package com.ghzel.expensis.ui.Composables.params.categories

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ghzel.domain.categories.dto.Category
import com.ghzel.domain.categories.dto.ContactModel
import com.ghzel.expensis.ui.Composables.params.categories.components.CategoryList
import com.ghzel.expensis.ui.Composables.params.categories.components.DialogCreateCategory
import com.ghzel.expensis.ui.Composables.params.categories.components.DialogDeleteCategory
import com.ghzel.expensis.ui.theme.AppMainTheme
import com.ghzel.expensis.ui.theme.DarkBlue
import com.ghzel.expensis.ui.theme.Permission
import com.ghzel.expensis.ui.theme.main_color
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@SuppressLint("Range")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Categories_Screen(navController: NavController) {
    val viewModel: CategoriesViewModel = hiltViewModel()
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    val dataState = viewModel.state.value

    var showDialog by remember { mutableStateOf(false) }
    var catgeoryToDelete by remember {
        mutableStateOf(
            Category(
                null,
                "",
                0,
                main_color.value.toLong(),
                ""
            )
        )
    }

    AppMainTheme(
        displayProgressBar = dataState.isLoading,
        scaffoldState = scaffoldState,
    ) {
        if (showDialog) {
            DialogCreateCategory(onDismiss = { showDialog = false }, onDelete = { /*TODO*/ }) {
            }
        }

        if (catgeoryToDelete.id != null) {
            DialogDeleteCategory(
                onDismiss = {
                    catgeoryToDelete = Category(null, "", 0, main_color.value.toLong(), "")
                },
                onDelete = { viewModel.deleteCategory(catgeoryToDelete) },
                category = catgeoryToDelete
            ) {
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(4.dp)) {
                CategoryList(
                    modifier = Modifier.fillMaxSize(),
                    sinistres = dataState.data,
                    onDeleteListener = {
                        catgeoryToDelete = it
                        //viewModel.deleteCategory(it)
                    },

                    onClickListener = {
                    }
                )
            }
            FloatingActionButton(
                onClick = {
                    showDialog = true
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                backgroundColor = DarkBlue
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }

    }
}