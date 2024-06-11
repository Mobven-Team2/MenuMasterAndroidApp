package com.example.menumasterapp.constant

enum class Genders(val displayName: String) {
    Kadın("Kadın"),
    Erkek("Erkek");
}

enum class ActivityStates(val displayName: String) {
    Hareketsiz("Hareketsiz"),
    HafifAktif("Hafif Aktif"),
    OrtaDereceAktif("Orta Derece Aktif"),
    ÇokAktif("Çok Aktif"),
    AşırıAktif("Aşırı Aktif");
}

fun Genders.toDisplayString(): String = displayName
fun ActivityStates.toDisplayString(): String = displayName
