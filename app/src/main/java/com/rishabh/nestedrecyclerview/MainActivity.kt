package com.rishabh.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rishabh.nestedrecyclerview.adapter.ParentAdapter
import com.rishabh.nestedrecyclerview.databinding.ActivityMainBinding
import com.rishabh.nestedrecyclerview.factory.DataFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val data = DataFactory.getParentList()
        binding.rvItems.adapter = ParentAdapter(data)

    }
}