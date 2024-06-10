package com.example.menumasterapp.presentation.meals.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.menumasterapp.presentation.meals.Day

@Composable
fun CalendarSection(
    dayOfMonth: Int,
    dayList: List<Day>
) {
    var selectedDay by remember { mutableIntStateOf(dayOfMonth - 1) }
    val listState = rememberLazyListState()
    LaunchedEffect(key1 = Unit) {
        listState.animateScrollToItem(selectedDay, -listState.layoutInfo.viewportSize.width / 2)
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(dayList) {index, day ->
            CalendarContentItem(
                day = day.name,
                date = day.date,
                onItemClick = { selectedDay = index },
                isSelect = selectedDay == index
            )
        }
    }
}