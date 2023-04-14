package com.inblack67.springboot.rnd.utils

import org.springframework.http.HttpStatus

data class CustomExceptionModel(val message: String, val status: HttpStatus)