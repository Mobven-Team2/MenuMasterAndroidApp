package com.example.menumasterapp.presentation.shopping_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.menumasterapp.data.local.ShoppingListDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingListDao: ShoppingListDao
): ViewModel() {

    private val _shoppingListState = MutableStateFlow<List<String>>(listOf())
    val shoppingListState : StateFlow<List<String>> get() = _shoppingListState

    init {
        getShoppingItemsByCategory("Breakfast")
    }

    fun getShoppingItemsByCategory(category: String) = viewModelScope.launch {
        _shoppingListState.value = shoppingListDao.getShoppingItemsByCategory(category).map { it.name }
    }

}