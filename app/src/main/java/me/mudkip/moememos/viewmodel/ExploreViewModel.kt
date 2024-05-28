package me.mudkip.moememos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.mudkip.moememos.data.datasource.EXPLORE_PAGE_SIZE
import me.mudkip.moememos.data.datasource.ExplorePagingSource
import me.mudkip.moememos.data.repository.MemosV0Repository
import javax.inject.Inject


@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val memoRepository: MemosV0Repository
) : ViewModel() {
    val exploreMemos = Pager(PagingConfig(pageSize = EXPLORE_PAGE_SIZE)) {
        ExplorePagingSource(memoRepository)
    }.flow.cachedIn(viewModelScope)
}