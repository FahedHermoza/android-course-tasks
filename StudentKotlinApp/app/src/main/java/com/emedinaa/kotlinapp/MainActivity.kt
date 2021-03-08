package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.emedinaa.kotlinapp.model.Student

/**
 * @author Eduardo Medina
 */
class MainActivity : AppCompatActivity(),OnStudentListener {

    private lateinit var studentsFragment: StudentsFragment
    private lateinit var studentDetailFragment: StudentDetailFragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        studentDetailFragment = fragmentManager.findFragmentById(R.id.fragmentStudentDetail) as StudentDetailFragment
        studentsFragment = fragmentManager.findFragmentById(R.id.fragmentStudents) as StudentsFragment
    }



    override fun selectedItemProduct(student: Student) {
        studentDetailFragment.renderStudent(student)
    }

    override fun renderFirst(student: Student?) {
        student?.let { selectedItemProduct(it) }
    }
}