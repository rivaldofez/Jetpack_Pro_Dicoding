package com.rivaldofez.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.rivaldofez.academy.data.source.local.entity.CourseEntity
import com.rivaldofez.academy.data.source.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()

}