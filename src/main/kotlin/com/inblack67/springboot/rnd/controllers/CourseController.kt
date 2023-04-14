package com.inblack67.springboot.rnd.controllers

import com.inblack67.springboot.rnd.dtos.Course
import com.inblack67.springboot.rnd.exceptions.CustomException
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController {
    private val courses = mutableListOf(
        Course(id = 0, name = "Elixir", author = "Erlang"),
        Course(id = 1, name = "Rust", author = "Actix"),
    )

    @RequestMapping(method = [RequestMethod.GET], path = ["/courses"])
    fun getCourses(): List<Course> {
//        throw CustomException(2, "oops")
        return courses
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/courses/{id}"])
    fun getCourse(@PathVariable id: Int): Course? {
        return courses.find { it.id == id }
    }

    @PostMapping("/courses")
    fun createCourse(@Valid @RequestBody course: Course): Boolean {
        courses.add(course)
        return true
    }

    // headers = ["X-API-Version=2"]
    @GetMapping("/courses/v2", params = ["version=2"])
    fun getCoursesV2(): List<Course> {
        return emptyList()
    }
}