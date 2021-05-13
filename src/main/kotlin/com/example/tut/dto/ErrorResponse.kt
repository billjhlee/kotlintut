package com.example.tut.dto

import java.time.LocalDateTime

class ErrorResponse(val title: String = "Bad Request", val message: String, val dateTime: LocalDateTime = LocalDateTime.now())