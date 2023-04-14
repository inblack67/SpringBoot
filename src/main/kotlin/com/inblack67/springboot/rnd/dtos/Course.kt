package com.inblack67.springboot.rnd.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class Course(
    val id: Int,
    @field:NotEmpty(message = "cannot be empty")
    @field:Size(min = 2, message = "min 2 chars")
    val name: String,
    val author: String
)