package com.inblack67.springboot.rnd.controllers

import com.inblack67.springboot.rnd.dtos.Course
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController {
    @RequestMapping("/courses")
    fun getCourses(): List<Course> {
        return listOf(
            Course(id = 1, name = "Elixir", author = "Erlang"),
            Course(id = 2, name = "Rust", author = "Actix"),
        )
    }
}