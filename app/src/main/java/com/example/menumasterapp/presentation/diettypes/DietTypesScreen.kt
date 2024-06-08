package com.example.menumasterapp.presentation.diettypes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.diettypes.component.CustomDietTypeRadioButton
import com.example.menumasterapp.presentation.ui.theme.Typography

@Composable

fun DietTypesScreen() {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
        ) {
            Text(
                stringResource(id = R.string.title_diet_types_screen),
                modifier = Modifier.fillMaxWidth(1f),
                style = Typography.titleMedium,
            )
            Text(
                stringResource(id = R.string.description_diet_types_screen),
                modifier = Modifier.fillMaxWidth(1f),
                style = Typography.bodyMedium,
            )
        }

        CustomDietTypeRadioButton(
            drawable = R.drawable.vegan,
            title = stringResource(id = R.string.vegan),
            description = stringResource(id = R.string.description_vegan)
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.vegeterian,
            title = stringResource(id = R.string.vegeterian),
            description = stringResource(id = R.string.description_vegeterian)
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.ketogenic,
            title = stringResource(id = R.string.ketogenic),
            description = stringResource(id = R.string.description_ketogenic)
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.paleo,
            title = stringResource(id = R.string.paleo),
            description = stringResource(id = R.string.description_paleo)
        )
        CustomDietTypeRadioButton(
            drawable = R.drawable.nodiet,
            title = stringResource(id = R.string.no_diet),
            description = ""
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(text = stringResource(id = R.string.to_continue), onButtonClick = { /*TODO*/ })
    }


}

@Preview
@Composable
fun preview(
) {
    DietTypesScreen()
}