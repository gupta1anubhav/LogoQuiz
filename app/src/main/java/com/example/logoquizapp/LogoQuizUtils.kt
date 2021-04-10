package com.example.logoquizapp

import kotlin.random.Random

object LogoQuizUtils {

    fun getCharset(s: String): ArrayList<Char> {
        val list = ArrayList<Char>()
        val charset: String = "ABC....UVWXYZ"

        s.forEachIndexed { index, c ->
            list.add(c)
            charRemoveAt(charset, charset.indexOf(c))
        }
        //add all other random characters from remaining charset

        while (list.size < 20) {
            val c: Char = charset[Random.nextInt(charset.length)]
            if (!list.contains(c)) {
                list.add(c)
            }
        }

        //shuffle the list
        list.shuffle()

        return list
    }

    fun charRemoveAt(str: String, p: Int): String? {
        return str.substring(0, p) + str.substring(p + 1)
    }
}