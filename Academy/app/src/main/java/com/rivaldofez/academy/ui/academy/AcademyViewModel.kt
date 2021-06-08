package com.rivaldofez.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rivaldofez.academy.data.source.local.entity.CourseEntity
import com.rivaldofez.academy.data.AcademyRepository
import com.rivaldofez.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<Resource<PagedList<CourseEntity>>> = academyRepository.getAllCourses()
}
