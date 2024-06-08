package com.example.menumasterapp.presentation.userinformations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.R
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.auth.component.CustomTextField
import com.example.menumasterapp.presentation.ui.theme.Typography
import com.example.menumasterapp.presentation.userinformations.component.CustomSelectionMenu

@Composable
fun UserInformationsScreen() {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = stringResource(R.string.title_user_info),
            modifier = Modifier.fillMaxWidth(1f),
            style = Typography.titleMedium,
        )
        Text(
            text = stringResource(R.string.description_user_info),
            style = Typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(1f),
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(text = "", onChangeText = {}, labelText = stringResource(R.string.age))
        CustomSelectionMenu(
            {},
            options = listOf(stringResource(R.string.female), stringResource(R.string.male)),
            labelText = stringResource(R.string.gender),
        )
        CustomTextField(text = "", onChangeText = {}, labelText = stringResource(R.string.height))
        CustomTextField(text = "", onChangeText = {}, labelText = stringResource(R.string.weight))
        CustomSelectionMenu(
            {},
            options = listOf(
                stringResource(R.string.oftenly_active),
                stringResource(R.string.sometimes_active),
                stringResource(R.string.not_active),
            ),
            labelText = stringResource(R.string.activity_state),
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(text = stringResource(R.string.to_continue), onButtonClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(4.dp))
        Row() {
            Text(stringResource(R.string.do_you_have_account))
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = stringResource(R.string.login), fontWeight = FontWeight.Bold)
        }

    }


}

@Preview(showBackground = true)
@Composable
private fun PrevLoginScreen() {
    UserInformationsScreen()
}