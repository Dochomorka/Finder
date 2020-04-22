package org.cursor.tech.finder

import android.text.TextUtils
import java.lang.IllegalArgumentException
import java.time.temporal.TemporalQuery


class Utilities{
    companion object{
        fun searchAnywhere(str: String = ""):String{
            if (str.isEmpty()) return "give me a reason to work?"
        return str
        }

        fun searchInbox(query: String=""): String{
            if(query.isEmpty()) return "I see nothing is there! :("
            return query;
        }
    }
}
//fun searchAnyWhere(str: String = ""): String?{
//
//}