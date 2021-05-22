package com.rivaldofez.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.rivaldofez.academy.data.source.local.entity.CourseEntity
import com.rivaldofez.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()

}
