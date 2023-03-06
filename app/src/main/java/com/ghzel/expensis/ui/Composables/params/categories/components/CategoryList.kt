package com.ghzel.expensis.ui.Composables.params.categories.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ghzel.domain.categories.dto.Category

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryList(
    modifier: Modifier,
    sinistres: List<Category>,
    onClickListener: (Category) -> Unit,
    onDeleteListener: (Category) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        LazyColumn() {
            items(items = sinistres, key = { it.id!! }) { item ->
                CategoryCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(),
                    category = item,
                    onClicked = { onClickListener(item) },
                    onDeleteClicked = { onDeleteListener(item) }
                )
            }
        }
    }
}







