package com.rivaldofez.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.rivaldofez.academy.data.CourseEntity
import com.rivaldofez.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}
