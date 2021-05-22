package com.rivaldofez.academy.ui.bookmark

import com.rivaldofez.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
