class WebPage {
}

fun main() {

    val icelandicMap = mapOf(
        'á' to 'a', 'ð' to 'd', 'é' to 'e', 'í' to 'i', 'ó' to 'o',
        'ú' to 'u', 'ý' to 'y', 'þ' to "th", 'æ' to "ae", 'ö' to 'o',
        'Á' to 'A', 'Ð' to 'D', 'É' to 'E', 'Í' to 'I', 'Ó' to 'O',
        'Ú' to 'U', 'Ý' to 'Y', 'Þ' to "Th", 'Æ' to "Ae", 'Ö' to 'O'
    )

    val name = readLine()!!
    val latin = name.map { icelandicMap[it] ?: it }.joinToString("")
    val onlyLettersAndDigits = latin.replace(Regex("[^A-Za-z0-9]"), "")
    val webpage = "${onlyLettersAndDigits.lowercase()}.is"
    println(webpage)
}