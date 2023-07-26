package com.example.network

import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.mockito.MockitoAnnotations

abstract class BaseTest {

    open val language = "pt-br"
    open val page = 1

    @Before
    open fun setup() {
        MockitoAnnotations.openMocks(this)
        initialize()
    }

    @After
    fun shutdown() {
        unmockkAll()
        finish()
    }

    open fun initialize() {}

    open fun finish() {}

    protected val genericErrorResponse =
        Exception(Throwable("Error response"))
}