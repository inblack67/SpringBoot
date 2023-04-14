package com.inblack67.springboot.rnd.exceptions

class CustomException(val customCode: Int, message: String): Exception(message) {
}