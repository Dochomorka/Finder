package org.cursor.tech.finder

import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException


class UtilitiesUnitTest {

    @Test
    fun searchAnywhere_returnsNull_whenEmptyValueIsProvided(){
        //arrange
        val query: String = ""

        // act
        val result = Utilities.searchAnywhere(query)

        // assert
        Assert.assertEquals("give me a reason to work?",result)

    }


    @Test
    fun searchInbox_returnsInformation_whenEmptyValueIsProvided(){
        //arrange
        val query: String = ""

        // act
        val result = Utilities.searchInbox(query)

        // assert
        Assert.assertEquals("I see nothing is there! :(",result)

    }

    @Test
    fun searchInbox_returnTheExactValue_whenNonStringValueIsProvided(){
        val query = "null"

        val result = Utilities.searchInbox(query)

        Assert.assertEquals("null",result)
    }

}