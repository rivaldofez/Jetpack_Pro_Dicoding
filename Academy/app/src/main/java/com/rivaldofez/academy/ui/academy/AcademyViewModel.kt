package com.rivaldofez.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.rivaldofez.academy.data.CourseEntity
import com.rivaldofez.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}