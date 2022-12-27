package com.example.galadarbs

class Calculator {
    fun calculateCharFrequency(charSequence: CharSequence) : List<String> {
        return mapToArray(mapChars(charSequence),charSequence.length)
    }

    private fun mapToArray(list :MutableMap<Char,Int>, count : Int) : List<String> {

        val array = mutableListOf<String>()

        for( item in list) {
            val percent = getPercent(item.value,count)
            val text = item.key + " - " + percent + "%"
            array.add(text)
        }

        return array;
    }

    private fun getPercent(value :Int, count :Int) :Float {
        val percentageValue = value.toFloat() * 100 / count
        return round(percentageValue,2)
    }

    private fun mapChars(string: CharSequence) :MutableMap<Char,Int> {
        val chars = StringBuilder(string)

        val map: MutableMap<Char, Int> = HashMap()

        for (i in chars.indices) {
            var count = 0

            if(map.containsKey(chars[i])) {
                count = map[chars[i]]!!
            }

            count += 1

            map[chars[i]] = count
        }

        return map
    }

    private fun round(value : Float, digits : Int): Float
    {
        return String.format("%."+digits+"f",value).toFloat()
    }
}

