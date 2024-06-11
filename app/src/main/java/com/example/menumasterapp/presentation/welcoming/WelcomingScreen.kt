package com.example.menumasterapp.presentation.welcoming

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.menumasterapp.R
import com.example.menumasterapp.constant.PreviewMuviScreenSizes
import com.example.menumasterapp.presentation.auth.component.CustomButton
import com.example.menumasterapp.presentation.ui.theme.LightPrimary
import com.example.menumasterapp.presentation.ui.theme.Primary
import com.example.menumasterapp.presentation.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomingScreen() {

    val images =
        listOf(R.drawable.first_onboard, R.drawable.second_onboard, R.drawable.third_onboard)
    val titles = listOf(stringResource(id = R.string.title_first_welcoming), stringResource(id = R.string.title_second_welcoming), stringResource(id = R.string.title_third_welcoming))
    val descriptions = listOf(
        stringResource(id = R.string.description_first_welcoming),
        stringResource(id = R.string.description_second_welcoming),
        stringResource(id = R.string.description_third_welcoming),
    )

    val pagerState = rememberPagerState(pageCount = {
        images.size
    })
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically,

            state = pagerState,
            key = { images[it] },
            pageContent = ({ index ->
                Column(
                    modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .height(435.dp)
                            .fillMaxWidth(),
                        painter = painterResource(id = images[index]),
                        contentDescription = "",

                        )
                    Text(
                        modifier = Modifier.padding(12.dp, 8.dp),
                        textAlign = TextAlign.Center,
                        text = titles[index],
                        style = Typography.titleMedium
                    )

                    Text(
                        modifier = Modifier.padding(12.dp, 8.dp),
                        textAlign = TextAlign.Center,
                        text = descriptions[index],
                        style = Typography.bodyMedium
                    )
                }

            })
        )
        Row(modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.Center) {
            Text(
                text = ".",
                fontSize = 64.sp,
                color = if (pagerState.currentPage == 0) Primary else LightPrimary,
                fontWeight = if (pagerState.currentPage == 0) FontWeight.Bold else FontWeight.Normal
            )
            Text(
                text = ".",
                fontSize = 64.sp,
                color = if (pagerState.currentPage == 1) Primary else LightPrimary,
                fontWeight = if (pagerState.currentPage == 1) FontWeight.Bold else FontWeight.Normal
            )
            Text(
                text = ".",
                fontSize = 64.sp,
                color = if (pagerState.currentPage == 2) Primary else LightPrimary,
                fontWeight = if (pagerState.currentPage == 2) FontWeight.Bold else FontWeight.Normal
            )


        }
        Box(modifier = Modifier.padding(16.dp, 12.dp)) {
            CustomButton(text = stringResource(id = R.string.login), onButtonClick = { /*TODO*/ })

        }
        Text(text = stringResource(id = R.string.skip))
    }

}

//@PreviewMuviScreenSizes
@Preview (showBackground = true)
@Composable
fun PreviewWelcoming() {
    WelcomingScreen()
}