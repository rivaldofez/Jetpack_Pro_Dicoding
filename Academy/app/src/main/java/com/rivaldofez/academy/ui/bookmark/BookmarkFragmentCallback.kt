package com.rivaldofez.academy.ui.bookmark

import com.rivaldofez.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
