package com.rishabh.nestedrecyclerview.dtos

data class ParentDTO(
    var title: String? = null,
    var description: String? = null,
    var children: List<ChildDTO>? = null,
)
