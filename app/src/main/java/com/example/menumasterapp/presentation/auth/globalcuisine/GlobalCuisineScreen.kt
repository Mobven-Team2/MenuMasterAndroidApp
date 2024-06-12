package com.example.menumasterapp.presentation.auth.globalcuisine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.auth.globalcuisine.component.CustomCardTag
import com.example.menumasterapp.presentation.auth.register.RegisterViewModel
import com.example.menumasterapp.presentation.ui.theme.Typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GlobalCuisineScreen(
    viewModel: RegisterViewModel,
    onNavigate: () -> Unit
) {

    var selectedCuisines by remember { mutableStateOf(setOf<String>()) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxHeight(1f)
    ) {
        Column {
            Text(
                stringResource(id = R.string.title_global_cuisine),
                modifier = Modifier.fillMaxWidth(1f),
                style = Typography.titleMedium,
            )
            Text(
                stringResource(id = R.string.description_global_cuisine),
                style = Typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(1f),
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
        FlowRow(

            horizontalArrangement =Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val cuisineTitles = listOf(
                stringResource(id = R.string.turkish),
                stringResource(id = R.string.mexican),
                stringResource(id = R.string.mediterrian),
                stringResource(id = R.string.greek),
                stringResource(id = R.string.italian),
                stringResource(id = R.string.japanese),
                stringResource(id = R.string.thailand),
                stringResource(id = R.string.vietnamese),
                stringResource(id = R.string.indian),
                stringResource(id = R.string.korean),
                stringResource(id = R.string.american),
                stringResource(id = R.string.french)
            )

            cuisineTitles.forEach { title ->
                CustomCardTag(
                    title = title,
                    isSelected = selectedCuisines.contains(title),
                    onSelectionChanged = { cuisine, isSelected ->
                        selectedCuisines = if (isSelected) {
                            selectedCuisines + cuisine
                        } else {
                            selectedCuisines - cuisine
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        CustomButton(
            text = stringResource(id = R.string.to_continue),
            onButtonClick = {
                viewModel.applyCuisineNames(selectedCuisines.toList())
                onNavigate()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable

fun previewGlobalCuisine() {
    // GlobalCuisineScreen()
}